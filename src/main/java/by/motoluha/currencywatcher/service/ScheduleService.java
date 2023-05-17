package by.motoluha.currencywatcher.service;

import by.motoluha.currencywatcher.model.Currency;

/**
 * intefrace for Schedule
 */
public interface ScheduleService {

    /**
     * update {@link Currency} entities using api CoinLore and notify users which price rise more than 1%
     */
    void updateCurrencyAndNotifyUsersIfNeeded();
}
