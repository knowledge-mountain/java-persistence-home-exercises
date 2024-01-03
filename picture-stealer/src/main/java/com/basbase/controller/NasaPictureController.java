package com.basbase.controller;

import com.basbase.data.PictureResponse;
import com.basbase.data.SolRequestBody;
import com.basbase.service.PhotoStealer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Viktor Basanets
 * @Project: picture-stealer
 */
@RestController
@RequestMapping("/pictures")
@RequiredArgsConstructor
public class NasaPictureController {

    private final PhotoStealer photoStealer;

    @PostMapping("/steal")
    public Mono<ResponseEntity<List<PictureResponse>>> steal(@RequestBody SolRequestBody body) {
        return photoStealer.stealPhotoBy(body.getSol())
                .map(ResponseEntity::ok);
    }
}
