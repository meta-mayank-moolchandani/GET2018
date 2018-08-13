
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import edge.Edge;
import neighbours.Neighbour;
import node.Node;

class NodePair {
	private int name;
	private List<Integer> pairedNeighbours = new ArrayList<Integer>();

	public NodePair(int name) {
		this.name = name;
	}

	public void addPairedNeighbours(int name) {
		pairedNeighbours.add(name);
	}

	public List<Integer> getPairedNeighboursList() {
		return this.pairedNeighbours;
	}

	public int getName() {
		return name;
	}
}

public class UndirectedWeightedGraph {
	private int totalNodes;
	private Node nodes[];
	private List<Edge> edgeList = new LinkedList<Edge>();
	public NodePair newNodePairs[];

	UndirectedWeightedGraph() {
	}

	/**
	 * Read Data from the file.
	 * 
	 * @param filePath
	 */
	public void readData(String filePath) {
		try {
			File file = new File(filePath);
			BufferedReader br = new BufferedReader(new FileReader(file));
			this.totalNodes = Integer.parseInt(br.readLine());
			this.nodes = new Node[this.totalNodes];
			for (int i = 0; i < this.totalNodes; i++) {
				this.nodes[i] = new Node(i);
			}
			String string;
			while ((string = br.readLine()) != null) {
				String tokens[] = string.split(" ");
				this.addNodes(Integer.parseInt(tokens[0]),
						Integer.parseInt(tokens[1]),
						Integer.parseInt(tokens[2]));
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Add Nodes to the EdgeList Of the Graph. Also adds the Neighbour's to the
	 * corresponding NodeList.
	 * 
	 * @param node1
	 * @param node2
	 * @param edgeWeight
	 */
	private void addNodes(int node1, int node2, int edgeWeight) {
		this.edgeList.add(new Edge(node1, node2, edgeWeight));
		this.nodes[node1].addNeighbour(node2, edgeWeight);
		this.nodes[node2].addNeighbour(node1, edgeWeight);

	}

	/**
	 * Does Depth First Search and Finds if the Graph is Connected or not.
	 * 
	 * @param graph
	 * @return isConnected
	 */
	public boolean isConnected() {
		boolean isConnected = false;
		Set<Integer> pathTraversingFromTheSource = dfs(0);
		if (pathTraversingFromTheSource.size() == totalNodes) {
			isConnected = true;
		}
		return isConnected;
	}

	/**
	 * Does A depth First Search of all the Nodes From the given Source.
	 * 
	 * @param source
	 * @return pathTraversingFromTheSource
	 */
	public Set<Integer> dfs(int source) {
		Set<Integer> pathTraversingFromTheSource = new HashSet<Integer>();
		Stack<Integer> stackForTheNodeToBeTraversed = new Stack<Integer>();
		stackForTheNodeToBeTraversed.push(nodes[0].getName());
		while (!stackForTheNodeToBeTraversed.isEmpty()) {
			int currentNodeTraversed = stackForTheNodeToBeTraversed.pop();
			if (pathTraversingFromTheSource.contains(currentNodeTraversed)) {
				continue;
			} else {
				pathTraversingFromTheSource.add(currentNodeTraversed);
				for (int index = 0; index < nodes[currentNodeTraversed]
						.getListOfNeighbours().size(); index++) {
					stackForTheNodeToBeTraversed
							.push(nodes[currentNodeTraversed]
									.getListOfNeighbours().get(index)
									.getNeighbourNode());
				}
			}
		}
		return pathTraversingFromTheSource;
	}

	/**
	 * Provides a set of Reachable Nodes From the Path.
	 * 
	 * @param node
	 * @return setOfReachableNodes
	 */
	public Set<Integer> isReachable(int node) {
		Set<Integer> setOfReachableNodes = dfs(node);
		return setOfReachableNodes;
	}

	/**
	 * Returns a list of minimum spanning tree formed using kruskal's algorithm
	 * 
	 * @return kruskalsList
	 */
	public List<Edge> mst() {
		newNodePairs = new NodePair[totalNodes];
		for (int i = 0; i < totalNodes; i++) {
			newNodePairs[i] = new NodePair(i);
		}
		List<Edge> newEdgeList = sortEdgeList(edgeList);
		Set<Edge> kruskalsAlgoEdgeList = new HashSet<Edge>();
		Set<Integer> nodesTraversed = new HashSet<Integer>();
		for (Edge x : newEdgeList) {
			boolean cyclePossible = false;
			if (nodesTraversed.contains(x.getStartPoint())
					|| nodesTraversed.contains(x.getEndPoint())) {
				addNewNodePairs(x.getStartPoint(), x.getEndPoint());
				List<Integer> startPointChild = getPossibleReachable(
						x.getStartPoint(), x.getEndPoint());
				List<Integer> endPointChild = getPossibleReachable(
						x.getEndPoint(), x.getStartPoint());
				if (startPointChild != null && endPointChild != null) {
					for (int i = 0; i < startPointChild.size(); i++) {
						for (int j = 0; j < endPointChild.size(); j++) {
							if (startPointChild.get(i) == endPointChild.get(j)) {
								cyclePossible = true;
								break;
							}
						}
						if (cyclePossible) {
							break;
						}
					}
				}
				removeNewNodePairs(x.getStartPoint(), x.getEndPoint());
			}
			if (!cyclePossible) {
				nodesTraversed.add(x.getStartPoint());
				nodesTraversed.add(x.getEndPoint());
				addNewNodePairs(x.getStartPoint(), x.getEndPoint());
				kruskalsAlgoEdgeList.add(x);
			}
		}
		List<Edge> kruskalsList = new ArrayList<Edge>(kruskalsAlgoEdgeList);
		if (kruskalsList.size() == (totalNodes - 1)) {
			return kruskalsList;
		}
		return null;
	}

	/**
	 * Gives The List Of The Next adjacent Neighbour's Of a Point excluding the
	 * other one passed as a parameter.
	 * 
	 * @param point
	 * @param pointNotToBeIncluded
	 * @return list
	 */
	private List<Integer> getPossibleReachable(int point,
			int pointNotToBeIncluded) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < newNodePairs[point].getPairedNeighboursList()
				.size(); i++) {
			if (newNodePairs[point].getPairedNeighboursList().get(i) != pointNotToBeIncluded) {
				list.add(newNodePairs[point].getPairedNeighboursList().get(i));
			}
		}
		return list;
	}

	/**
	 * Removes the last updation in the newPairPoint Array.
	 * 
	 * @param startPoint
	 * @param endPoint
	 */
	private void removeNewNodePairs(int startPoint, int endPoint) {
		newNodePairs[startPoint].getPairedNeighboursList().remove(
				newNodePairs[startPoint].getPairedNeighboursList().size() - 1);
		newNodePairs[endPoint].getPairedNeighboursList().remove(
				newNodePairs[endPoint].getPairedNeighboursList().size() - 1);
	}

	/**
	 * Adds new Pairs to the newNodePair Array/else updates the array.
	 * 
	 * @param startPoint
	 * @param endPoint
	 */
	private void addNewNodePairs(int startPoint, int endPoint) {
		if (newNodePairs[startPoint].getPairedNeighboursList().size() < 1) {
			NodePair nodePair1 = new NodePair(startPoint);
			newNodePairs[startPoint] = nodePair1;
		}
		if (newNodePairs[endPoint].getPairedNeighboursList().size() < 1) {
			NodePair nodePair2 = new NodePair(endPoint);
			newNodePairs[endPoint] = nodePair2;
		}
		newNodePairs[startPoint].addPairedNeighbours(endPoint);
		newNodePairs[endPoint].addPairedNeighbours(startPoint);
	}

	/**
	 * Sorts The List On the Basis of the EdgeWeight in ascending Order
	 * 
	 * @param edgeListToBeSorted
	 * @return edgeListToBeSorted
	 */
	private List<Edge> sortEdgeList(List<Edge> edgeListToBeSorted) {
		for (int index = 0; index < edgeListToBeSorted.size(); index++) {
			for (int j = index + 1; j < edgeListToBeSorted.size(); j++) {
				if (edgeListToBeSorted.get(index).getEdgeWeight() > edgeListToBeSorted
						.get(j).getEdgeWeight()) {
					Edge temprory = edgeListToBeSorted.get(index);
					edgeListToBeSorted.set(index, edgeListToBeSorted.get(j));
					edgeListToBeSorted.set(j, temprory);
				}
			}
		}
		return edgeListToBeSorted;
	}

	public void dikjstrasAlgo(int startPoint, int endPoint, List<Node> nodesListOfTheShortestPath ,Set<Node> nodesOfTheShortestPath,int[] distanceArrayOfNodes) {
		Scanner scanInput = new Scanner(System.in);
		System.out.println(startPoint);
		if (!nodesOfTheShortestPath.contains(nodes[endPoint])) {
			System.out.println(nodes[startPoint].getListOfNeighbours()
					.size());
			for (int index = 0; index < nodes[startPoint].getListOfNeighbours()
					.size(); index++) {
				if (nodesOfTheShortestPath.contains(nodes[startPoint]
						.getListOfNeighbours().get(index))) {
					continue;
				}
				int currentNeighbourNode = nodes[startPoint]
						.getListOfNeighbours().get(index).getNeighbourNode();
				int currentNeighbourNodeWeight = nodes[startPoint]
						.getListOfNeighbours().get(index).getEdgeWeight();
				if (distanceArrayOfNodes[currentNeighbourNode] > (currentNeighbourNodeWeight + distanceArrayOfNodes[startPoint])) {
					distanceArrayOfNodes[currentNeighbourNode] = currentNeighbourNodeWeight
							+ distanceArrayOfNodes[startPoint];
				}
			}
			List<Integer> minimumDistanceNode = minimumListOfDistance( distanceArrayOfNodes, nodesOfTheShortestPath);
			for(int i=0;i<minimumDistanceNode.size();i++)
			{
				System.out.println(minimumDistanceNode.get(i));
				scanInput.nextLine();
			}
			for(int index = 0; index<minimumDistanceNode.size();index++)
			{
				if(!nodesOfTheShortestPath.contains(nodes[index]))
				{
					nodesListOfTheShortestPath.add(nodes[index]);
					nodesOfTheShortestPath.add(nodes[index]);
					dikjstrasAlgo(minimumDistanceNode.get(index),endPoint,nodesListOfTheShortestPath,nodesOfTheShortestPath,distanceArrayOfNodes);
				}
				if(nodesOfTheShortestPath.contains(nodes[endPoint]))
				{
					break;
				}
				nodesListOfTheShortestPath.remove(nodes[index]);
				nodesOfTheShortestPath.remove(nodes[index]);
			}
		}
		
	}
	
	private List<Integer> minimumListOfDistance(int[] distanceArrayOfNode,Set<Node> nodesOfTheShortestPath)
	{
		Scanner scanInput = new Scanner(System.in);
		List<Integer> minimalValueList = new ArrayList<Integer>();
		System.out.println(nodesOfTheShortestPath);
		scanInput.nextLine();
		for(int i = 0 ;i<distanceArrayOfNode.length; i++)
		{
			if(distanceArrayOfNode[i]!=Integer.MAX_VALUE  &&  !nodesOfTheShortestPath.contains(nodes[i]))
			{
				minimalValueList.add(i);
			}
		}
		for(int i = 0;i<minimalValueList.size();i++)
		{
			for(int j=i+1;j<minimalValueList.size();j++)
			{
				if(distanceArrayOfNode[minimalValueList.get(i)]>distanceArrayOfNode[minimalValueList.get(j)])
				{
					int temp = minimalValueList.get(i);
					minimalValueList.set(i, minimalValueList.get(j));
					minimalValueList.set(j,temp);
				}
				
			}
		}
		return minimalValueList;
	}

	public List<Node> findTheShortestPathBetween(int a, int b) {
			Set<Node> nodesOfTheShortestPath = new HashSet<Node>();
			List<Node> nodesListOfTheShortestPath = new ArrayList<Node>();
			int[] distanceArrayOfNodes = new int[totalNodes];
			for(int index = 0 ; index<totalNodes ; index++)
			{
				if(index==a)
				{
					distanceArrayOfNodes[index]=0;
					continue;
				}
				distanceArrayOfNodes[index] = Integer.MAX_VALUE;
			}
			nodesOfTheShortestPath.add(nodes[a]);
			nodesListOfTheShortestPath.add(nodes[a]);
			dikjstrasAlgo(a,b,nodesListOfTheShortestPath,nodesOfTheShortestPath,distanceArrayOfNodes);
			return nodesListOfTheShortestPath;
	}

	public static void main(String args[]) {
		String path = "F:/Study/Eclipse Data/Undirected Wieghted Graph/src/graphData.txt";
		UndirectedWeightedGraph graph = new UndirectedWeightedGraph();
		graph.readData(path);
		System.out.println(graph.isConnected());
		Set<Integer> setOfReachableNodes = graph.isReachable(3);
		System.out.println(setOfReachableNodes);
		List<Edge> minimalSpanningTree = graph.mst();
		for (int i = 0; i < minimalSpanningTree.size(); i++) {
			System.out.print("\nStart Node "
					+ minimalSpanningTree.get(i).getStartPoint());
			System.out.print("End Node "
					+ minimalSpanningTree.get(i).getEndPoint());
			System.out.print("Edge Weight "
					+ minimalSpanningTree.get(i).getEdgeWeight());
		}
		List<Node> pathTraversedNode = graph.findTheShortestPathBetween(0, 6);
		System.out.print("\n Start Node : ");
		for (int i = 0; i < minimalSpanningTree.size(); i++) {
			System.out.print(" -> "
					+ pathTraversedNode.get(i).getName());
		}
	}

	

}
