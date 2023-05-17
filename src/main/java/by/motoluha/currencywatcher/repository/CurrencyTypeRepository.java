package by.motoluha.currencywatcher.repository;

import by.motoluha.currencywatcher.model.CurrencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link CurrencyType} class.
 */
@Repository
public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Long> {
}
