import static org.junit.Assert.*;

import org.junit.Test;


public class UndirectedWeightedGraphTest {

	@Test
	public void testIsConnected() {
				String path = "F:/Study/Eclipse Data/Undirected Wieghted Graph/src/graphData.txt";
				UndirectedWeightedGraph graph = new UndirectedWeightedGraph();
				graph.readData(path);
				assertEquals(true,graph.isConnected());
			}

}
