package by.motoluha.currencywatcher.service.impl;

import by.motoluha.currencywatcher.model.CurrencyType;
import by.motoluha.currencywatcher.repository.CurrencyTypeRepository;
import by.motoluha.currencywatcher.service.CurrencyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyTypeServiceImpl implements CurrencyTypeService {

    @Autowired
    private CurrencyTypeRepository currencyTypeRepository;

    @Override
    public List<CurrencyType> getAllCurrencyTypes() {
        return currencyTypeRepository.findAll();
    }
}
