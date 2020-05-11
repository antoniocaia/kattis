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

	public int shortestPath(List<Node> nodeList, LinkedList<Integer> pathList, int totalDistance) {
		//System.out.println("----\nPath: " + pathList);
		int minPath = Integer.MAX_VALUE;

		for (Link link : links) {
			//System.out.println("Node: " + (link.node+1) + " Dist: " + link.distance);
			LinkedList<Integer> myPath = new LinkedList<Integer>(pathList);
			int pathDist = totalDistance;
			if (link.node == nodeList.size() - 1) {
				//System.out.println(pathDist + link.distance + " nice");
				return pathDist += link.distance;
			} else if (!pathList.contains(link.node)) {
				pathDist += link.distance;
				myPath.add(link.node);
				int dist = nodeList.get(link.node).shortestPath(nodeList, myPath, pathDist);
				minPath = (dist < minPath) ? dist : minPath;
			}
		}

		return minPath;
	}

}
