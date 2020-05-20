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
				
				HashSet<String> alreadyChecked = new HashSet<String>();
				getFriendCount(pair[0], alreadyChecked, friends);
				System.out.println(alreadyChecked.size());
			}
		}
	}

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
