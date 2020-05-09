package kattis;

import java.util.ArrayList;
import java.util.Scanner;

public class RaggedRigth {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<String> paragraph = new ArrayList<String>();
		int maxLineLength = 0;
		int raggedness = 0;
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			maxLineLength = (input.length() > maxLineLength) ? input.length() : maxLineLength;
			paragraph.add(input);
		}

		for (int i = 0; i < paragraph.size() - 1; i++) {
			raggedness += Math.pow(maxLineLength - paragraph.get(i).length(), 2);
		}

		System.out.println(raggedness);
	}

}
