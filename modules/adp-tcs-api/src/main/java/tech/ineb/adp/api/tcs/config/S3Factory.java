package tech.ineb.adp.api.tcs.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration @Slf4j @AllArgsConstructor
public class S3Factory implements FactoryBean<AmazonS3> {
  private final S3Config config;

  @Override public AmazonS3 getObject() throws Exception {
    //noinspection StringBufferReplaceableByString
    String host = new StringBuilder("http://")
        .append(config.getHost())
        .append(":")
        .append(config.getPort())
        .toString();

    ClientConfiguration clientConfiguration = new ClientConfiguration();

    BasicAWSCredentials credentials = new BasicAWSCredentials(config.getAccessKeyId(), config.getSecretAccessKey());

    AmazonS3 s3Client = AmazonS3ClientBuilder
        .standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(host, Regions.EU_CENTRAL_1.getName()))
        .withPathStyleAccessEnabled(true)
        .withClientConfiguration(clientConfiguration)
        .withCredentials(new AWSStaticCredentialsProvider(credentials))
        .build();
    log.info("Initialized new s3client = {}", s3Client);
    return s3Client;
  }

  @Override public Class<?> getObjectType() {
    return AmazonS3.class;
  }

  @Override public boolean isSingleton() {
    return false;
  }
}
