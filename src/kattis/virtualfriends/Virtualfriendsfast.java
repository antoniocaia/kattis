package kattis.virtualfriends;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Virtualfriendsfast {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int in = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < in; i++) {
			int num = Integer.parseInt(scanner.nextLine());
			HashMap<String, HashSet<String>> friends = new HashMap<>();
			for (int j = 0; j < num; j++) {
				String[] pair = scanner.nextLine().split(" ");

				HashSet<String> tmp0 = friends.get(pair[0]);
				HashSet<String> tmp1 = friends.get(pair[1]);
				if (tmp0 == null && tmp1 == null) {
					tmp0 = new HashSet<String>();
					tmp0.add(pair[0]);
					friends.put(pair[0], tmp0);
					
					tmp1 = new HashSet<String>();
					tmp1.add(pair[1]);
					friends.put(pair[1], tmp1);
				} 
				else if (tmp0 != null && tmp1 == null) {
					tmp1 = new HashSet<String>(tmp0);
					tmp1.add(pair[1]);
					friends.put(pair[1], tmp1);
					for (String f : tmp0) {
						if (!f.equals(pair[0]))
							friends.get(f).add(pair[1]);
					}
				} 
				else if (tmp0 == null && tmp1 != null) {
					tmp0 = new HashSet<String>(tmp1);
					tmp0.add(pair[0]);
					friends.put(pair[0], tmp0);
					for (String f : tmp1) {
						if (!f.equals(pair[1]))
							friends.get(f).add(pair[0]);
					}
				} 
				else if (tmp0 != null && tmp1 != null) {
					tmp0.add(pair[1]);
					tmp1.add(pair[0]);
					
					for (String f0 : tmp0) {
						HashSet<String> fl0 = friends.get(f0);
						if (!f0.equals(pair[0])) {
							fl0.add(pair[1]);
							for (String f1 : tmp1) {
								if (!f0.equals(f1))
									fl0.add(f1);
							}
						}
					}

					for (String f1 : tmp1) {
						HashSet<String> fl1 = friends.get(f1);
						if (!f1.equals(pair[1])) {
							fl1.add(pair[0]);
							for (String f0 : tmp0) {
								if (!f1.equals(f0))
									fl1.add(f0);

							}
						}
					}

					for (String f1 : tmp1)
						friends.get(pair[0]).add(f1);

					for (String f0 : tmp0)
						friends.get(pair[1]).add(f0);
				}

				tmp0.add(pair[1]);
				tmp1.add(pair[0]);

//				for (Entry<String, HashSet<String>> entry : friends.entrySet()) {
//					System.out.println(entry.getKey() + ": " + entry.getValue());
//				}

				System.out.println(tmp1.size());
			}
		}
	}
}
