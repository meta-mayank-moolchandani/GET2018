package jsonInput;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JsonInput {
	private String inputStringOfNestedList;

/**
 * constructor for getting the input from the json file	
 * @param path
 */
	JsonInput(String path) {
		try {
			Object obj = new JSONParser().parse(new FileReader(path));
			JSONObject jo = (JSONObject) obj;
			this.inputStringOfNestedList = (String) jo.get("input");

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}

	}

/**
 * get list from json input	
 * @return
 */
	public List<Object> getList(){
		return convertStringToList(inputStringOfNestedList);
	}
	

/**
 * converting string to list of object	
 * @param inputListString
 * @return
 */
	private List<Object> convertStringToList(String inputListString) {
		List<Object> nestedList = new ArrayList<Object>();
		for (int index = 1; index < inputListString.length(); index++) {
			if (inputListString.charAt(index) == ',') {
				continue;
			}

			if (inputListString.charAt(index) != '[' && inputListString.charAt(index) != ']') {
				nestedList.add(Integer.parseInt(inputListString.charAt(index) + ""));
			} else {
				if (inputListString.charAt(index) == '[') {
					int closeBraceIndex = index;
					while (!(inputListString.charAt(closeBraceIndex) == ']')) {
						closeBraceIndex++;
					}
					closeBraceIndex++;
					nestedList.add( convertStringToList(inputListString.substring(index,
							closeBraceIndex + 1)));
					index = closeBraceIndex;
				}
			}
		}

		return nestedList;
	}

}
