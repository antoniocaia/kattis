package kattis.airconditioned;

import java.util.ArrayList;

public class Airconditioned {
	public static void main(String[] args) {
		Kattio scan = new Kattio(System.in);
		int in = scan.getInt();
		ArrayList<Minion> minions = new ArrayList<Minion>();

		while (in > 0) {
			int l = Integer.parseInt(scan.getWord());
			int u = Integer.parseInt(scan.getWord());
			minions.add(new Minion(l, u));
			in--;
		}

		minions.sort((a, b) -> a.low - b.low);

		int roomCounter = 1;
		int upperBound = minions.get(0).up;

		for (Minion m : minions) {
			if (m.low > upperBound) {
				upperBound = m.up;
				roomCounter++;
			} else {
				if (m.up < upperBound)
		            upperBound = m.up;
			}
		}

		System.out.println(roomCounter);
	}

}
