package test;
import java.util.ArrayList;

import java.util.List;

import graph.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestMinimumSpanningTree {
	UndirectedWeightedGraph graph = new UndirectedWeightedGraph(4);
	List<Edge> actualResult = new ArrayList<Edge>();

	@Before
	public void initialise() {
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 3, 2);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 4);
		
		actualResult.add(new Edge(2,1,1));
		actualResult.add(new Edge(0,2,3));
		actualResult.add(new Edge(1,3,2));
		
	}
	
	@Test
	public void testMinimumSpanningTree(){
	   List<Edge> spanningList = new ArrayList<Edge>();
	   spanningList = graph.minimumSpanningTree();
	   
	   assertEquals(spanningList, actualResult);
	   
	}
	

}
