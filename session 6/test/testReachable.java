package test;

import static org.junit.Assert.*;

import graph.UndirectedWeightedGraph;

import org.junit.Before;
import org.junit.Test;

public class testReachable {
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
	public void test1Reachable(){
		int arrayOfConnectedVertices[] = graph.reachable(1);
		int resultArray[] = new int[]{0,3,2};
		
		assertArrayEquals(arrayOfConnectedVertices, resultArray);
	}
	
	@Test
	public void test2Reachable(){
		int arrayOfConnectedVertices[] = graph.reachable(0);
		int resultArray[] = new int[]{1,2};
		assertArrayEquals(arrayOfConnectedVertices, resultArray);
	}


}
