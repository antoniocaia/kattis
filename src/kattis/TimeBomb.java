package kattis;

import java.util.Scanner;

public class TimeBomb {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] input = new String[5];
		for (int i = 0; i < 5; i++) {
			input[i] = " " + scanner.nextLine();
		}

		int n = 0;
		int digitQaunt = (int) Math.ceil((float) input[0].length() / 4);
		boolean validNumber = true;
		
		int i = 0;
		while (i < digitQaunt && validNumber) {
			int offset = 0;
			String numberRap = "";
			for (int j = 0; j < 5; j++) {
				numberRap = numberRap.concat(input[j].substring(offset, offset + 4));
			}

			int lastDigit = convertToNumber(numberRap);
			if (lastDigit == -1) {
				validNumber = false;
			} else {
				n *= 10;
				n += lastDigit;
				offset += 4;
				numberRap = "";
				i++;
			}
		}

		if (n % 6 != 0 || !validNumber)
			System.out.println("BOOM!!");
		else
			System.out.println("BEER!!");

	}
	
	//Disgustoso
	private static int convertToNumber(String str) {
		if (str.contentEquals(" *** * * * * * * ***"))
			return 0;
		else if (str.contentEquals("   *   *   *   *   *"))
			return 1;
		else if (str.contentEquals(" ***   * *** *   ***"))
			return 2;
		else if (str.contentEquals(" ***   * ***   * ***"))
			return 3;
		else if (str.contentEquals(" * * * * ***   *   *"))
			return 4;
		else if (str.contentEquals(" *** *   ***   * ***"))
			return 5;
		else if (str.contentEquals(" *** *   *** * * ***"))
			return 6;
		else if (str.contentEquals(" ***   *   *   *   *"))
			return 7;
		else if (str.contentEquals(" *** * * *** * * ***"))
			return 8;
		else if (str.contentEquals(" *** * * ***   * ***"))
			return 9;

		return -1;
	}

}
