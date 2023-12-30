package com.basbase.service.impl;

import com.basbase.data.Photos;
import com.basbase.data.PictureResponse;
import com.basbase.mapper.PictureMapper;
import com.basbase.service.PhotoStealer;
import com.basbase.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@Service
@RequiredArgsConstructor
public class NasaPhotoStealer implements PhotoStealer {

    @Value("${api.host}")
    private String host;
    @Value("${api.path}")
    private String path;
    @Value("${api.key}")
    private String key;

    private final WebClient webClient;
    private final PictureService pictureService;
    private final PictureMapper pictureMapper;

    @Override
    public Mono<List<PictureResponse>> stealPhotoBy(int sol) {
//        var srcs = webClient.get()
//                .uri(host, b -> b.path(path)
//                        .queryParam("sol", sol)
//                        .queryParam("api_key", key)
//                        .build())
//                .retrieve()
//                .bodyToMono(JsonNode.class)
//                .map(jn -> jn.get("photos"))
//                .block();
        var photos = webClient.get()
                .uri(host, b -> b.path(path)
                        .queryParam("sol", sol)
                        .queryParam("api_key", key)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Photos.class)
                .flatMapIterable(Photos::getPhotos)
                .map(pictureService::savePicture)
                .map(pictureMapper::toPictureResponseBody)
                .collectList();
        return photos;
    }
}
