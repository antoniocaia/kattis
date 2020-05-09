package kattis;

import java.util.Scanner;

public class PaulEigon {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] input = scanner.nextLine().split(" ");
		int servesPerRound = Integer.parseInt(input[0]);
		int paulScore = Integer.parseInt(input[1]);
		int oppoScore = Integer.parseInt(input[2]);

		if (((paulScore + oppoScore) / servesPerRound) % 2 == 0)
			System.out.println("paul");
		else
			System.out.println("opponent");

	}
}
