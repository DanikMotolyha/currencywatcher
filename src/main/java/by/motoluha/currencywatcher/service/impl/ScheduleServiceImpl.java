package by.motoluha.currencywatcher.service.impl;

import by.motoluha.currencywatcher.dto.CoinLoreCurrency;
import by.motoluha.currencywatcher.helper.CoinLoreClientHelper;
import by.motoluha.currencywatcher.model.Currency;
import by.motoluha.currencywatcher.model.CurrencyType;
import by.motoluha.currencywatcher.model.UserCurrency;
import by.motoluha.currencywatcher.repository.CurrencyRepository;
import by.motoluha.currencywatcher.repository.CurrencyTypeRepository;
import by.motoluha.currencywatcher.repository.UserCurrencyRepository;
import by.motoluha.currencywatcher.service.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@EnableScheduling
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private CoinLoreClientHelper coinLoreClientHelper;

    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyTypeRepository currencyTypeRepository;

    @Scheduled(fixedRate = 60000)
    @Override
    public void updateCurrencyAndNotifyUsersIfNeeded() {
        updateCurrency(currencyTypeRepository.findAll());

        List<UserCurrency> allUsers = userCurrencyRepository.findAll();
        Map<Long, Double> codeToPrice = currencyRepository.findAll().stream()
                .collect(Collectors.toMap(currency ->
                        currency.getCurrencyType().getId(), Currency::getPrice));
        allUsers.forEach(user -> {
            double userPrice = user.getPrice();
            double currentPrice = codeToPrice.get(user.getCurrencyType().getId());
            double percentagePriceChange = getPercentagePriceChange(userPrice, currentPrice);
            if (percentagePriceChange > 1) {
                log.warn("WARN :" + user.getName() + " price change : old " + userPrice
                        + " : new " + currentPrice + " : dif(%) " + percentagePriceChange);
            }
        });
    }

    private void updateCurrency(List<CurrencyType> currencyTypes) {
        currencyTypes.forEach(currencyType -> {
            try {
                Optional<CoinLoreCurrency> currencyByCode = coinLoreClientHelper
                        .getCurrencyByCode(currencyType.getId());
                if (currencyByCode.isEmpty()) {
                    log.error("Can not find info about currency: " + currencyTypes);
                } else {
                    Optional<Currency> currencyByTypeId = currencyRepository
                            .findCryptoCurrencyByTypeId(currencyType.getId());
                    if (currencyByTypeId.isPresent()) {
                        Currency currency = currencyByTypeId.get();
                        currency.setPrice(currencyByCode.get().getPrice());
                        currencyRepository.save(currency);
                    } else {
                        currencyRepository.save(Currency.builder()
                                .currencyType(currencyType)
                                .price(currencyByCode.get().getPrice())
                                .build());
                    }
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        });
    }

    private static double getPercentagePriceChange(double oldPrice, double newPrice) {
        return (newPrice - oldPrice) / oldPrice * 100;
    }
}
