package main;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect	// 핵심 기능을 구현할 클래스
public class AopCalculator {
	
	@Around("aopex.ProxyPointcut.calculatorTarget()")	// 공통기능 수행할 기능
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
		// ProceedingJoinPoint - proceed() -> 핵심 메서드 호출
		
		// 핵심 기능 수행전 공통기능
		long start = System.nanoTime();
		
		Object result = joinPoint.proceed();	// Calculator:factorial
		
		// 핵심 기능 수행 후 공통 기능
		long end = System.nanoTime();
		
		System.out.printf("걸린 시간 = %d%n", end - start);
		
		return result;
	}
}
