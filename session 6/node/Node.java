package node;

import java.util.ArrayList;
import java.util.List;

import neighbours.Neighbour;

public class Node {
	private int name;
	private List<Neighbour> listOfNeighbours = new ArrayList<Neighbour>();
	//private List<Edge> listOfEdges = new ArrayList<Edge>();
	
	
	public Node(int name){
		this.name = name;
	}
	
	public void addNeighbour(int vertex, int edgeWeight) {
		Neighbour newNeighbour = new Neighbour(vertex, edgeWeight);
		this.listOfNeighbours.add(newNeighbour);
	}


	
	public List<Neighbour> getListOfNeighbours() {
		return this.listOfNeighbours;
	}

	public int getName() {
		return this.name;
	}


}
