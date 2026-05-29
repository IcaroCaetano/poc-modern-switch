# poc-modern-switch

## Architecture

````plantuml
fraud-decision-engine
│
├── Main.java
│
├── engine
│   └── FraudDecisionEngine.java
│
├── model
│   ├── FraudAnalysis.java
│   ├── Decision.java
│   ├── RiskLevel.java
│   └── ProviderType.java
│
├── provider
│   ├── BureauProvider.java
│   ├── DeviceProvider.java
│   ├── GeoProvider.java
│   └── BehavioralProvider.java
│
└── service
    └── FraudAnalysisService.java
````


## What this POC demonstrates

Java Feature 25 Where:

- Primitive Types in switch: FraudDecisionEngine
- Pattern Matching: switch(int)
- Modern switch: decision rules


## 1. Modern Switch

Demo:

````java
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
````

### yield

Java needs to know:

- what value should be returned.
- That's where yield comes in.

  
## Output
````text
Calling Bureau Provider...
Calling Device Provider...
Calling Geo Provider...
Calling Behavioral Provider...
Evaluating fraud rules...
Final Risk Score: 85
HIGH RISK CUSTOMER

FINAL ANALYSIS
FraudAnalysis[bureauScore=820, deviceRisk=35, geoRisk=20, behavioralRisk=15]

FINAL DECISION
REJECTED

````
