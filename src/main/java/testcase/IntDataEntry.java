package testcase;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
public class IntDataEntry implements AbstractDataEntry {
  private Discriminator discriminator;
  private int intValue;
}
