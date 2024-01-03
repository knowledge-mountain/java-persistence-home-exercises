package com.basbase.mapper;

import com.basbase.data.PictureInfo;
import com.basbase.data.PictureResponse;
import com.basbase.entity.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Mapper
public interface PictureMapper {

    @Mapping(target = "id", ignore = true)
    Picture toPicture(PictureInfo pictureInfo);

    @Mapping(target = "cameraId", expression = "java(picture.getCamera().getId())")
    PictureResponse toPictureResponseBody(Picture picture);
}
