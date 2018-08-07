package evalPostfix;

import stack.*;


public class EvaluatePostfix {
	
/**
 * checking the validity of the expression
 * @param postfixExpression
 * @return
 */
	private boolean isValidExpression(String postfixExpression) {
		boolean flag = false;
		String array[] = postfixExpression.split(" ");
		int operatorCount = 0;
		int numberCount = 0;
		for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++) {
			if (isNumber(array[arrayIndex])) {
				numberCount++;
			}

			if (isOperator(array[arrayIndex])) {
				operatorCount++;
			}
		}
		if ((numberCount + operatorCount == array.length)
				&& (numberCount == operatorCount + 1)) {
			flag = true;
		}
		return flag;
	}

/**
 * checking that operator is valid or not 	
 * @param operator
 * @return
 */
	private boolean isOperator(String operator) {
		boolean flag = false;
		if ( ("*".equals(operator)) || ("+".equals(operator)) || ("-".equals(operator)) || ("/".equals(operator)) ) {
			flag = true;
		}
		return flag;
	}
/**
 * checking input is a valid number or not	
 * @param number
 * @return
 */
	private boolean isNumber(String number) {
		try {
			@SuppressWarnings("unused")
			int intNumber = Integer.parseInt(number);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

/**
 * returns the evaluated result of both the number	
 * @param firstNumber
 * @param secondNumber
 * @param operator
 * @return
 */
	private int performOperation(int firstNumber, int secondNumber, String operator) {
		int result;
		switch (operator) {
		case "*":
			result = firstNumber * secondNumber;
			break;
		case "+":
			result = firstNumber + secondNumber;
			break;
		case "-":
			result = firstNumber - secondNumber;
			break;
		case "/":
			result = firstNumber / secondNumber;
			break;
		default:
			result = 0;
			break;
		}

		return result;
	}

/**
 * evaluates the postfix expression 	
 * @param postfixExpression
 * @return the result of postfix expression
 */
	public int evaluateExpression(String postfixExpression) {
		Stack<Integer> stack = new StackLinklist<Integer>();
		if (isValidExpression(postfixExpression)) {
			String array[] = postfixExpression.split(" ");
			for (int index = 0; index < array.length; index++) {
				if (isNumber(array[index])) {
					stack.push(Integer.parseInt(array[index]));
				}
				if (isOperator(array[index])) {
					int firstNumber = stack.top();
					stack.pop();
					int secondNumber = stack.top();
					stack.pop();
					stack.push(performOperation(secondNumber, firstNumber,
							array[index]));
				}
			}
		}else{
			throw new RuntimeException("expression was invalid");
		}

		return stack.top();
	}	
}
