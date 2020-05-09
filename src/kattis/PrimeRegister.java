package kattis;

import java.util.Scanner;

public class PrimeRegister {
	private static final Scanner scanner = new Scanner(System.in);

	static int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19 };

	public static void main(String[] args) {
		String[] input = scanner.nextLine().split(" ");
		int[] reg = new int[input.length];
		for (int i = 0; i < reg.length; i++) {
			reg[i] = Integer.parseInt(input[i]);
		}

		int remainingInc = 0;
		while (incRegN(0, reg)) {
			remainingInc++;
		}
		System.out.println(remainingInc);
	}

	private static boolean incRegN(int i, int[] reg) {
		if (i > reg.length - 1)
			return false;

		reg[i]++;
		if (reg[i] >= prime[i]) {
			reg[i] = 0;
			return incRegN(i + 1, reg);
		}

		return true;
	}
}
