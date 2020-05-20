package kattis;

import java.util.Arrays;
import java.util.Scanner;

public class Santaklas {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		
		if(arr[1] >= 0 && arr[1] <= 180) {
			System.out.println("safe");
		} else {
			double l2 = arr[0];
			double a2 = 360 - arr[1];
			double l3 = l2/(Math.sin(a2 * Math.PI / 180));
			System.out.println((int)l3);	
		}
	}

}
