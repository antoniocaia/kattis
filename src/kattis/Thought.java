package kattis;

import java.util.ArrayList;
import java.util.Scanner;

public class Thought {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int nEntry = Integer.parseInt(scanner.nextLine());
		int[] input = new int[nEntry];
		for (int i = 0; i < nEntry; i++) {
			input[i] = Integer.parseInt(scanner.nextLine());
		}

		for (int i = 0; i < nEntry; i++) {
			String r = addOp(1, "4", input[i]);
			if (r.equals(""))
				System.out.println("no solution");
			else
				System.out.println(r + " = " + input[i]);
		}
	}

	public static String addOp(int size, String str, int n) {
		if (size == 4) {
			if (parseEquation(str) == n) {
				return str;
			}
			return "";
		}
		size++;
		
		String s3 = addOp(size, str + " + 4", n);
		if ("" != s3)
			return s3;
		String s4 = addOp(size, str + " - 4", n);
		if ("" != s4)
			return s4;
		String s1 = addOp(size, str + " * 4", n);
		if ("" != s1)
			return s1;
		String s2 = addOp(size, str + " / 4", n);
		if ("" != s2)
			return s2;

		return "";
	}

	
	
	public static int parseEquation(String s) {
		String[] str = s.split(" ");
		
		for(int i = 0; i< str.length; i++) {
			if(str[i].equals("-")) {
				str[i+1] = "-" + str[i+1];
				str[i] = "+";
			}
		}
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> operation = new ArrayList<String>();

		for (int i = 0; i < str.length; i++) {
			if (i % 2 == 1) {
				if (str[i].equals("+") || str[i].equals("-")) {
					operation.add(str[i]);
				} else {
					if (str[i].equals("*")) {
						int parzialOp = numbers.get(numbers.size() - 1) * Integer.parseInt(str[i + 1]);
						numbers.remove(numbers.size() - 1);
						numbers.add(parzialOp);
					} else if (str[i].equals("/")) {
						int parzialOp = numbers.get(numbers.size() - 1) / Integer.parseInt(str[i + 1]);
						numbers.remove(numbers.size() - 1);
						numbers.add(parzialOp);
					}
					i++;
				}

			} else {
				numbers.add(Integer.parseInt(str[i]));
			}
		}
		
		
		
		int opRem = operation.size();
		for (int i = 0; i < opRem; i++) {
			int first = numbers.remove(numbers.size() - 1);
			int second = numbers.remove(numbers.size() - 1);
			String op = operation.remove(operation.size() - 1);

			if (op.equals("+")) {
				numbers.add(second + first);
			} else if (op.equals("-"))
				numbers.add(second - first);
		}
		return numbers.get(0);
	}

}
