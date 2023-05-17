package by.motoluha.currencywatcher.service.impl;

import by.motoluha.currencywatcher.dto.UserNotify;
import by.motoluha.currencywatcher.model.Currency;
import by.motoluha.currencywatcher.model.UserCurrency;
import by.motoluha.currencywatcher.repository.CurrencyRepository;
import by.motoluha.currencywatcher.repository.UserCurrencyRepository;
import by.motoluha.currencywatcher.service.ScheduleService;
import by.motoluha.currencywatcher.service.UserCurrencyService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCurrencyServiceImpl implements UserCurrencyService {

    @Autowired
    private UserCurrencyRepository userCurrencyRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public void register(UserNotify userNotify) {
        Optional<Currency> currencyByTypeId = currencyRepository.findCryptoCurrencyByTypeId(userNotify.getCurrencyCode());

        if (currencyByTypeId.isEmpty()) {
            throw new ObjectNotFoundException(currencyByTypeId,
                    "cannot find currency type by code" + userNotify.getCurrencyCode());
        }

        Currency currency = currencyByTypeId.get();
        UserCurrency userCurrency = createUserCurrency(userNotify.getUserName(), currency.getPrice(), currency);
        userCurrencyRepository.save(userCurrency);

        scheduleService.updateCurrencyAndNotifyUsersIfNeeded();
    }

    private UserCurrency createUserCurrency(String name, double price, Currency currency) {
        return UserCurrency.builder()
                .name(name)
                .price(price)
                .currencyType(currency.getCurrencyType())
                .build();
    }
}
