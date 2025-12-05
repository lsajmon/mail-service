package pl.szlify.mail_service.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rabbit")
@Getter
@Setter
public class RabbitMQProperties {

    private String confirmationDataQueue;
}