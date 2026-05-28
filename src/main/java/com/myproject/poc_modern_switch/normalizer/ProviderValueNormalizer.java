package com.myproject.poc_modern_switch.normalizer;

public class ProviderValueNormalizer {

    public int normalize(Object value) {

        if (value instanceof int score) {

            System.out.println(
                    "Integer score received: " + score
            );

            return score;
        }

        if (value instanceof long score) {

            System.out.println(
                    "Long score received: " + score
            );

            return (int) score;
        }

        if (value instanceof double score) {

            System.out.println(
                    "Double score received: " + score
            );

            return (int) score;
        }

        throw new IllegalArgumentException(
                "Unsupported provider value"
        );
    }
}