package stringCache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringCache {
	private Map<String, Integer> cache = new HashMap<String,Integer>();

/**
 * getting the unique charecter count from a given string 	
 * @param inputString
 * @return
 */
	public int getUniqueCount(String inputString){
		int uniqueElements = 0;
		if(cache.containsKey(inputString)){
			return cache.get(inputString);
		}else{
			Set<Character> uniqueChatacterList = new HashSet<Character>();
			for(int index = 0; index<inputString.length(); index++){
				uniqueChatacterList.add(inputString.charAt(index));		
			}
			uniqueElements = uniqueChatacterList.size();
			cache.put(inputString, uniqueElements);
		}
		
		return uniqueElements;
	}
	

}
