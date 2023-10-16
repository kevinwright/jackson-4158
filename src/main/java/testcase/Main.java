package testcase;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

  public static void main(String[] args) {
    DataRoot data = new DataRoot(IntDataEntry.builder().intValue(42).build());
    ObjectMapper mapper = new ObjectMapper();
    try {
      DataRoot read1 = mapper.readValue(
          "{\"entry\" : {\"discriminator\": \"INT\", \"intValue\": 42}}",
          DataRoot.class
      );
      assert(read1.getEntry() instanceof IntDataEntry);

      DataRoot read2 = mapper.readValue(
          "{\"entry\" : {\"discriminator\": \"STRING\", \"stringValue\": \"petunia\"}}",
          DataRoot.class
      );
      assert(read2.getEntry() instanceof StringDataEntry);

      mapper.writeValueAsString(data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
