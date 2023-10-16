package testcase;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

@JsonTypeInfo(
    use = Id.CUSTOM,
    include = As.EXISTING_PROPERTY,
    property = "discriminator",
    visible = true
)
@JsonTypeIdResolver(DiscriminatorResolver.class)
public interface AbstractDataEntry {
  Discriminator getDiscriminator();
}

