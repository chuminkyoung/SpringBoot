package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aopex.Calculator;
import aopex.RecCalculator;

@Configuration
@EnableAspectJAutoProxy	// 기능을 대신 수행
public class AppCtx {
	@Bean
	public AopCalculator aopCalculator() {
		return new AopCalculator();
	}
	
	@Bean
	public Calculator calculator() {
		return new RecCalculator();
	}
}
