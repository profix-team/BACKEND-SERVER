package com.tutorial.backend.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FileUploadResponse {
    private Long fileId;
    private String fileUrl;
    private String fileName;
    private CalibrationResponse calibrationResult;

    // 필요한 경우 추가 필드 정의 가능
}
