package com.basbase.service.impl;

import com.basbase.data.CameraInfo;
import com.basbase.entity.Camera;
import com.basbase.mapper.CameraMapper;
import com.basbase.repo.CameraRepository;
import com.basbase.service.CameraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.Long.valueOf;
import static java.util.Objects.nonNull;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Service
@RequiredArgsConstructor
public class NasaCameraService implements CameraService {

    private final CameraRepository cameraRepository;
    private final CameraMapper cameraMapper;

    @Transactional
    @Override
    public Camera saveCameraIfAbsent(CameraInfo cameraInfo) {
        var camera = cameraRepository.findCameraByNasaId(valueOf(cameraInfo.getNasaId()));
        if (nonNull(camera)) {
            return camera;
        }
        camera = cameraMapper.toCamera(cameraInfo);
        return cameraRepository.save(camera);
    }
}
