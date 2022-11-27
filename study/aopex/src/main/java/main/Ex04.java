package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopex.Calculator;
import aopex.RecCalculator;

public class Ex04 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);
		
		RecCalculator cal = ctx.getBean(RecCalculator.class);
		long result = cal.factorial(10);
		System.out.println(result);
		
		System.out.println(cal.getClass().getName());
		//System.out.println(cal instanceof RecCalculator);
		//System.out.println(cal instanceof Calculator);
		
		/**
		result = cal.factorial(10);
		System.out.println(result);
		
		result = cal.factorial(10);
		System.out.println(result);
		
		result = cal.factorial(10);
		System.out.println(result);
		*/
		
		ctx.close();
	}

}
