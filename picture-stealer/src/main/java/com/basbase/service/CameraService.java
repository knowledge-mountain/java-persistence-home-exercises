package com.basbase.service;

import com.basbase.data.CameraInfo;
import com.basbase.entity.Camera;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
public interface CameraService {
    Camera saveCameraIfAbsent(CameraInfo cameraInfo);
}
