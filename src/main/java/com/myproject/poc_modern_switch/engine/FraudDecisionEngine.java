package com.myproject.poc_modern_switch.engine;

import com.myproject.poc_modern_switch.model.Decision;
import com.myproject.poc_modern_switch.model.FraudAnalysis;

public class FraudDecisionEngine {

    public Decision evaluate(FraudAnalysis analysis) {

        System.out.println("Evaluating fraud rules...");

        int finalRisk = calculateFinalRisk(analysis);

        System.out.println("Final Risk Score: " + finalRisk);

        /*
         * JAVA 25 FEATURE
         * Primitive Types in switch
         */
        return switch (finalRisk) {

            case int score when score <= 20 -> {

                System.out.println("LOW RISK CUSTOMER");

                yield Decision.APPROVED;
            }

            case int score when score <= 60 -> {

                System.out.println("MEDIUM RISK CUSTOMER");

                yield Decision.MANUAL_REVIEW;
            }

            case int score when score > 60 -> {

                System.out.println("HIGH RISK CUSTOMER");

                yield Decision.REJECTED;
            }

            default -> throw new IllegalStateException("Unexpected risk score");
        };
    }

    private int calculateFinalRisk(
            FraudAnalysis analysis
    ) {

        int bureauRisk = calculateBureauRisk(analysis.bureauScore());

        return bureauRisk
                + analysis.deviceRisk()
                + analysis.geoRisk()
                + analysis.behavioralRisk();
    }

    /*
     * JAVA 25 FEATURE
     * Primitive pattern matching with int
     */
    private int calculateBureauRisk(int bureauScore) {

        return switch (bureauScore) {

            case int score when score >= 900 -> 5;

            case int score when score >= 700 -> 15;

            case int score when score >= 500 -> 40;

            case int score when score < 500 -> 80;

            default -> 100;
        };
    }
}