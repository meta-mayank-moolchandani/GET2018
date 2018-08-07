package nestedList;

import java.util.List;

public class NestedListImpl implements NestedList {

/**
 * searching the element into the list	
 */
	@Override
	public boolean search(List<Object> list, Object element) {
		boolean found = false;
		int index = 0;
		while(index<list.size()){
			Object objectOfObject = list.get(index);
			if (objectOfObject instanceof Integer) {
				if((Integer)element==list.get(index)){
					found = true;
					break;
				}
			}else{
				@SuppressWarnings("unchecked")
				List<Object> innerList = ((List<Object>)list.get(index));
				found=search(innerList,element);
				if(found){break;}
			}
			index++;
		}
		return found;
	}

/**
 * sum of all integer present in the list	
 */
	@SuppressWarnings("unchecked")
	@Override
	public int sum(List<Object> list) {
		int index = 0;
		int sumOfList = 0;
		while(index<list.size()){
			Object objOfObject = list.get(index);
			if (objOfObject instanceof Integer) {
				Integer integer = (Integer) objOfObject;
				sumOfList+=integer;
			}else{
				sumOfList+=sum(((List<Object>)list.get(index)));
			}
			index++;
		}
		return sumOfList;
	}

/**
 * 
 */
	@Override
	public int largestValue(List<Object> list) {
		int index = 0; 
		int largestValue = -1;
		while(index<list.size()){
			Object objOfObject = list.get(index);
			if (objOfObject instanceof Integer) {
				Integer integerValue = (Integer) objOfObject;
				if(largestValue < integerValue){
					largestValue = integerValue;
				}
			}else{
				@SuppressWarnings("unchecked")
				int largestInNestedList = largestValue((List<Object>)list.get(index)); 
				if(largestValue< largestInNestedList){
					largestValue = largestInNestedList;
				}
			}
			index++;
			
		}
		return largestValue;
	}
}
