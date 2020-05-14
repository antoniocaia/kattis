package kattis.truck.dijkstra;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BigTruck {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Node list init
		int nodeNumber = Integer.parseInt(scanner.nextLine());
		List<Node> nodeList = Arrays.stream(scanner.nextLine().split(" "))
				.map(x -> new Node(Integer.parseInt(x), Integer.MAX_VALUE, -1)).collect(Collectors.toList());

		Node starter = nodeList.get(0);
		starter.setDistance(0);
		starter.setMaxItems(starter.getItems());

		// Link init
		int linkQt = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < linkQt; i++) {
			List<Integer> input = Arrays.stream(scanner.nextLine().split(" ")).map(x -> Integer.parseInt(x))
					.collect(Collectors.toList());

			nodeList.get(input.get(0) - 1).addNewLink(input.get(1) - 1, input.get(2));
			nodeList.get(input.get(1) - 1).addNewLink(input.get(0) - 1, input.get(2));
		}

		Node r = dijkstra(0, nodeList);
		if (r.getDistance() == Integer.MAX_VALUE) {
			System.out.println("impossible");
		} else {
			System.out.println(r.getDistance() + " " + r.getMaxItems());
		}
	}

	public static Node dijkstra(int start, List<Node> nodeList) {
		LinkedList<Integer> settled = new LinkedList<>();
		LinkedList<Integer> unsettled = new LinkedList<>();
		unsettled.add(start);

		while (unsettled.size() != 0) {
			int currentNode = getNearestNode(unsettled, nodeList);
			unsettled.remove(Integer.valueOf(currentNode));
			LinkedList<Link> adjNodes = nodeList.get(currentNode).getLinks();
			for (Link link : adjNodes) {
				if (!settled.contains(link.node)) {
					minimumDistance(nodeList.get(currentNode), nodeList.get(link.node), link.distance);
					unsettled.add(link.node);
				}
			}
			settled.add(currentNode);
		}
		return nodeList.get(nodeList.size() - 1);
	}

	private static int getNearestNode(LinkedList<Integer> unsettled, List<Node> nodeList) {
		int minDist = Integer.MAX_VALUE;
		int nextNode = -1;

		for (int node : unsettled) {
			int myDist = nodeList.get(node).getDistance();
			if (myDist < minDist) {
				nextNode = node;
				minDist = myDist;
			}
		}
		return nextNode;
	}

	private static void minimumDistance(Node currentNode, Node nextNode, int distance) {

		if (currentNode.getDistance() + distance < nextNode.getDistance()
				|| (currentNode.getDistance() + distance == nextNode.getDistance()
						&& currentNode.getMaxItems() + nextNode.getItems() > nextNode.getMaxItems())) {
			nextNode.setDistance(currentNode.getDistance() + distance);
			nextNode.setMaxItems(currentNode.getMaxItems() + nextNode.getItems());
		}
	}
}
