package testcase;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

  public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();

    readIntEntry(mapper);
    readStringEntry(mapper);
    writeStringEntry(mapper);
  }

  public static void readIntEntry(ObjectMapper mapper) {
    try {
      System.out.println("Reading an int entry");
      DataRoot root = mapper.readValue(
          "{\"entry\" : {\"discriminator\": \"INT\", \"intValue\": 42}}",
          DataRoot.class
      );
      assert(root.getEntry() instanceof IntDataEntry);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void readStringEntry(ObjectMapper mapper) {
    try {
      System.out.println("Reading a string entry");
      DataRoot root = mapper.readValue(
          "{\"entry\" : {\"discriminator\": \"STRING\", \"stringValue\": \"petunia\"}}",
          DataRoot.class
      );
      assert(root.getEntry() instanceof StringDataEntry);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void writeStringEntry(ObjectMapper mapper) {
    try {
      System.out.println("Writing a string entry");
      DataRoot data = new DataRoot(IntDataEntry.builder().intValue(42).build());
      mapper.writeValueAsString(data);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
