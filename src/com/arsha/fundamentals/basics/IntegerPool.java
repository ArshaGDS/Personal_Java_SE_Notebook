package com.arsha.fundamentals.basics;

public class IntegerPool {

	public static void main(String[] args) {

		Integer inti1 = 10;
		Integer inti2 = 10;

        /* Integer pool is between -128 until 127 */
		Integer inti3 = -129;
		Integer inti4 = -129;
		
		System.out.println("Is inti1 == inti2 ? " + (inti1 == inti2));
		System.out.println("Is inti3 == inti4 ? " + (inti3 == inti4));
	}
}
