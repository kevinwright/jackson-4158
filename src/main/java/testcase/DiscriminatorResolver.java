package testcase;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import java.util.Map;

public class DiscriminatorResolver implements TypeIdResolver {

  private JavaType superType;
  private static final Map<String, Class<?>> CLASS_TYPES;

  static {
    CLASS_TYPES = Map.ofEntries(
        Map.entry("STRING", StringDataEntry.class),
        Map.entry("INT", IntDataEntry.class)
    );
  }

  @Override
  public void init(JavaType baseType) {
    superType = baseType;
  }

  @Override
  public JsonTypeInfo.Id getMechanism() {
    return JsonTypeInfo.Id.NAME;
  }

  @Override
  public String idFromValue(Object obj) {
    return idFromValueAndType(obj, obj.getClass());
  }

  @Override
  public String idFromValueAndType(Object obj, Class<?> subType) {
    return null;
  }

  @Override
  public String idFromBaseType() {
    return null;
  }

  @Override
  public JavaType typeFromId(DatabindContext context, String id) {
    return context.constructSpecializedType(superType, CLASS_TYPES.get(id));
  }

  @Override
  public String getDescForKnownTypeIds() {
    return null;
  }
}
