package kattis;

import java.util.*;

public class ChanukahChallenge {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		int testCases = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < testCases; i++) {
			String[] input = scanner.nextLine().split(" ");

			int candleCount = 0;
			int testNum = Integer.parseInt(input[0]);
			int days = Integer.parseInt(input[1]);

			for (int j = 0; j < days; j++) {
				candleCount += j + 2;
			}
			System.out.println(testNum + " " + candleCount);
		}

	}
}
