package kattis.truck.dijkstra;

import java.util.LinkedList;

public class Node {
	
	private LinkedList<Link> links;
	private int items;
	
	private int maxItems;
	private int minDistance;
	//private LinkedList<Integer> shortestPath;

	public Node(int items, int dist, int prec) {
		links = new LinkedList<Link>();
		this.items = items;
		
		this.setDistance(dist);
		//setShortestPath(new LinkedList<Integer>());
	}

	public void addNewLink(int node, int dist) {
		links.add(new Link(node, dist));
	}
	
	public LinkedList<Link> getLinks(){
		return links;
	}

	public int getItems() {
		return items;
	}

	public int getDistance() {
		return minDistance;
	}

	public void setDistance(int distance) {
		this.minDistance = distance;
	}

	public int getMaxItems() {
		return maxItems;
	}

	public void setMaxItems(int maxItems) {
		this.maxItems = maxItems;
	}

//	public LinkedList<Integer> getShortestPath() {
//		return shortestPath;
//	}
//
//	public void setShortestPath(LinkedList<Integer> shortestPath) {
//		this.shortestPath = shortestPath;
//	}

}
