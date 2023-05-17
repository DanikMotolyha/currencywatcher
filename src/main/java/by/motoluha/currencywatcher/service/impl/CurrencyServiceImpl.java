package by.motoluha.currencywatcher.service.impl;

import by.motoluha.currencywatcher.model.Currency;
import by.motoluha.currencywatcher.repository.CurrencyRepository;
import by.motoluha.currencywatcher.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public Optional<Currency> getCurrentCurrencyByTypeId(Long id) {
        return currencyRepository.findCryptoCurrencyByTypeId(id);
    }
}
