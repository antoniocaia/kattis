package kattis.truck;

import java.util.LinkedList;
import java.util.List;

public class Node {

	private LinkedList<Link> links;
	private int items;

	public Node(int items) {
		links = new LinkedList<Link>();
		this.items = items;
	}

	public void addNewLink(int node, int dist) {
		links.add(new Link(node, dist));
	}

	public LinkedList<Link> getMap() {
		return links;
	}

	public int getItems() {
		return items;
	}

	public int[] shortestPath(List<Node> nodeList, LinkedList<Integer> pathList, int totalDistance,
			int itemsCollected) {
		// System.out.println("----\nPath: " + pathList);
		int minPath = Integer.MAX_VALUE;
		int maxItem = -1;

		for (Link link : links) {
			// System.out.println("Node: " + (link.node+1) + " Dist: " + link.distance);
			LinkedList<Integer> myPath = new LinkedList<Integer>(pathList);
			int myDist = totalDistance;
			int myItems = itemsCollected;
			if (link.node == nodeList.size() - 1) {
				// System.out.println(pathDist + link.distance + " nice");
				myDist += link.distance;
				myItems += nodeList.get(link.node).getItems();
				return new int[] { myDist, myItems };
			} else if (!pathList.contains(link.node)) {
				myDist += link.distance;
				myItems += nodeList.get(link.node).getItems();
				myPath.add(link.node);
				int[] update = nodeList.get(link.node).shortestPath(nodeList, myPath, myDist, myItems);
				if (update[0] < minPath || (update[0] == minPath && update[1] > maxItem)) {
					minPath = update[0];
					maxItem = update[1];
				}
			}
		}

		return new int[] { minPath, maxItem };
	}

}