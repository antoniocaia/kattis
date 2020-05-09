package kattis;

import java.util.Scanner;

public class Patuljci {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {
		int[] dwarves = new int[9];

		for (int i = 0; i < dwarves.length; i++) {
			dwarves[i] = Integer.parseInt(scanner.nextLine());
		}

		for (int i = 0; i < dwarves.length; i++) {
			for (int j = i + 1; j < dwarves.length; j++) {
				if(checkArrSum(dwarves, i, j)) {
					for(int p = 0; p < dwarves.length; p++) {
						if (p != i && p != j)
							System.out.println(dwarves[p]);
					}
				}
			}
		}

	}
	
	public static boolean checkArrSum(int[] a, int no, int nope ) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (i != no && i != nope)
				sum += a[i];
		}
		return sum == 100;
	}
	
	

}
