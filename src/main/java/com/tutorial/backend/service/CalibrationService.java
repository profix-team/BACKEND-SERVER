package com.tutorial.backend.service;

import com.tutorial.backend.controller.dto.CalibrationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class CalibrationService {

    private final RestTemplate restTemplate;

    private static final String REQUEST_URL = "http://localhost:8000/calibrate";

    public CalibrationResponse calibrate(MultipartFile file) {
        // 헤더 구성
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        // 요청 본문 구성
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", new FileSystemResource(convertToFile(file)));

        // 요청 엔터티 생성
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // API 호출 및 결과 반환
        return restTemplate.postForObject(REQUEST_URL, requestEntity, CalibrationResponse.class);
    }

    private File convertToFile(MultipartFile multipartFile) {
        try {
            File convFile = File.createTempFile("upload", multipartFile.getOriginalFilename());
            multipartFile.transferTo(convFile);
            return convFile;
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert MultipartFile to File", e);
        }
    }
}
