package pl.szlify.mail_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.szlify.mail_service.model.ConfirmationData;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfirmationDataListener {

    private final EmailService emailService;

    @RabbitListener(queues = "${rabbit.confirmation-data-queue}")
    public void receiveConfirmationData(ConfirmationData confirmationData){
        log.info("Received from queue: {}, " + confirmationData);
        emailService.sendEmail(confirmationData);
    }
}
