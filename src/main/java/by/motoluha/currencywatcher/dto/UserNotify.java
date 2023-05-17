package by.motoluha.currencywatcher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserNotify {

    private String userName;
    private Long currencyCode;
}
