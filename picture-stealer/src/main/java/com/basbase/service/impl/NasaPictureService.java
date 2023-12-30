package com.basbase.service.impl;

import com.basbase.data.PictureInfo;
import com.basbase.entity.Picture;
import com.basbase.mapper.PictureMapper;
import com.basbase.repo.PictureRepository;
import com.basbase.service.CameraService;
import com.basbase.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.Long.valueOf;
import static java.util.Objects.nonNull;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Service
@RequiredArgsConstructor
public class NasaPictureService implements PictureService {

    private final PictureRepository pictureRepository;
    private final CameraService cameraService;
    private final PictureMapper pictureMapper;

    @Override
    public Picture savePicture(PictureInfo pictureInfo) {
        var picture = pictureRepository.findPictureByNasaId(valueOf(pictureInfo.getNasaId()));
        if (nonNull(picture)) {
            return picture;
        }

        picture = pictureMapper.toPicture(pictureInfo);
        var camera = cameraService.saveCameraIfAbsent(pictureInfo.getCameraInfo());
        picture.setCamera(camera);

        return pictureRepository.save(picture);
    }
}
