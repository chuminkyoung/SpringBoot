package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

import aopex.Calculator;
import aopex.RecCalculator;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true) // Class 기반 프록시, 기본값 Interface 기반 프록시
public class AppCtx2 {
	
	@Bean
	@Order(1)	// 순서
	public AopCache aopCache() {
		return new AopCache();
	}
	
	@Bean
	@Order(2)
	public AopCalculator aopCaculator() {
		return new AopCalculator();
	}
	
	@Bean
	public RecCalculator calculator() {
		return new RecCalculator();
	}
}
