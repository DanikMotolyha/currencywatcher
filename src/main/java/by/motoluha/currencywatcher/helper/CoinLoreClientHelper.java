package by.motoluha.currencywatcher.helper;

import by.motoluha.currencywatcher.dto.CoinLoreCurrency;

import java.io.IOException;
import java.util.Optional;

/**
 * ClientHelper for api CoinLore
 */
public interface CoinLoreClientHelper {

    /**
     * get {@link CoinLoreCurrency} from api CoinLore by id
     * @param code numeric name of cryptocurrency
     * @return {@link CoinLoreCurrency} from CoinLore api
     */
    Optional<CoinLoreCurrency> getCurrencyByCode(Long code) throws IOException;
}
