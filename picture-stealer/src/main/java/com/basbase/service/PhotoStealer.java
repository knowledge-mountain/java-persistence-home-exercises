package com.basbase.service;

import com.basbase.data.PictureResponse;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
public interface PhotoStealer {
    Mono<List<PictureResponse>> stealPhotoBy(int sol);
}
