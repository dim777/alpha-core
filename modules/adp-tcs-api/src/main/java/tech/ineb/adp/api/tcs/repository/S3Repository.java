package tech.ineb.adp.api.tcs.repository;

import java.net.URI;
import java.nio.file.Path;

public interface S3Repository {
  URI save(Path file);

  Path read(String fileName);
}
