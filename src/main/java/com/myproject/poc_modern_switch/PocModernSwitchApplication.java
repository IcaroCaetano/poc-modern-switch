package com.myproject.poc_modern_switch;

import com.myproject.poc_modern_switch.engine.FraudDecisionEngine;
import com.myproject.poc_modern_switch.model.FraudAnalysis;
import com.myproject.poc_modern_switch.service.FraudAnalysisService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocModernSwitchApplication {

	public static void main(String[] args) {

		var fraudAnalysisService = new FraudAnalysisService();

		FraudAnalysis analysis = fraudAnalysisService.analyze("12345678900");

		var engine = new FraudDecisionEngine();

		var decision = engine.evaluate(analysis);

		System.out.println("\nFINAL ANALYSIS");
		System.out.println(analysis);

		System.out.println("\nFINAL DECISION");
		System.out.println(decision);
	}

}
