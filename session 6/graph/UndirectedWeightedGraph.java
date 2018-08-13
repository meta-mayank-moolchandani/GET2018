package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class UndirectedWeightedGraph implements Graph {
	private int numberOfVertices;
	private List<Edge> edges;
	private Edge edge;

	/**
	 * @return the listOfNeighbours
	 */
	public LinkedList<Edge>[] getListOfNeighbours() {
		return listOfNeighbours;
	}

	private LinkedList<Edge> listOfNeighbours[];

	@SuppressWarnings("unchecked")
	public UndirectedWeightedGraph(int numberOfVertices) {
		listOfNeighbours = new LinkedList[numberOfVertices];
		this.numberOfVertices = numberOfVertices;
		for (int index = 0; index < numberOfVertices; index++) {
			listOfNeighbours[index] = new LinkedList<Edge>();
		}
	}

	/**
	 * adding edge to the graph
	 * 
	 * @param vertex1
	 * @param vertex2
	 * @param weight
	 * @return
	 */
	public boolean addEdge(int vertex1, int vertex2, int weight) {
		edge = new Edge(vertex1, vertex2, weight);
		listOfNeighbours[vertex1].add(edge);
		edge = new Edge(vertex2, vertex1, weight);
		listOfNeighbours[vertex2].add(edge); // graph is undirected
		return true;
	}

	/**
	 * traversing the graph using dfs
	 * 
	 * @return
	 */
	@Override
	public boolean isConnected() {
		boolean isConnectedFlag = false;
		if (numberOfVertices >= 0) {
			Stack<Integer> stack = new Stack<Integer>();
			boolean state[] = new boolean[numberOfVertices];
			LinkedList<Edge> edges = new LinkedList<Edge>();

			for (int i = 0; i < numberOfVertices; i++) {

				if (stack.isEmpty()) {
					edges = listOfNeighbours[0];
					state[0] = true;
				} else {
					edges = listOfNeighbours[stack.peek()];
					state[stack.pop()] = true;
				}
				// iterating in linkedlist stored in listOfEdges
				for (int edgeIndex = 0; edgeIndex < edges.size(); edgeIndex++) {
					if (!state[edges.get(edgeIndex).getVertex2()]) {
						stack.push(edges.get(edgeIndex).getVertex2());
					}
				}
			}
			// checking vertices status
			for (boolean statecheck : state) {
				if (!statecheck) {
					isConnectedFlag = false;
				} else {
					isConnectedFlag = true;
				}
			}
		}
		return isConnectedFlag;
	}

	/**
	 * it will return all the nodes that are reachable from node vertex
	 */
	@Override
	public int[] reachable(int vertex) {
		int arrayOfConnected[] = new int[listOfNeighbours[vertex].size()];
		if (vertex <= 0 && vertex > numberOfVertices) {
			throw new AssertionError();
		} else {
			int index = 0;
			for (Edge edge : listOfNeighbours[vertex]) {
				arrayOfConnected[index] = edge.getVertex2();
				index++;
			}
		}
		return arrayOfConnected;
	}

	/**
	 * returns the list of minimum spanning tree
	 */
	@Override
	public List<Edge> minimumSpanningTree() {

		List<Edge> minSpanningtree;

		// Array to store constructed MST
		int parent[] = new int[numberOfVertices];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int[numberOfVertices];

		// To represent set of vertices not yet included in MST
		Boolean mstSet[] = new Boolean[numberOfVertices];

		// Initialize all keys as INFINITE
		for (int i = 0; i < numberOfVertices; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		key[0] = 0; // Make key 0 so that this vertex is
		// picked as first vertex
		parent[0] = -1; // First node is always root of MST

		// The MST will have numberOfVertices vertices
		for (int count = 0; count < numberOfVertices - 1; count++) {

			// Pick the minimum key vertex from the set of vertices
			// not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			edges = listOfNeighbours[u];

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < numberOfVertices; v++) {

				for (Edge listEdges : edges) {

					if (listEdges.getVertex2() == v) {

						// Update the key only if weight(u,v) is smaller than
						// key[v]
						if (listEdges.getEdgeWeight() != 0 && !mstSet[v]
								&& listEdges.getEdgeWeight() < key[v]) {

							parent[v] = u;
							key[v] = listEdges.getEdgeWeight();

						}
					}
				}
			}
		}

		// Add the constructed MST to list
		minSpanningtree = new ArrayList<Edge>();

		for (int i = 1; i < numberOfVertices; i++) {
			edges = listOfNeighbours[i];
			for (Edge edgeConnected : edges) {
				if (edgeConnected.getVertex2() == parent[i]) {

					edge = new Edge(parent[i], i, edgeConnected.getEdgeWeight());

					minSpanningtree.add(edge);
				}
			}
		}

		// System.out.println(minSpanningtree.toString());

		return minSpanningtree;
	}

	/**
	 * Helper function to find the vertex with minimum key value, from the set
	 * of vertices not yet included in MST
	 **/
	int minKey(int key[], Boolean boolSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < numberOfVertices; v++)
			if (boolSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	/**
	 * Function to fin shortest path
	 * 
	 * @param vertex1
	 *            source from which path is to be find
	 * @param vertex2
	 *            destination to which path is to be traced
	 * 
	 * @return list of edges and their respective distance
	 */
	@Override
	public List<Edge> getShortestPath(int vertex1, int vertex2) {
		List<Edge> shortestPath;

		int dist[] = new int[numberOfVertices]; // The output array. dist[i]
												// will hold
		// the shortest distance from src to i

		// sptSet[i] will true if vertex i is included in shortest
		// path tree or shortest distance from src to i is finalized
		Boolean sptSet[] = new Boolean[numberOfVertices];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < numberOfVertices; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[vertex1] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < numberOfVertices - 1; count++) {
			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minKey(dist, sptSet);

			// Mark the picked vertex as processed
			sptSet[u] = true;

			edges = listOfNeighbours[u];
			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < numberOfVertices; v++)

				// Update dist[v] only if is not in sptSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of dist[v]

				for (Edge listEdges : edges) {
					// getting weight connected with vertex v
					if (listEdges.getVertex2() == v) {

						if (!sptSet[v] && listEdges.getEdgeWeight() != 0
								&& dist[u] != Integer.MAX_VALUE
								&& dist[u] + listEdges.getEdgeWeight() < dist[v]) {

							dist[v] = dist[u] + listEdges.getEdgeWeight();
						}
					}
				}
		}

		// store the resulting list in a arrayList along with their
		// distance
		shortestPath = new ArrayList<>();

		for (int i = vertex1; i < vertex2 + 1; i++) {
			edge = new Edge(i - 1, i, dist[i]);
			shortestPath.add(edge);
		}
		return shortestPath;
	}

}
