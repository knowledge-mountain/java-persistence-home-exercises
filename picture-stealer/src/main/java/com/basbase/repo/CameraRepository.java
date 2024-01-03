package com.basbase.repo;

import com.basbase.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
public interface CameraRepository extends JpaRepository<Camera, Long> {
    Camera findCameraByNasaId(Long nasaId);
}
