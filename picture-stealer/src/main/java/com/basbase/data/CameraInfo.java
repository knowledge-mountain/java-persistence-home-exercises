package com.basbase.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CameraInfo {
    @JsonProperty("id")
    private Integer nasaId;
    private String name;
}
