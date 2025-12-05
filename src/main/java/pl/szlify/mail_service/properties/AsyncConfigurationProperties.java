package pl.szlify.mail_service.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "executor")
@Getter
@Setter
public class AsyncConfigurationProperties {

    private int max;
    private int core;
    private int queue;
    private String name;
}
