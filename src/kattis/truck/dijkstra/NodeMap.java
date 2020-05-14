package kattis.truck.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class NodeMap {
	
	// Attributes
	private Map<Integer, Integer> links;
	private int items;
	
	// Alghoritm realted
	private int maxItems;
	private int minDistance;

	public NodeMap(int items, int dist, int prec) {
		links = new HashMap<Integer, Integer>();
		this.items = items;
		this.setDistance(dist);
	}

	public void addNewLink(int node, int dist) {
		links.put(node, dist);
	}
	
	public Map<Integer, Integer> getLinks(){
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

}
