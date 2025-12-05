package pl.szlify.mail_service.model;

import lombok.Data;

@Data
public class ConfirmationData {

    private CurrencyConversionResponseDto response;
    private String email;
}
