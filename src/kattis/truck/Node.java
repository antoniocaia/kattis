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
	
	public int getItems() {
		return items;
	}

	public int[] shortestPath(List<Node> nodeList, LinkedList<Integer> pathList, int totalDistance,
			int itemsCollected) {
		int minPath = Integer.MAX_VALUE;
		int maxItem = -1;
		LinkedList<Integer> myPath = new LinkedList<Integer>(pathList);
		
		for (Link link : links) {
			int myDist = totalDistance + link.distance;
			int myItems = itemsCollected + nodeList.get(link.node).getItems();

			if (link.node == nodeList.size() - 1) {
				if (myDist < minPath || (myDist == minPath && myItems > maxItem)) {
					minPath = myDist;
					maxItem = myItems;
				}
			} else if (!pathList.contains(link.node) && myDist < minPath) {
				myPath.add(link.node);
				int[] update = nodeList.get(link.node).shortestPath(nodeList, myPath, myDist, myItems);
				myPath.remove(myPath.size() - 1);
				if (update[0] < minPath || (update[0] == minPath && update[1] > maxItem)) {
					minPath = update[0];
					maxItem = update[1];
				}
			}
		}
		return new int[] { minPath, maxItem };
	}
}
