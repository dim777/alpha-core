package tech.ineb.adp.api.tcs.integration;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class MarketAdaptersRegistryTest {
  @Test
  public void ini0() {
    Optional<String> emptyOp = Optional.empty();
    String a = emptyOp.orElse("a");
    Assert.assertEquals("a", a);
  }

  @Test
  public void ini1() {
    Optional<String> emptyOp = Optional.of("123");
    String a = emptyOp.orElse("a");
    Assert.assertEquals("123", a);
  }

  @Test
  public void ini2() {
    Optional<String> emptyOp = Optional.of("123");
    String a = emptyOp.
        map(v -> v + "4")
        .orElse(getA());
    Assert.assertEquals("1234", a);
  }

  @Test
  public void ini3() {
    Optional<String> emptyOp = Optional.of("123");
    String a = emptyOp.
        map(v -> v + "4")
        .orElseGet(MarketAdaptersRegistryTest::getA);
    Assert.assertEquals("1234", a);
  }

  static String getA() {
    System.out.println("blah");
    return "a";
  }
}