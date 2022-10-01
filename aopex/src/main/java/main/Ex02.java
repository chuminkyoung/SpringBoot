package main;

import aopex.*;
public class Ex02 {

	public static void main(String[] args) {
		
		ProxyCalculator cal1 = new ProxyCalculator(new ImpeCalculator());	// 대신 수행
		ProxyCalculator cal2 = new ProxyCalculator(new RecCalculator());
		
		long result1 = cal1.factorial(10);
		long result2 = cal2.factorial(10);
		
		System.out.printf("cal1 = %d%n", result1);
		System.out.printf("cal2 = %d%n", result2);
	}

}
