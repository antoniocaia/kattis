package kattis.virtualfriends;

import java.util.HashSet;
import java.util.Scanner;

public class Virtualfriendsfastest {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		int in = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < in; i++) {
			int num = Integer.parseInt(scanner.nextLine());
			HashSet<HashSet<String>> friendsCircle = new HashSet<>();

			for (int j = 0; j < num; j++) {
				String[] pair = scanner.nextLine().split(" ");

				HashSet<String> fc0 = null;
				HashSet<String> fc1 = null;
				for (HashSet<String> l : friendsCircle) {
					if (l.contains(pair[0])) {
						fc0 = l;
					} else if (l.contains(pair[1])) {
						fc1 = l;
					}
					if (fc0 != null && fc1 != null)
						break;
				}

				if (fc0 != null && fc1 != null && !fc1.equals(fc0)) {
					fc0.addAll(fc1);
					friendsCircle.remove(fc1);
					System.out.println(fc0.size());
				} else if (fc0 == null && fc1 == null) {
					HashSet<String> start = new HashSet<String>();
					start.add(pair[0]);
					start.add(pair[1]);
					friendsCircle.add(start);
					System.out.println(start.size());
				} else if (fc0 == null && fc1 != null) {
					fc1.add(pair[0]);
					System.out.println(fc1.size());
				} else if (fc1 == null && fc0 != null) {
					fc0.add(pair[1]);
					System.out.println(fc0.size());
				}
			}
		}
		long endTime = System.nanoTime();
		long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
		System.out.println(duration);
	}
}