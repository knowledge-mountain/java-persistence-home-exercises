package com.basbase.service;

import com.basbase.data.PictureInfo;
import com.basbase.entity.Picture;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
public interface PictureService {
    Picture savePicture(PictureInfo pictureInfo);
}
