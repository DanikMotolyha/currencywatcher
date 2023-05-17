package by.motoluha.currencywatcher.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "CRYPTO_CURRENCY_TYPE")
public class CurrencyType {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "crypto_name", nullable = false)
    private String name;
}
