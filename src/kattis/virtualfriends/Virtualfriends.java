package kattis.virtualfriends;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Virtualfriends {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int in = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < in; i++) {
			int num = Integer.parseInt(scanner.nextLine());
			HashMap<String, HashSet<String>> friends = new HashMap<>();
			for (int j = 0; j < num; j++) {
				String[] pair = scanner.nextLine().split(" ");

				HashSet<String> tmp0 = friends.get(pair[0]);
				if (tmp0 == null) {
					tmp0 = new HashSet<String>();
					friends.put(pair[0], tmp0);
				}

				HashSet<String> tmp1 = friends.get(pair[1]);
				if (tmp1 == null) {
					tmp1 = new HashSet<String>();
					friends.put(pair[1], tmp1);
				}
				tmp0.add(pair[1]);
				tmp1.add(pair[0]);

				int cc = getFriendCount(pair[0], friends);
				System.out.println(cc);
			}
		}
	}

	static int getFriendCount(String id, HashMap<String, HashSet<String>> friends) {
		HashSet<String> alreadychecked = new HashSet<String>();
		HashSet<String> unchecked = new HashSet<String>();
		unchecked.add(id);
		while (unchecked.size() > 0) {
			String s = unchecked.iterator().next();
			HashSet<String> list = friends.get(s);
			for (String str : list) {
				if (!alreadychecked.contains(str))
					unchecked.add(str);
			}

			unchecked.remove(s);
			alreadychecked.add(s);
		}

		return alreadychecked.size();
	}

	// Not used
	static void getFriendCount(String id, HashSet<String> alreadyChecked, HashMap<String, HashSet<String>> friends) {
		HashSet<String> list = friends.get(id);
		alreadyChecked.add(id);
		for (String str : list) {
			if (!alreadyChecked.contains(str)) {
				getFriendCount(str, alreadyChecked, friends);
			}
		}
	}

}
