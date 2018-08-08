package virtualCommandPrompt;

import java.util.*;

public class Node {
	private String name;
	private Node parent;
	private List<Node> childList = new ArrayList<Node>();
	private String path;

	private Date time;

	public Node(String name, Node parent, String path) {
		this.name = name;
		this.parent = parent;
		this.path = path;
		time = new Date();
	}

	/**
	 * @return the childList
	 */
	public List<Node> getChildList() {
		return childList;
	}
	
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}


	/**
	 * @param childList
	 *            the childList to set
	 */
	public void setChildList(List<Node> childList) {
		this.childList = childList;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}

	public boolean addChildNode(Node node) {
		return childList.add(node);
	}

}
