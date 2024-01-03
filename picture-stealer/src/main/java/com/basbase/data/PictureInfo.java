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
public class PictureInfo {
    @JsonProperty("id")
    private Integer nasaId;

    private Integer sol;
    @JsonProperty("camera")
    private CameraInfo cameraInfo;
    @JsonProperty("img_src")
    private String imgSrc;
    @JsonProperty("earth_date")
    private String earthData;
}
