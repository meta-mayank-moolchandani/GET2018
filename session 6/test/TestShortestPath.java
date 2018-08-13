package test;

import static org.junit.Assert.*;
import graph.Edge;
import graph.UndirectedWeightedGraph;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestShortestPath {
	UndirectedWeightedGraph graph = new UndirectedWeightedGraph(4);
	List<Edge> actualResult = new ArrayList<Edge>();

	@Before
	public void initialise() {
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 4);
		
		actualResult.add(new Edge(0,1,0));
		actualResult.add(new Edge(1,2,1));
		
	}
	
	@Test
	public void testGetShortestPath() {
	   List<Edge> shortestPath = graph.getShortestPath(1,2);
	   assertEquals(shortestPath, actualResult);
	}

}
