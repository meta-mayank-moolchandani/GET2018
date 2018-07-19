package stringOperation;

public class StringOperations {

	/**
	 * compare both strings and returns 1 if both are matched
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static int compare(String first, String second) {
		int flag = 0;
		for (int index = 0; index < first.length(); index++) {
			flag = 0;
			if (first.charAt(index) == second.charAt(index)) {
				flag = 1;
			} else {
				flag = 0;
				break;
			}
		}
		return flag;
	}

	/**
	 * returns the reverse of the string
	 * 
	 * @param first
	 * @return
	 */
	public static String reverse(String first) {

		String reverseString = "";
		for (int index = first.length() - 1; index >= 0; index--) {
			reverseString += first.charAt(index);
		}
		return reverseString;
	}

	/**
	 * inverse the case of the string
	 * 
	 * @param input
	 * @return
	 */
	public static String inverseCase(String input) {
		String inverseString = "";
		for (int index = 0; index < input.length(); index++) {
			if (((int) input.charAt(index)) >= 65
					&& ((int) input.charAt(index)) <= 90) {
				inverseString += (char) ((int) input.charAt(index) + 32);
			} else if (((int) input.charAt(index)) >= 97
					&& ((int) input.charAt(index)) <= 122) {
				inverseString += (char) ((int) input.charAt(index) - 32);
			} else {
				inverseString += input.charAt(index);
				continue;
			}
		}

		return inverseString;
	}
/**
 * find the longgest word in given line	
 * @param input
 * @return
 */
	public static String longestWord(String input) {
		int arraySize = 1;
		for (int index = 0; index < input.length(); index++) {
			if (((int) input.charAt(index)) == 32) {
				arraySize++;
			}
		}

		String wordsSplitted[] = new String[arraySize];
		String word = "";
		String maxword = "";
		int wIndex = 0;
		for (int index = 0; index < arraySize; index++) {
			word = "";
			while (wIndex < input.length()) {
				if (((int) input.charAt(wIndex)) == 32) {
					wIndex++;
					break;
				} else {
					word = word + input.charAt(wIndex);
					wIndex++;
				}
				wordsSplitted[index] = word;
			}
			if (maxword.length() < word.length()) {
				maxword = word;
			}

		}

		return maxword;

	}

}
