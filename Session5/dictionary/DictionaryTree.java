package dictionary;

import java.util.*;

public class DictionaryTree implements Dictionary{
	private Node RootNode;

	public DictionaryTree(List<KeyValuePair> listOfInitialInput) {
		this.RootNode = null;
		for (KeyValuePair pair : listOfInitialInput) {
			this.add(pair.getKey(), pair.getValue());
		}
	}

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

	@Override
	public boolean delete(int key) {
		if(deleteNode(RootNode, key)==null){
			return true;
		}
		
		return false;
	}
	
	private Node deleteNode(Node currentRootNode, int key) {
		Node parentNode = null;
		Node currentNode = currentRootNode;

		// currentNode location of node
		while (currentNode != null && currentNode.getData().getKey() != key) {
			parentNode = currentNode;

			if (key < currentNode.getData().getKey()) {
				currentNode = currentNode.getLeftNode();
			} else {
				currentNode = currentNode.getRightNode();
			}
		}

		//System.out.println("curr" + currentNode.getData().getKey());
		//System.out.println("par" + parentNode.getData().getKey());


		// case1:delete leaf node

		if (currentNode.getLeftNode() == null
				&& currentNode.getRightNode() == null) {
			if (currentNode != currentRootNode) {
				if (parentNode.getLeftNode() == currentNode) {
					parentNode.setLeftNode(null);
				} else {
					parentNode.setRightNode(null);
				}
			} else {
				currentNode = null;
			}
		} else {
			currentRootNode = null;
		}
		
		//case2 delete Node which has only one child
		if (currentNode != RootNode) {
			if (currentNode.getLeftNode() == null
					&& currentNode.getRightNode() != null) {
				parentNode.setLeftNode(currentNode.getRightNode());
			}

			if (currentNode.getRightNode() == null
					&& currentNode.getLeftNode() != null) {
				parentNode.setRightNode(currentNode.getLeftNode());
			}
		} else {
			currentNode = null;
		}
		
		//case3 delete Node which has 2 childs
		
		if(currentNode!=null){
			if(currentNode.getLeftNode()!=null && currentNode.getRightNode()!=null){
				Node node = getMinimumKey(currentNode);
				int val = node.getData().getKey();
				deleteNode(RootNode,node.getData().getKey());
				currentNode.getData().setKey(val);
				
			}
		}	
		return null;
	}
	
	private Node getMinimumKey(Node currentNode){
		while(currentNode!=null){
			currentNode = currentNode.getLeftNode();
		}
		return currentNode;
	}

	@Override
	public String getValue(int key) {
		return getValueOfKey(RootNode,key);
	}
	
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

	@Override
	public List<KeyValuePair> getSortedListOfKeyValuePair() {
		List<KeyValuePair> sortedList = new ArrayList<KeyValuePair>();
		getSortedList(RootNode,sortedList);
		return sortedList;
	}
	
	private void getSortedList(Node currentNode, List<KeyValuePair> sortedList){
		if(currentNode!=null){
          	getSortedList(currentNode.getLeftNode(), sortedList);
          	sortedList.add(currentNode.getData());
          	getSortedList(currentNode.getRightNode(), sortedList);
		}
	}

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
