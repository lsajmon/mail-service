package pl.szlify.mail_service.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CurrencyConversionResponseDto {

    private String from;
    private String to;
    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal result;
}
