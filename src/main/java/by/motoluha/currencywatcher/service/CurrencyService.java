package by.motoluha.currencywatcher.service;

import by.motoluha.currencywatcher.model.Currency;
import by.motoluha.currencywatcher.model.CurrencyType;

import java.util.Optional;

/**
 * intefrace for {@link Currency}.
 */
public interface CurrencyService {

    /**
     * find {@link Currency} using id from {@link CurrencyType}.
     *
     * @param id {@link CurrencyType} id
     * @return optional of {@link Currency}
     */
    Optional<Currency> getCurrentCurrencyByTypeId(Long id);
}
