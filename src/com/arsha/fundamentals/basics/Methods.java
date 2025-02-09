package com.arsha.fundamentals.basics;

import java.util.Arrays;

public class Methods {

	public static void main (String[] args) {
		
		int[] array = { 1 ,2 ,3 };
		
		modifyArray(array);
		System.out.println(Arrays.toString(array));
		
		clearArray(array);
		System.out.println(Arrays.toString(array));
		
		setElementsToDefault(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void modifyArray(int[] inArray) {
		
		inArray [1] = 100;
	}
	
	public static void clearArray(int[] inArray) {
		
		inArray = null;
	}
	
	public static void setElementsToDefault(int[] inArray) {
		
		Arrays.fill(inArray, 0);
	}
}
