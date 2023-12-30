package com.basbase.mapper;

import com.basbase.data.CameraInfo;
import com.basbase.entity.Camera;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Mapper
public interface CameraMapper {

    @Mapping(target = "id", ignore = true)
    Camera toCamera(CameraInfo cameraInfo);
}
