package by.motoluha.currencywatcher.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinLoreCurrency {

    @JsonProperty("id")
    private String id;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nameid")
    private String nameId;

    @JsonProperty("rank")
    private String rank;

    @JsonProperty("price_usd")
    private Double price;

    @JsonProperty("percent_change_24h")
    private Double percentChange24h;

    @JsonProperty("percent_change_1h")
    private Double percentChange1h;

    @JsonProperty("percent_change_7d")
    private Double percentChange7d;

    @JsonProperty("market_cap_usd")
    private Double marketCapUsd;

    @JsonProperty("volume24")
    private Double volume24;

    @JsonProperty("volume24_native")
    private Double volume24Native;

    @JsonProperty("csupply")
    private Double cSupply;

    @JsonProperty("price_btc")
    private Double priceBtc;

    @JsonProperty("tsupply")
    private Double tSupply;

    @JsonProperty("msupply")
    private Double mSupply;
}

