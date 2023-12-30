package com.basbase.data;

import lombok.Data;

import java.time.LocalDate;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Data
public class PictureResponse {
    private Long id;
    private Long nasaId;
    private String imgSrc;
    private Long cameraId;
    private LocalDate createdAt;
}
