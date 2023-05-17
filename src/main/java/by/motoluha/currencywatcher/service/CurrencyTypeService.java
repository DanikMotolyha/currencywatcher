package by.motoluha.currencywatcher.service;

import by.motoluha.currencywatcher.model.CurrencyType;

import java.util.List;

/**
 * intefrace for {@link CurrencyType}
 */
public interface CurrencyTypeService {

    /**
     * get all {@link CurrencyType} from db
     *
     * @return list of {@link CurrencyType}
     */
    List<CurrencyType> getAllCurrencyTypes();
}
