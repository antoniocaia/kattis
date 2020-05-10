package kattis;

import java.math.BigInteger;
import java.util.Scanner;

public class AngramCounting {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		while (scanner.hasNextLine()) {
			char[] input = scanner.nextLine().toCharArray();
			int[] freq = new int[58];

			for (int i = 0; i < input.length; i++) {
				freq[input[i] - 65]++;
			}
			
			BigInteger num = factorial(BigInteger.valueOf(input.length));
			BigInteger den = BigInteger.ONE;
			for (int e : freq) {
				den = den.multiply(factorial(BigInteger.valueOf(e)));
			}
			System.out.println((num.divide(den)).toString());
		}
		
	}

	private static BigInteger factorial(BigInteger n) {
		if (n.compareTo(BigInteger.ONE) <= 0)
			return BigInteger.ONE;

		return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}

}
