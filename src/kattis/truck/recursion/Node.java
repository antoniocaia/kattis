package kattis.truck.recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Node {

	private HashMap<Integer, Integer> links;
	private int items;

	private int minPath;
	private int maxItems;

	public Node(int items) {
		links = new HashMap<>();
		this.items = items;

		minPath = Integer.MAX_VALUE;
		maxItems = -1;
	}

	public void addNewLink(int node, int dist) {
		links.put(node, dist);
	}

	public int getItems() {
		return items;
	}

	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}

	public void setMinPath(int minPath) {
		this.minPath = minPath;
	}

	public int getMaxItems() {
		return maxItems;
	}

	public int getMinPath() {
		return minPath;
	}

	public void shortestPath(List<Node> nodeList, HashSet<Integer> pathList) {
		for (HashMap.Entry<Integer, Integer> link : links.entrySet()) {
			int node = link.getKey();
			Node nextNode = nodeList.get(link.getKey());
			int distance = link.getValue();

			int nextDist = minPath + distance;
			int nextItems = maxItems + nextNode.getItems();

			if (nextDist < nextNode.getMinPath()
					|| (nextDist == nextNode.getMinPath() && nextItems > nextNode.getMaxItems())) {
				if (node == nodeList.size() - 1) {
					nextNode.setMinPath(nextDist);
					nextNode.setMaxItems(nextItems);
				} else if (!pathList.contains(node)) {
					nextNode.setMinPath(nextDist);
					nextNode.setMaxItems(nextItems);
					pathList.add(node);
					nextNode.shortestPath(nodeList, pathList);
					pathList.remove(Integer.valueOf(node));
				}
			}
		}
	}
}
