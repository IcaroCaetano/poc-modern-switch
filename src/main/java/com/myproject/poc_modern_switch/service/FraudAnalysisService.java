package com.myproject.poc_modern_switch.service;

import com.myproject.poc_modern_switch.model.FraudAnalysis;
import com.myproject.poc_modern_switch.provider.BehavioralProvider;
import com.myproject.poc_modern_switch.provider.BureauProvider;
import com.myproject.poc_modern_switch.provider.DeviceProvider;
import com.myproject.poc_modern_switch.provider.GeoProvider;

public class FraudAnalysisService {

    private final BureauProvider bureauProvider =
            new BureauProvider();

    private final DeviceProvider deviceProvider =
            new DeviceProvider();

    private final GeoProvider geoProvider =
            new GeoProvider();

    private final BehavioralProvider behavioralProvider =
            new BehavioralProvider();

    private final ProviderValueNormalizer normalizer =
            new ProviderValueNormalizer();

    public FraudAnalysis analyze(String cpf) {

        Object bureauValue =
                bureauProvider.analyze(cpf);

        Object deviceValue =
                deviceProvider.analyze(cpf);

        Object geoValue =
                geoProvider.analyze(cpf);

        Object behavioralValue =
                behavioralProvider.analyze(cpf);

        int bureauScore =
                normalizer.normalize(bureauValue);

        int deviceRisk =
                normalizer.normalize(deviceValue);

        int geoRisk =
                normalizer.normalize(geoValue);

        int behavioralRisk =
                normalizer.normalize(behavioralValue);

        return new FraudAnalysis(
                bureauScore,
                deviceRisk,
                geoRisk,
                behavioralRisk
        );
    }
}