package getValue;

import java.util.List;

public class GetValue {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int getValue(String pattern, List<Object> inputList) {
		int value = -1;
		for (int index = 0; index < pattern.length(); index++) {
			if (pattern.charAt(index) == 'H') {
				Object objectOfObject = inputList.get(0);
				if (index == pattern.length() - 1) {
					if (objectOfObject instanceof List) {
						throw new AssertionError("ERROR");
					} else {
						value = (Integer) objectOfObject;
						break;
					}
				} else {
					if (objectOfObject instanceof List) {
						value = getValue(
								pattern.substring(index + 1, pattern.length()),
								(List) objectOfObject);
						break;
					} else {
						throw new AssertionError("ERROR");
					}
				}
			} else if (pattern.charAt(index) == 'T') {
				inputList.remove(0);
			} else {
				throw new AssertionError();
			}
		}
		return value;
	}
}
