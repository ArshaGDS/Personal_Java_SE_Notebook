package com.arsha.fundamentals.basics;

public class StringFormats {

	public void PrintFloat() {
		
		String PI_Number1 = String.format("PI with one fraction digit: %.1f", Math.PI);
		String PI_Number2 = String.format("PI with one fraction digit: %.2f", Math.PI);
		String PI_Number3 = String.format("PI with one fraction digit: %.3f", Math.PI);
		String PI_Number4 = String.format("PI with one fraction digit: %.4f", Math.PI);
		
		System.out.println(PI_Number1 + "\n" + PI_Number2 + "\n" + PI_Number3 + "\n" + PI_Number4);
	}
}
