package kattis.truck;

public class Link {
	public int node;
	public int distance;
	
	public Link(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
	
	@Override
	public String toString() {
		return node + " " + distance;
	}
}
