package net.df.boot.web.config;

import net.df.boot.web.properties.WebProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        WebProperties.class
})
public class WebConfig {

}
