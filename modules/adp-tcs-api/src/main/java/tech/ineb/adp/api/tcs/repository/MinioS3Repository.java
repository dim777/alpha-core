package tech.ineb.adp.api.tcs.repository;

import com.amazonaws.services.s3.AmazonS3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.nio.file.Path;

@Service @RequiredArgsConstructor @Slf4j
public class MinioS3Repository implements S3Repository {
  private final AmazonS3 s3Client;

  @Override public URI save(Path file) {
    File file = new File(uploadFileName);
    // Upload file
    s3Client.putObject(new PutObjectRequest(bucketName, keyName, file));
  }

  @Override public Path read(String fileName) {
    // Download file
    GetObjectRequest rangeObjectRequest = new GetObjectRequest(bucketName, keyName);
    S3Object objectPortion = s3Client.getObject(rangeObjectRequest);
  }
}
