package tech.ineb.lib.common.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = {"equities"})
@ToString(exclude = {"equities"})
public class Currency implements Serializable {
  private UUID id;
  private UUID extId;
  private String name;
  private String alphabeticCode;
  private Integer numericCode;
  private Set<Security> equities = new HashSet<>();
}
