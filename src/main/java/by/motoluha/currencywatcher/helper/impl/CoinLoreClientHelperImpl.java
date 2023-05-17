package by.motoluha.currencywatcher.helper.impl;

import by.motoluha.currencywatcher.dto.CoinLoreCurrency;
import by.motoluha.currencywatcher.helper.CoinLoreClientHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CoinLoreClientHelperImpl implements CoinLoreClientHelper {

    private static final String API_URL = "https://api.coinlore.net/api/ticker/?id=";

    @Override
    public Optional<CoinLoreCurrency> getCurrencyByCode(Long code) throws IOException {
        URL url = new URL(API_URL + code);
        HttpURLConnection connection = (HttpsURLConnection) url.openConnection();
        String response;
        try (InputStream stream = connection.getInputStream()) {
            response = new Scanner(stream).useDelimiter("\\A").next();
        }
        return parse(response);
    }

    private Optional<CoinLoreCurrency> parse(String raw) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        CoinLoreCurrency[] result = mapper.readValue(raw, CoinLoreCurrency[].class);
        if(result.length == 0){
            return Optional.empty();
        }
        return Optional.ofNullable(result[0]);
    }
}
