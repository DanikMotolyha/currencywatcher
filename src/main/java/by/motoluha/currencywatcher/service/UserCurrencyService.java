package by.motoluha.currencywatcher.service;

import by.motoluha.currencywatcher.dto.UserNotify;
import by.motoluha.currencywatcher.model.UserCurrency;

/**
 * interface for {@link UserCurrency}
 */
public interface UserCurrencyService {

    /**
     * register user with current price
     *
     * @param userNotify dto for {@link UserCurrency}
     */
    void register(UserNotify userNotify);
}
