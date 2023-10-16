package testcase;

import lombok.*;

@Data
@Setter(AccessLevel.NONE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataRoot {
  private AbstractDataEntry entry;
}
