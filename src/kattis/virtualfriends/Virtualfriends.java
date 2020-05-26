package kattis.virtualfriends;

import java.util.HashMap;
import java.util.HashSet;

public class Virtualfriends {

	public static void main(String[] args) {
		Kattio scan = new Kattio(System.in);
		int in = scan.getInt();

		for (int i = 0; i < in; i++) {
			int num = scan.getInt();
			HashMap<String, HashSet<String>> listofnames = new HashMap<>();
			String[] pair = new String[2];
			HashSet<String> fc0;
			HashSet<String> fc1;
			for (int j = 0; j < num; j++) {
				pair[0] = scan.getWord();
		        pair[1] = scan.getWord();

				fc0 = listofnames.get(pair[0]);
				fc1 = listofnames.get(pair[1]);

				if (fc0 != null && fc1 != null) {
					if (!fc1.equals(fc0)) { 
						fc0.addAll(fc1);
						fc1.addAll(fc0);
						listofnames.put(pair[1], fc0);
					}
					System.out.println(fc0.size());
				} else if (fc0 == null && fc1 == null) {
					HashSet<String> start = new HashSet<String>();
					start.add(pair[0]);
					start.add(pair[1]);
					listofnames.put(pair[0], start);
					listofnames.put(pair[1], start);
					System.out.println(start.size());
				} else if (fc0 == null && fc1 != null) {
					fc1.add(pair[0]);
					listofnames.put(pair[0], fc1);
					System.out.println(fc1.size());
				} else if (fc1 == null && fc0 != null) {
					fc0.add(pair[1]);
					listofnames.put(pair[1], fc0);
					System.out.println(fc0.size());
				}
				System.out.println("LIST: " + listofnames);
			}
		}
		scan.close();
	}
}