package tech.ineb.adp.api.tcs.config;

import com.amazonaws.regions.Regions;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration @ConfigurationProperties(prefix = "s3")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class S3Config {
  private String host;
  private Integer port;
  @Builder.Default
  private Regions region = Regions.EU_CENTRAL_1;
  private String bucket;
  private String accessKeyId;
  private String secretAccessKey;
}
