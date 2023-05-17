package by.motoluha.currencywatcher.repository;

import by.motoluha.currencywatcher.model.Currency;
import by.motoluha.currencywatcher.model.UserCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link Currency} class.
 */
@Repository
public interface UserCurrencyRepository extends JpaRepository<UserCurrency, Long> {
}
