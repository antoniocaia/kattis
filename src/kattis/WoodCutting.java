package kattis;

import java.util.ArrayList;

// This solution use Kattio for IO operations.
// https://github.com/Kattis/kattio/blob/master/Kattio.java

public class WoodCutting {
	
	public static void main(String[] args) {
		Kattio scan = new Kattio(System.in);
		int testCases = scan.getInt();

		while (testCases > 0) {
			int customers = scan.getInt();
			ArrayList<Integer> totalTimeCust = new ArrayList<Integer>();
			for (int j = 0; j < customers; j++) {
				int woods = Integer.parseInt(scan.getWord());
				int totalTime = 0;
				for (int i = 0; i < woods; i++) {
					totalTime += Integer.parseInt(scan.getWord());
				}
				totalTimeCust.add(totalTime);
			}

			totalTimeCust.sort((a, b) -> a - b);
			double tmpTot = 0;
			double sum = 0;
			for (double w : totalTimeCust) {
				tmpTot += w;
				sum = sum + tmpTot;
			}
			System.out.println(sum / customers);
			testCases--;
		}
	}
}
