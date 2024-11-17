package com.tutorial.backend.controller.dto;

import lombok.Data;

@Data
public class CalibrationResponse {
    private String status;
    private DistortionAnalysis distortionAnalysis;
    private String cameraModelUsed;
    private DistortionScores distortionScores;
    private CameraParameters cameraParameters;
    private String comparisonPlot;

    @Data
    public static class DistortionAnalysis {
        private boolean hasDistortion;
        private double distortionScore;
        private String severity;
        private Details details;
        private String recommendation;

        @Data
        public static class Details {
            private double pixelDifference;
            private double edgeDifference;
            private double structuralSimilarity;
        }
    }

    @Data
    public static class DistortionScores {
        private double pinhole;
        private double simpleRadial;
        private double simpleDivisional;
    }

    @Data
    public static class CameraParameters {
        private double[] focalLength;
        private double[] principalPoint;
        private double[] size;
        private double hfov;
        private double vfov;
    }
}
