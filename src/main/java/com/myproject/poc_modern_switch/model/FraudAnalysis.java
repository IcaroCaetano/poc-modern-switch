package com.myproject.poc_modern_switch.model;

public record FraudAnalysis(

        int bureauScore,
        int deviceRisk,
        int geoRisk,
        int behavioralRisk
) {}