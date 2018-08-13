package graph;


public class Edge implements Comparable<Edge> {
	private int vertex1;
	private int vertec2;
	private int weight;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vertec2;
		result = prime * result + vertex1;
		result = prime * result + weight;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (vertec2 != other.vertec2)
			return false;
		if (vertex1 != other.vertex1)
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

	public Edge(int startingPoint, int endPoint, int edgeWeight) {
		this.vertex1 = startingPoint;
		this.vertec2 = endPoint;
		this.weight = edgeWeight;
	}
	
	/**
	 * @return the startingPoint
	 */
	public int getVertex1() {
		return vertex1;
	}

	/**
	 * @return the endPoint
	 */
	public int getVertex2() {
		return vertec2;
	}

	/**
	 * @return the edgeWeight
	 */
	public int getEdgeWeight() {
		return weight;
	}
	
    public int compareTo(Edge compareEdge)
    {
        return this.weight-compareEdge.weight;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Edge [vertex1=" + vertex1 + ", vertec2=" + vertec2
				+ ", weight=" + weight + "]";
	}
}
