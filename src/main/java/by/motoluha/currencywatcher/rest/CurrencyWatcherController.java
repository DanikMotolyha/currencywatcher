package by.motoluha.currencywatcher.rest;

import by.motoluha.currencywatcher.dto.UserNotify;
import by.motoluha.currencywatcher.model.Currency;
import by.motoluha.currencywatcher.model.CurrencyType;
import by.motoluha.currencywatcher.service.CurrencyService;
import by.motoluha.currencywatcher.service.CurrencyTypeService;
import by.motoluha.currencywatcher.service.UserCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/watcher/")
public class CurrencyWatcherController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CurrencyTypeService currencyTypeService;

    @Autowired
    private UserCurrencyService userCurrencyService;

    @GetMapping(path = "currency")
    public ResponseEntity<Double> getCurrencyPriceById(@RequestParam("id") Long cryptoCurrencyId) {
        Optional<Currency> currentCurrencyById = currencyService.getCurrentCurrencyByTypeId(cryptoCurrencyId);

        if (currentCurrencyById.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(currentCurrencyById.get().getPrice(), HttpStatus.OK);
    }

    @GetMapping(path = "currency_type")
    public ResponseEntity<List<CurrencyType>> getAllCurrencies() {
        List<CurrencyType> allCurrencyTypes = currencyTypeService.getAllCurrencyTypes();

        if (allCurrencyTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(allCurrencyTypes, HttpStatus.OK);
    }

    @PostMapping(path = "notify")
    public ResponseEntity<String> notifyUser(@RequestBody UserNotify userNotify) {
        userCurrencyService.register(userNotify);
        return new ResponseEntity<>("user " + userNotify.getUserName() + "  is registered", HttpStatus.OK);
    }
}
