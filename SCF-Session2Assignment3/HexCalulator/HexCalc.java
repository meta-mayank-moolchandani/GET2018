package HexCalulator;

public class HexCalc {
/**
 * check hexadecimal number is a validate number or not
 * @param hexNumber
 * @return
 */
	static public boolean isValidate(String hexNumber) {
		char ch[] = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		boolean flagIsHex = true;
		boolean flagIsChar = true;

		for (int i = 0; i < hexNumber.length(); i++) {
			for (int j = 0; j < ch.length; j++) {
				flagIsChar = false;
				if (hexNumber.charAt(i) == ch[j]) {
					flagIsChar = true;
					break;
				}
			}
			if (!flagIsChar) {
				flagIsHex = false;
			}
		}
		return flagIsHex;
	}

/**
 * converts decimal number to hexadecimal number	
 * @param decNumber
 * @return
 */
	public String decimalToHexaDecimal(String decNumber) {
		int decimalNumber = Integer.parseInt(decNumber);
		StringBuffer decimalString = new StringBuffer();
		while (decimalNumber > 0) {
			decimalString.append(getCharFromDecimal(decimalNumber % 16));
			decimalNumber = decimalNumber / 16;
		}

		return decimalString.reverse().toString();
	}
	
/**
 * convert decimal to hexadecimal number	
 * @param HexaDecimal
 * @return
 */

	public String hexadecimalToDEcimal(String HexaDecimal) {
		int number = 0;

		for (int index = 0; index < HexaDecimal.length(); index++) {
			int pos = HexaDecimal.length() - 1 - index;

			number = number + (int) Math.pow(16, index)
					* getIntFromHexa(HexaDecimal.charAt(pos));
		}
		return number + "";
	}

/**
 * for getting a integer value from a hexadecimal character	
 * @param ch
 * @return
 */
	public int getIntFromHexa(char ch) {

		if (Character.isDigit(ch)) {
			return Integer.parseInt(ch + "");
		} else {
			return ((int) ch - 55);
		}
	}

/**
 * 	for geeting a character value from the decimal integer 
 * @param number
 * @return
 */
     public char getCharFromDecimal(int number) {
		char ch[] = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		return ch[number];
	}
/**
 * for adding two hexadecimal numbers
 * @param firstHexa
 * @param secondHexa
 * @return
 */
	public String addHexa(String firstHexa, String secondHexa) {
		int firstDec = Integer.parseInt(hexadecimalToDEcimal(firstHexa));
		int secondDec = Integer.parseInt(hexadecimalToDEcimal(secondHexa));
		if ((firstDec + secondDec) != 0) {
			return decimalToHexaDecimal((firstDec + secondDec) + "");
		} else {
			return "0";
		}
	}

/**
 * for subtracting two hexadecimal number	
 * @param firstHexa
 * @param secondHexa
 * @return
 */
	public String subtractHexa(String firstHexa, String secondHexa) {
		int firstDec = Integer.parseInt(hexadecimalToDEcimal(firstHexa));
		int secondDec = Integer.parseInt(hexadecimalToDEcimal(secondHexa));
		int result = firstDec - secondDec;
		if (result > 0) {
			return decimalToHexaDecimal(result + "");
		} else if (result < 0) {
			return "-" + decimalToHexaDecimal((-result) + "");
		} else {
			return "0";
		}
	}

/**
 * 	for multyplying two hexa decimal number
 * @param firstHexa
 * @param secondHexa
 * @return
 */
	public String multiplyHexa(String firstHexa, String secondHexa) {
		int firstDec = Integer.parseInt(hexadecimalToDEcimal(firstHexa));
		int secondDec = Integer.parseInt(hexadecimalToDEcimal(secondHexa));
		int result = firstDec * secondDec;
		if (result > 0) {
			return decimalToHexaDecimal(result + "");
		} else {
			return "0";
		}
	}

/**
 * divide two hexa decimal number 
 * @param firstHexa
 * @param secondHexa
 * @return
 */
	public String divideHexa(String firstHexa, String secondHexa) {
		int firstDec = Integer.parseInt(hexadecimalToDEcimal(firstHexa));
		int secondDec = Integer.parseInt(hexadecimalToDEcimal(secondHexa));
		int result;
		try {
			result = firstDec / secondDec;
			if (result > 0) {
				return decimalToHexaDecimal(result + "");
			} else {
				return "0";
			}
		} catch (ArithmeticException e) {
			System.out.println("divide by zero error");
		}

		return "0";
	}

/**
 * check if first number is greater than second or not	
 * @param firstHexa
 * @param secondHexa
 * @return
 */
	public boolean greaterThan(String firstHexa, String secondHexa) {
		if (firstHexa.length() == secondHexa.length()) {
			if (firstHexa.compareTo(secondHexa) > 0) {
				return true;
			} else {
				return false;
			}
		} else if (firstHexa.length() < secondHexa.length()) {
			return false;
		} else {
			return true;
		}

	}

/**
 * check if first number is less than second or not	
 * @param firstHexa
 * @param secondHexa
 * @return
 */
	public boolean lessThan(String firstHexa, String secondHexa) {
		if (firstHexa.length() == secondHexa.length()) {
			if (firstHexa.compareTo(secondHexa) < 0) {
				return true;
			} else {
				return false;
			}
		} else if (firstHexa.length() < secondHexa.length()) {
			return true;
		} else {
			return false;
		}

	}

/**
 * if both hexadecimal number are same than return true	
 * @param firstHexa
 * @param secondHexa
 * @return
 */
	public boolean equals(String firstHexa, String secondHexa) {
		return firstHexa.equals(secondHexa);
	}
}
