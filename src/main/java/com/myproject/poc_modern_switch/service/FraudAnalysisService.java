package com.myproject.poc_modern_switch.service;

import com.myproject.poc_modern_switch.model.FraudAnalysis;
import com.myproject.poc_modern_switch.provider.BehavioralProvider;
import com.myproject.poc_modern_switch.provider.BureauProvider;
import com.myproject.poc_modern_switch.provider.DeviceProvider;
import com.myproject.poc_modern_switch.provider.GeoProvider;

public class FraudAnalysisService {

    private final BureauProvider bureauProvider = new BureauProvider();

    private final DeviceProvider deviceProvider = new DeviceProvider();

    private final GeoProvider geoProvider = new GeoProvider();

    private final BehavioralProvider behavioralProvider = new BehavioralProvider();

    public FraudAnalysis analyze(String cpf) {

        int bureauScore = bureauProvider.analyze(cpf);

        int deviceRisk = deviceProvider.analyze(cpf);

        int geoRisk = geoProvider.analyze(cpf);

        int behavioralRisk = behavioralProvider.analyze(cpf);

        return new FraudAnalysis(
                bureauScore,
                deviceRisk,
                geoRisk,
                behavioralRisk
        );
    }
}