package test;

import static org.junit.Assert.*;
import graph.UndirectedWeightedGraph;

import org.junit.Before;
import org.junit.Test;

public class TestIsConnected {
	UndirectedWeightedGraph graph = new UndirectedWeightedGraph(4);

	@Before
	public void initialise() {
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 4);
	}
	
	@Test
	public void testIsConnectedGraph(){
		assertEquals("shows true as graph is connected",true, graph.isConnected());
	}
	
	@Test
	public void test2IsConnectedGraph(){
		graph = new UndirectedWeightedGraph(5);
		assertEquals("5th vertex is not connected with the graph", false, graph.isConnected());
	}
}
