package pl.szlify.mail_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import pl.szlify.mail_service.config.RabbitMQProperties;
import pl.szlify.mail_service.properties.AsyncConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		RabbitMQProperties.class,
		AsyncConfigurationProperties.class
})
@EnableAsync
public class MailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailServiceApplication.class, args);
	}

}
