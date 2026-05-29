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

`Pattern Matching` was included in the Switch.

You used to have something like this:

````java
public class One {
   
public static void testSwitch()

    {
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday"); // This will execute
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }
    // OR
    public static testSwitchArrows(){
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Invalid day";
        };

        System.out.println(dayName);
    }
}
````
Now in Java 25

You can do:

````
case int score when score >= 900
````

- Where `int` defines the pattern type
- `score` captures the value of a variable
- Performs matching `when score >= 900`



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

The traditional switch statement simply executed code.

- It did not return any value,
- it only executed instructions..

No Java moderno, o switch pode retornar valor:

````java
String result = switch (status) {

    case 1 -> "Approved";

    case 2 -> "Rejected";

    default -> "Unknown";
};

// OR using yield

public int getScore(){
    return switch (score) {
    
            case int s when s >= 900 -> {
    
            System.out.println("VIP CUSTOMER");
    
    yield "APPROVED";
            }
    
    default -> {
    
    yield "REJECTED";
            }
    };
}
````

  
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
