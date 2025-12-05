package pl.szlify.mail_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.szlify.mail_service.model.ConfirmationData;
import pl.szlify.mail_service.model.CurrencyConversionResponseDto;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    @Async("asyncTaskExecutor")
    public void sendEmail(ConfirmationData confirmationData){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(confirmationData.getEmail());
        message.setSubject("Currency exchange confirmation");
        message.setText(mailText(confirmationData.getResponse()));
        mailSender.send(message);
        log.info("E-mail has been sent... ");
    }

    private static String mailText(CurrencyConversionResponseDto currencyExchange){
        return MessageFormat.format("""
                Dear customer,
                    we want to confirm your exchange
                        from: {0} {1}
                        to: {2}
                        with rate: {3}
                        
                    You will receive: {4} {2}
                """,
                currencyExchange.getAmount(),
                currencyExchange.getFrom(),
                currencyExchange.getTo(),
                currencyExchange.getRate(),
                currencyExchange.getResult()
        );
    }
}
