package tech.ineb.adp.api.tcs.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * This class maintains ...
 *
 * @author Dmitriy Erokhin d.erokhin@corp.mail.ru
 */
@Configuration @ConfigurationProperties(prefix = "market.data.tcs")
@Getter @Setter
public class TcsConfig {
  private String url;
  private String token;
}
