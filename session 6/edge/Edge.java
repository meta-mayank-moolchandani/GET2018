package edge;

import node.Node;

public class Edge {
	private int startPoint;
	private int endPoint;
	private int edgeWeight;
	
	public Edge(int node1,int node2,int edgeWeight)
	{
		this.startPoint=node1;
		this.endPoint=node2;
		this.edgeWeight=edgeWeight;
	}
	
	public Edge()
	{
		
	}

	public int getStartPoint() {
		return startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public int getEdgeWeight() {
		return edgeWeight;
	}
}
