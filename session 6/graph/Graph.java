package graph;

import java.util.List;

public interface Graph {
	public boolean isConnected();

	public int[] reachable(int vertex);

	public List<Edge> minimumSpanningTree();

	public List<Edge> getShortestPath(int vetex1, int vertex2);

}
