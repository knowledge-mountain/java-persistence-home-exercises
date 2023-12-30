package com.basbase.repo;

import com.basbase.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findPictureByNasaId(Long nasaId);
}
