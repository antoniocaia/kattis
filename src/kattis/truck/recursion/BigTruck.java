package kattis.truck.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BigTruck {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		scanner.nextLine();
		List<Node> nodeList = Arrays.stream(scanner.nextLine().split(" ")).map(x -> new Node(Integer.parseInt(x)))
				.collect(Collectors.toList());

		Node first = nodeList.get(0);
		first.setMaxItems(first.getItems());
		first.setMinPath(0);

		int linkQt = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < linkQt; i++) {
			List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(x -> Integer.parseInt(x))
					.collect(Collectors.toList());

			nodeList.get(input.get(0) - 1).addNewLink(input.get(1) - 1, input.get(2));
			nodeList.get(input.get(1) - 1).addNewLink(input.get(0) - 1, input.get(2));
		}

		HashSet<Integer> pathList = new HashSet<>();
		pathList.add(0);
		nodeList.get(0).shortestPath(nodeList, pathList);
		Node r = nodeList.get(nodeList.size() - 1);

		if (r.getMinPath() == Integer.MAX_VALUE)
			System.out.println("impossible");
		else
			System.out.println(r.getMinPath() + " " + r.getMaxItems());

	}

}
