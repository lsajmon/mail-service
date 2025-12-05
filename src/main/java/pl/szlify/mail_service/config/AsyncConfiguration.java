package pl.szlify.mail_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import pl.szlify.mail_service.properties.AsyncConfigurationProperties;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfiguration {

    @Bean
    public Executor asyncTaskExecutor (AsyncConfigurationProperties properties) {
        return new ThreadPoolTaskExecutor() {{
            setMaxPoolSize(properties.getMax());
            setCorePoolSize(properties.getCore());
            setQueueCapacity(properties.getQueue());
            setThreadNamePrefix(properties.getName());
            initialize();
        }};
    }
}
