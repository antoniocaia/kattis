package kattis;

import java.util.Scanner;

public class Alphabet {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		String[] input = scanner.nextLine().split("");
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z", "-1" };

		int inputInd = 0;
		int maxSequence = 0;
		int sequenceLength = 1;

		while (inputInd < input.length - 1) {
			if (getAlphPos(input[inputInd],alphabet) < getAlphPos(input[inputInd + 1],alphabet)) {
				sequenceLength++;
			} else {
				sequenceLength = 1;
			}
			maxSequence = (sequenceLength > maxSequence) ? sequenceLength : maxSequence;
			inputInd++;
			System.out.println(maxSequence + " " + sequenceLength);
			System.out.println("");
		}

		System.out.println(alphabet.length - maxSequence - 1);
	}

	static int getAlphPos(String c, String[] alph) {
		for (int i = 0; i < alph.length; i++) {
			if (c.equals(alph[i]))
				return i;
		}
		return -1;
	}

}
