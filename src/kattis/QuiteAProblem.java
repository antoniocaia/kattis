package kattis;

import java.util.Scanner;

public class QuiteAProblem {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			if (input.toLowerCase().contains("problem"))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
