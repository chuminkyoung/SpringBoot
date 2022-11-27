package main;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopCache {
	
	private Map<Long, Object> cache = new HashMap<>();
	
	/**
	@Pointcut("execution(public long aopex..* (..))")
	private void cacheTarget() {}
	
	@Around("cacheTarget()")
	*/
	
	// @Around("execution(pubic long aopex..* (..))")
	@Around("aopex.ProxyPointcut.calculatorTarget()")
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
		// ProceedingJoinPoint :getArgs() -> 매개변수
		Long num = (Long)joinPoint.getArgs()[0];
		if(cache.containsKey(num)) {
			System.out.printf("캐시에서 결과값 가져옴..(%d)%n", num);
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed();
		
		cache.put(num,  result);
		System.out.printf("캐시에서 저장....(%d)%n", num);
		
		return result;
	}
}
