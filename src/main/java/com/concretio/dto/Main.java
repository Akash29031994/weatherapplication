
package com.concretio.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

/*
 * Create by Akash Chaturvedi   
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "pressure",
    "humidity",
    "temp_min",
    "temp_max"
})
@Getter
@Setter
public class Main {

    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    private Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    private void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
