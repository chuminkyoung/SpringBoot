package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopex.Calculator;

public class Ex03 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		// Calculator 불러오기 
		Calculator cal = ctx.getBean(Calculator.class);
		long result = cal.factorial(10);
		System.out.println(result);
		System.out.println(cal.getClass().getName());
	}

}
