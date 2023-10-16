package testcase;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
public class StringDataEntry implements AbstractDataEntry {
  private Discriminator discriminator;
  private String stringValue;
}
