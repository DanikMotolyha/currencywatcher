package by.motoluha.currencywatcher.repository;

import by.motoluha.currencywatcher.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for {@link Currency} class.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Query(value = "select * from crypto_currency where crypto_currency.id_crypto_currency_type = :id",
            nativeQuery = true)
    Optional<Currency> findCryptoCurrencyByTypeId(@Param("id") Long typeId);
}
