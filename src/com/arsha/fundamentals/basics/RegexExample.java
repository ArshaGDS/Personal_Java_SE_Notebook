package com.arsha.fundamentals.basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args) {

		extractGmailAddressFromText("Test@Gmail.com");
	}

	/**
	 * []    Repeating
	 * a-z   lower case alphabet
	 * A-Z   Upper case alphabet
	 * \\.   Dot
	 * \\d   All digits
	 * (?i)  Case-insensitive on
	 * (?-i) Case-insensitive off
	 * 
	 * @param inText Input text
	 */
	public static void extractGmailAddressFromText(String inText) {
		
		String emailPattern = "[a-zA-Z\\d]+@(?i)gmail\\.com(?-i)";
		
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(inText);
		
		boolean isFind = matcher.find();
		if (isFind) {

			String gmailAddress = matcher.group();
			System.out.println("Extracted Gmail Address: " + gmailAddress);
		}
	}
}
