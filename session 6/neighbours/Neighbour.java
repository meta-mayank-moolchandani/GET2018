package neighbours;

public class Neighbour {
	private int neighbourNode;
	private int edgeWeight;
	
	public Neighbour(int node,int edgeWeight)
	{
		this.neighbourNode = node ;
		this.edgeWeight = edgeWeight;
	}
	
	public int getNeighbourNode(){
		return this.neighbourNode;
	}
	
	public int getEdgeWeight(){
		return this.edgeWeight;
	}
}
