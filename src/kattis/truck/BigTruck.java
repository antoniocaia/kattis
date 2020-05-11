package kattis.truck;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BigTruck {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		//int nodeQt = Integer.parseInt(scanner.nextLine()); 
		scanner.nextLine();
		List<Node> nodeList = Arrays.stream(scanner.nextLine().split(" ")).map(x -> new Node(Integer.parseInt(x)))
				.collect(Collectors.toList());

		int linkQt = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < linkQt; i++) {
			List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(x -> Integer.parseInt(x))
					.collect(Collectors.toList());

			nodeList.get(input.get(0) - 1).addNewLink(input.get(1) - 1, input.get(2));
			nodeList.get(input.get(1) - 1).addNewLink(input.get(0) - 1, input.get(2));
		}
		
		LinkedList<Integer> pathList = new LinkedList<>();
		pathList.add(0);
		int[] shortest = nodeList.get(0).shortestPath(nodeList, pathList, 0, nodeList.get(0).getItems());
		if (shortest[0] == Integer.MAX_VALUE)
			System.out.println("impossible");
		else
			System.out.println(shortest[0] + " " + shortest[1]);
	}

}
