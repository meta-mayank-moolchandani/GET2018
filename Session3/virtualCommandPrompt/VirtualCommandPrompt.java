package virtualCommandPrompt;

public class VirtualCommandPrompt {
	public final Node ROOTNODE;
	public Node currentNode;
	private String currentPath;

	public VirtualCommandPrompt() {
		ROOTNODE = new Node("R", null, "R:\\>");
		this.currentPath = ROOTNODE.getPath();
		currentNode = ROOTNODE;
	}

/**
 * checking whether the command is valid or not	
 * @param command
 * @return
 */
	public boolean isValidCommand(String command) {
		boolean flag = false;
		String splittedCommand[] = command.split(" ");
		if ((splittedCommand[0].equals("exit") || splittedCommand[0].equals("ls")
				|| splittedCommand[0].equals("bk") || splittedCommand[0].equals("tree"))
				&& (splittedCommand.length == 1)) {
			flag = true;
		}
		if ((splittedCommand[0].equals("cd") || splittedCommand[0].equals("mkdir") || splittedCommand[0]
				.equals("find")) && (splittedCommand.length == 2)) {
			flag = true;
		}
		return flag;
	}

/**
 * checking if newNode is already available in the list
 * @param newNode
 * @return
 */
	private boolean isNewNodeExist(Node newNode) {
		boolean flag = false;

		for (Node node : currentNode.getChildList()) {
			if (node.getName().equals(newNode.getName())) {
				flag = true;
			}
		}
		return flag;
	}

/**
 * for creating the directory used by mkdir
 * @param NodeName
 * @return
 */
	public boolean createDirectory(String NodeName) {
		String pathOftheNode = new String(currentPath + NodeName + ">");

		Node newNode = new Node(NodeName, currentNode, pathOftheNode);
		if (!isNewNodeExist(newNode)) {
			currentNode.addChildNode(newNode);
		} else {
			throw new RuntimeException("can not be added: file already exist");
		}
		return true;
	}

/**
 * checking whether a particular node exist or not	
 * @param nameOfNode
 * @return
 */
	private boolean isExistNodeNameInChildListOfCurrentNode(String nameOfNode) {
		boolean flag = false;
		for (Node node : currentNode.getChildList()) {
			if (node.getName().equals(nameOfNode)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
/**
 * getting the node object through name
 * @param nameOfNode
 * @return
 */
	private Node getChildNodeObjectOfCurrentNodeByNameOfNode(String nameOfNode) {
		Node found = null;
		for (Node node : currentNode.getChildList()) {
			if (node.getName().equals(nameOfNode)) {
				found = node;
			}
		}
		return found;
	}

/**
 * getting the current directory used by cd	
 * @param nameOfNode
 * @return
 */
	public boolean moveToDirectory(String nameOfNode) {
		if (isExistNodeNameInChildListOfCurrentNode(nameOfNode)) {
			currentNode = getChildNodeObjectOfCurrentNodeByNameOfNode(nameOfNode);
			currentPath = currentNode.getPath();
		} else {
			throw new RuntimeException(
					"directory does not exist in current directory");
		}

		return true;
	}

/**
 * moving back to parent directory used by bk	
 * @return
 */
	public boolean moveBackToParentDirectory() {
		boolean flag = false;
		if (!currentNode.equals(ROOTNODE)) {
			currentNode = currentNode.getParent();
			currentPath = currentNode.getPath();
			flag = true;
		}
		return flag;
	}

/**
 * getting the list of all directory which are present in current level for ls	
 * @return
 */
	public String getListOfAllDirectoryOfFirstLevel() {
		StringBuffer allDirectory = new StringBuffer();

		for (Node node : currentNode.getChildList()) {
			allDirectory.append(node.getName() + "\t"
					+ node.getTime().toString() + "\n");
		}
		return allDirectory.toString();
	}

/**
 * finding path of nodeName	
 * @param nodeName
 * @return
 */
	public String findPaths(String nodeName) {
		StringBuffer pathOfnodeName = new StringBuffer("");
		return getNodePaths(nodeName, pathOfnodeName, currentNode).toString();
	}

/**
 * calling recursively the same function 	
 * @param nodeName
 * @param pathOfNodeName
 * @param current
 * @return
 */
	private StringBuffer getNodePaths(String nodeName, StringBuffer pathOfNodeName,
			Node current) {
		if ("R".equals(nodeName)) {
			return new StringBuffer(currentPath);
		} else {
			for (Node node : current.getChildList()) {
				if (node.getName().equals(nodeName)) {
					pathOfNodeName.append(node.getPath() + "\n");
				}
				if (node.getChildList().size() == 0) {
					continue;
				} else {
					pathOfNodeName.append("\n");
					getNodePaths(nodeName, pathOfNodeName, node);
				}
			}
		}
		return pathOfNodeName;
	}

/**
 * getting the tree of the current Directory
 * @return
 */
	public String getTree() {
		StringBuffer treePath = new StringBuffer("");
		int numberOfSpaces = 0;
		return getWholeTree(treePath, currentNode, numberOfSpaces).toString();
	}

/**
 * getting the whole tree through recurssion  	
 * @param treePath
 * @param current
 * @param numberOfSpaces
 * @return
 */
	private StringBuffer getWholeTree(StringBuffer treePath, Node current,
			int numberOfSpaces) {
		int nodeIndex = 0;
		for (Node node : current.getChildList()) {
			// treePath.append(getSpace(numberOfSpaces));
			if (nodeIndex == 0) {
				treePath.append(getSymbolForFirstNewNode(numberOfSpaces)
						+ node.getName());

			} else {
				treePath.append(getSymbolForOtherNewNode(numberOfSpaces)
						+ node.getName());

			}
			nodeIndex++;
			if (node.getChildList().size() == 0) {
				continue;
			} else {
				treePath.append("\n" + getSpace(numberOfSpaces));

				int newNumberSpaces = numberOfSpaces + 3;
				getWholeTree(treePath, node, newNumberSpaces);
			}
		}
		return treePath;
	}

/**
 * getting symbol for first node	
 * @param num
 * @return
 */
	private String getSymbolForFirstNewNode(int num) {
		return getSpace(num) + "\u2514" + "\u2500"; // |__
	}

	private String getSymbolForOtherNewNode(int numberOfSpaces) {
		return "\n" + getSpace(numberOfSpaces) + "\u251c" + "\u2500"; // |---
	}

	private String getSpace(int numberOfSpace) {
		String spaces = "";
		for (int i = 0; i < numberOfSpace; i++) {
			spaces += " ";
		}
		return spaces;
	}

	/**
	 * @return the currentPath
	 */
	public String getCurrentPath() {
		return currentPath;
	}
}
