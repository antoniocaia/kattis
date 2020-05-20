package kattis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Whatdoesthefoxsay {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcases = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < testcases; i++) {
			String[] input = scanner.nextLine().split(" ");
			LinkedList<String> record = new LinkedList<String>(Arrays.asList(input));
			
			String in = scanner.nextLine();
			while (!in.equals("what does the fox say?")) {
				String sound = in.split(" ")[2];
				record.removeIf(x -> x.equals(sound));
				in = scanner.nextLine();
			}
			
			for(String s : record) {
				System.out.print(s + " ");
			}
		}
	}
	

}
