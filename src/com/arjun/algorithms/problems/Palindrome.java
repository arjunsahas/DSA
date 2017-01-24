package com.arjun.algorithms.problems;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			String str = s.next();
			palindrome(str);
		}
	}

	private static void palindrome(String str) {
		int counter = 0;
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (c == 'a') {
				continue;
			}
			while (charArray[i] != 'a') {
				charArray[i] = (char) (charArray[i] - 1);
				counter++;
				String string = new String(charArray);
				if (string.equals(new StringBuilder(string).reverse()
						.toString())) {
					System.out.println(counter);
					break;
				}
			}
		}
	}
}
