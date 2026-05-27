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