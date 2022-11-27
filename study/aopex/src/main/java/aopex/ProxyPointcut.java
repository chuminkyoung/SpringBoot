package aopex;

import org.aspectj.lang.annotation.Pointcut;

public class ProxyPointcut {
	// 접근제한자 반환값 패키지명.클래스명 메서드 (...) <- 메서드 매개변수
	// public *
	// * -> 모든 값
	
	// public * aopex.* -> aopex 하위에 있는 모든 메서드
	
	// aopex.* aopex 패키지 바로 하위에 있는 모든 클래스명
	// aopex..* -> aopex 패키지를 포함하고 그 하위의 모든 패키지의 클래스 
	// aopex.sub.
	
	// () -> 매개변수가 없는 메서드
	
	// (..) -> 0개 이상의 매개변수(매개변수가 있어도 되고 없어도 되는 - 모든 메서드)
	
	// (*) -> 1개의 매개변수
	// (*,*) -> 2개의 매개변수
	// (Integer, ..) -> 첫번째 매개변수의 타입은 Integer    // ex) (Long, ..)
	
	@Pointcut("execution(public long aopex..*(..))") // 실행될 범위  aopex 안에 있는 long ... 
	public void calculatorTarget() {}
}
