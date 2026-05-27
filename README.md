# poc-modern-switch


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


## O que essa POC demonstra

Feature Java 25	Onde:
- Primitive Types in switch: FraudDecisionEngine
- Pattern Matching: switch(int)
- switch moderno: regras de decisão

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