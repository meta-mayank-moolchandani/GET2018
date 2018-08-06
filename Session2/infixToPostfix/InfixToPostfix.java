package infixToPostfix;
import stack.*;

public class InfixToPostfix {

/**
 * checking if infixExpression is valid or not
 * @param infixExpression
 * @return
 */
	private boolean isValidExpression(String infixExpression) {
		boolean flag = false;
		String[] array = infixExpression.split(" ");
		int characterCount = 0;
		int operatorCount = 0;

		for (int i = 0; i < array.length; i++) {
			if (("(".equals(array[i])) || (")".equals(array[i]))
					|| ("[".equals(array[i])) || ("]".equals(array[i]))){
				continue;
			}

			
			if (isCharacter(array[i])) {
				characterCount++;
			}
			if (isOperator(array[i])) {
				operatorCount++;
			}
		}
		if (characterCount == operatorCount + 1) {
			flag = true;
		}

		return flag;
	}

/**
 * checking given string is character or not	
 * @param character
 * @return
 */
	private boolean isCharacter(String character){
		boolean flag = false;
	
		if(character.length()==1){
			
		
		
		if(Character.isLetter(character.charAt(0))){
			flag = true;
		}
		}
		return flag;
	}

/**
 * checking operator is the given operand or not	
 * @param operator
 * @return
 */
	private boolean isOperator(String operator) {
		boolean flag = false;
		if (("(".equals(operator)) || (")".equals(operator))
				|| ("[".equals(operator)) || ("]".equals(operator))
				|| ("*".equals(operator)) || ("/".equals(operator))
				|| ("+".equals(operator)) || ("-".equals(operator))
				|| (">".equals(operator)) || ("<".equals(operator))
				|| (">=".equals(operator)) || ("<=".equals(operator))
				|| ("==".equals(operator)) || ("!=".equals(operator))
				|| ("||".equals(operator)) || ("||".equals(operator))) {
			flag = true;
		}
		return flag;
	}

/**
 * getting the precedence of the operator	
 * @param operator
 * @return
 */
	private int getPrecedence(String operator) {
		int precedence = -1;
		switch (operator) {
		case "[":
		case "]":
		case "(":
		case ")":
			precedence = 10;
			break;
		case "*":
		case "/":
			precedence = 2;
			break;
		case "+":
		case "-":
			precedence = 3;
			break;
		case ">":
		case "<":
		case ">=":
		case "<=":
			precedence = 4;
			break;
		case "==":
		case "!=":
			precedence = 5;
			break;
		case "&&":
			precedence = 6;
			break;
		case "||":
			precedence = 7;
			break;
		}
		return precedence;
	}
   
/**
 * evaluating the postfix expression	
 * @param infixExpression
 * @return
 */
	public String evaluatPostfixExpression(String infixExpression) {
		if(!isValidExpression(infixExpression)){
			throw new RuntimeException("invalid expression");
		}
		String postfixString = "";
		String tokens[] = infixExpression.split(" ");
		Stack<String> stack = new StackLinklist<String>();
		for (int index = 0; index < tokens.length; index++) {
			if (isCharacter(tokens[index])) {
				postfixString += tokens[index] + " ";
			} else {
				if (stack.top() == null || "(".equals(tokens[index])) {
					stack.push(tokens[index]);
				} else {
					if (")".equals(tokens[index]) || "]".equals(tokens[index])) {
						while (true) {
							if ((stack.top()).equals("(")
									|| (stack.top()).equals("{")) {
								break;
							} else {
								postfixString += stack.top() + " ";
								stack.pop();
							}
						}
						while (("(".equals(stack.top()))
								|| ("[".equals(stack.top()))) {
							stack.pop();
						}
					} else {
						int pre1 = getPrecedence(tokens[index]);
						int pre2 = getPrecedence(stack.top());
						if (pre1 < pre2) {
							stack.push(tokens[index]);
						} else {
							postfixString += stack.top() + " ";
							stack.pop();
							int prex1 = getPrecedence(tokens[index]);
							int prex2 = getPrecedence(stack.top());
							if (prex1 == prex2) {
								postfixString += stack.top() + " ";
								stack.pop();
								stack.push(tokens[index]);
							} else {
								stack.push(tokens[index]);
							}
						}
					}
				}
			}
		}
		while (stack.top() != null) {
			postfixString += stack.top() + " ";
			stack.pop();
		}
		return postfixString;
	}
}
