package dictionary;


import java.util.*;

public class DictionaryTree implements Dictionary{
	private Node RootNode;

/**
 * constructor for initializing the binary tree	
 * @param listOfInitialInput input list
 */
	public DictionaryTree(List<KeyValuePair> listOfInitialInput) {
		this.RootNode = null;
		for (KeyValuePair pair : listOfInitialInput) {
			this.add(pair.getKey(), pair.getValue());
		}
	}

/**
 * adding key value pair to binary tree	
 */
	@Override
	public boolean add(int key, String value) {
		Node newNode = new Node(new KeyValuePair(key, value));
		
		return addNewNode(RootNode,newNode,key);
	}

/**
 * inserting node in tree	
 * @param currentNode
 * @param newNode
 * @param key
 * @return
 */
	private boolean addNewNode(Node currentNode, Node newNode, int key) {
		boolean flag = false;
		if (RootNode == null) {
			RootNode = newNode;
			flag = true;
		} else {
			if (key > currentNode.getData().getKey()) {
				if (currentNode.getRightNode() == null) {
					currentNode.setRightNode(newNode);
					flag = true;
				} else {
					flag = addNewNode(currentNode.getRightNode(), newNode, key);
				}
			} else if (key < currentNode.getData().getKey()) {
				if (currentNode.getLeftNode() == null) {
					currentNode.setLeftNode(newNode);
					flag = true;
				} else {
					flag = addNewNode(currentNode.getLeftNode(), newNode, key);
				}
			}
		}
		return flag;
	}

/**
 * deleting key from binary tree	
 */
	@Override
	public boolean delete(int key) {
		boolean isNodeDeletedFlag = false;
		if(isNodeExist(key)){
			Node currentNode = RootNode;
		    
			RootNode = deleteNode(currentNode,key);
			isNodeDeletedFlag = true;

		}
		return isNodeDeletedFlag;
	}
/**
 * getting the parentNode of key 	
 * @param currentNode
 * @param key
 * @return
 */
	private Node getParentNode(Node currentNode,int key){
		Node parentNode = currentNode;
		if(parentNode.getData().getKey()==key){
			return null;
		}
		
		while(true){
			if(key>parentNode.getData().getKey()){
				if(parentNode.getRightNode().getData().getKey()==key){
					break;
				}else{
					parentNode = parentNode.getRightNode();
				}
			}else{
				if(parentNode.getLeftNode().getData().getKey()==key){
					break;
				}else{
					parentNode = parentNode.getLeftNode();
				}
				
			}
		}
		return parentNode;
	}

/**
 * getting the current node address of the key 	
 * @param currentNode
 * @param key
 * @return
 */
	private Node getCurrentNode(Node currentNode,int key){
		
		Node parentNode = getParentNode(currentNode,key);
		if(parentNode==null){
			return currentNode;
		}
		Node tempNode = null;
		if(parentNode.getRightNode()!=null && parentNode.getRightNode().getData().getKey()==key){
			tempNode = parentNode.getRightNode();
		}else if(parentNode.getLeftNode()!=null && parentNode.getLeftNode().getData().getKey()==key){
			tempNode = parentNode.getLeftNode();
		}
		return tempNode;
	}
	
/**
 * helper method for
 * deleting the node from the tree	
 * @param RootNode
 * @param key
 * @return
 */
	private Node deleteNode(Node RootNode, int key) {
		// if tree is empty
		if (RootNode == null) {
			return null;
		}

		Node parentNode = getParentNode(RootNode,key);
		Node currentNode = getCurrentNode(RootNode,key);

		// case 1: node which is deleting has no child
		if (currentNode.getLeftNode() == null
				&& currentNode.getRightNode() == null) {
			if (currentNode != RootNode) {
				if (parentNode.getRightNode() == currentNode) {
					parentNode.setRightNode(null);
				} else if (parentNode.getLeftNode() == currentNode) {
					parentNode.setLeftNode(null);
				}
			} else {
				RootNode = null;
			}
		}

		// case 2: node which is deleting has two children

		else if (currentNode.getLeftNode() != null
				&& currentNode.getRightNode() != null) {
			Node successor = getMinimumKeyNode(currentNode.getRightNode());
			currentNode.setData(successor.getData());
		    currentNode = deleteNode(currentNode.getRightNode(),successor.getData().getKey());
		}
		// node to be deleted has only one child
		else {
			Node childOfCurrentNode = currentNode.getLeftNode() == null ? currentNode
					.getRightNode() : currentNode.getLeftNode();

			if (currentNode != RootNode) {
				if (parentNode.getLeftNode() == currentNode) {
					parentNode.setLeftNode(childOfCurrentNode);
				} else {
					parentNode.setRightNode(childOfCurrentNode);
				}
			} else {
				RootNode = childOfCurrentNode;
				return RootNode;
			}
		}
		return RootNode;

	}

/**
 * getting the minimum key value node from the subtree	
 * @param currentNode
 * @return
 */
	private Node getMinimumKeyNode(Node currentNode){
		while(currentNode.getLeftNode()!=null){
			currentNode = currentNode.getLeftNode();
		}
		return currentNode;
	}

/**
 * checking id=f key exist or not in current binary tree	
 * @param key
 * @return
 */
	private boolean isNodeExist(int key){
		boolean isNodeFoundFlag = false;
		Node currentNode = RootNode;
		while(currentNode!=null){
			
			if(key>currentNode.getData().getKey()){
				currentNode = currentNode.getRightNode();
			}else if(key<currentNode.getData().getKey()){
				currentNode = currentNode.getLeftNode();
			}else{
				isNodeFoundFlag = true;
				break;
			}
		}
		return isNodeFoundFlag;
	}
	

/**
 * getting value from the binary tree;	
 */
	@Override
	public String getValue(int key) {
		return getValueOfKey(RootNode,key);
	}

/**	
 * helper method which returns the string value of current key value
 * @param currentNode
 * @param key
 * @return
 */
	private String getValueOfKey(Node currentNode, int key){
		String valueCorrespondingSpecifiedKey = "";
		try{
		if(currentNode.getData().getKey()==key){
			valueCorrespondingSpecifiedKey =  currentNode.getData().getValue();
		}else {
			if(key>currentNode.getData().getKey()){
				valueCorrespondingSpecifiedKey =  getValueOfKey(currentNode.getRightNode(),key);
			}else if(key<currentNode.getData().getKey()){
				valueCorrespondingSpecifiedKey =  getValueOfKey(currentNode.getLeftNode(), key);
			}
		}
		return valueCorrespondingSpecifiedKey;
		}catch(Exception e){
			return "NO SUCH DATA EXIST IN MAP ERROR: " + e.getMessage() ;
		}
	}

/**
 * getting sorted list of binary tree through in order traversal	
 */
	@Override
	public List<KeyValuePair> getSortedListOfKeyValuePair() {
		List<KeyValuePair> sortedList = new ArrayList<KeyValuePair>();
		getSortedList(RootNode,sortedList);
		return sortedList;
	}

/**
 * helper method for getting the sorted list
 * @param currentNode
 * @param sortedList
 */
	private void getSortedList(Node currentNode, List<KeyValuePair> sortedList){
		if(currentNode!=null){
          	getSortedList(currentNode.getLeftNode(), sortedList);
          	sortedList.add(currentNode.getData());
          	getSortedList(currentNode.getRightNode(), sortedList);
		}
	}

	/**
	 * getting the sorted list into the key range 	
	 * @param currentNode
	 * @param sortedList
	 */
	@Override
	public List<KeyValuePair> getSortedListOfKeyValuePairInRange(int key1,
			int key2) {
		List<KeyValuePair> listOfSortedKeyValuePair = getSortedListOfKeyValuePair();
		for(int index = 0; index<listOfSortedKeyValuePair.size(); index++ ){
			if(listOfSortedKeyValuePair.get(index).getKey()<key1 || listOfSortedKeyValuePair.get(index).getKey()>key2){
				listOfSortedKeyValuePair.remove(index);
				index--;
			}
		}
		return listOfSortedKeyValuePair;
	}
}
