package HexCalulator;

import java.util.*;

public class HexCalc {

	public boolean isValidate(String hexNumber) {
		boolean flag = false;
		for (int i = 0; i < hexNumber.length(); i++) {
			// Character check = new Character(hexNumber.charAt(i));

			if (Character.isDigit(hexNumber.charAt(i))
					|| Character.isAlphabetic(hexNumber.charAt(i))) {

				// System.out.println(hexNumber.charAt(i));

				if (hexNumber.charAt(i) == 'A' || hexNumber.charAt(i) == 'E'
						|| hexNumber.charAt(i) == 'I'
						|| hexNumber.charAt(i) == 'O'
						|| hexNumber.charAt(i) == 'U') {
					flag = true;
				} else {
					flag = false;
				}
			} else {
				flag = false;
			}

		}
		return flag;
	}

	public String decimalToHexaDecimal(String decNumber) {
		int decimalNumber = Integer.parseInt(decNumber);
		StringBuffer decimalString = new StringBuffer();
		while (decimalNumber > 0) {
			decimalString.append(getCharFromDecimal(decimalNumber % 16));
			decimalNumber = decimalNumber / 16;
		}

		return decimalString.reverse().toString();
	}

	public String hexadecimalToDEcimal(String HexaDecimal) {
		int number = 0;

		for (int index = 0; index < HexaDecimal.length(); index++) {
			int pos = HexaDecimal.length() - 1 - index;

			number = number + (int) Math.pow(16, index)
					* getIntFromHexa(HexaDecimal.charAt(pos));
		}
		return number + "";
	}

	public int getIntFromHexa(char ch) {

		if (Character.isDigit(ch)) {
			return Integer.parseInt(ch + "");
		} else {
			return ((int) ch - 55);
		}
	}

	public char getCharFromDecimal(int number) {
		char ch[] = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'A', 'B', 'C', 'D', 'E', 'F' };
		return ch[number];
	}

	public String addHexa(String firstHexa, String secondHexa) {
		int firstDec = Integer.parseInt(hexadecimalToDEcimal(firstHexa));
		int secondDec = Integer.parseInt(hexadecimalToDEcimal(secondHexa));
		if ((firstDec + secondDec) != 0) {
			return decimalToHexaDecimal((firstDec + secondDec) + "");
		} else {
			return "0";
		}
	}

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

	public boolean equals(String firstHexa, String secondHexa) {
		return firstHexa.equals(secondHexa);
	}
}
