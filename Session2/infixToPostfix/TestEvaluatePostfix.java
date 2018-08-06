package infixToPostfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEvaluatePostfix {

	@Test
	public void test1EvaluatPostfixExpression() {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		String actualResult = infixToPostfix.evaluatPostfixExpression("A + ( B * C - ( D / E - F ) * G ) * H");
		String expectedResult = "A B C * D E / F - G * - H * + ";
		assertEquals("output is evaluated properly", expectedResult, actualResult);
     }

	
	@Test
	public void test2EvaluatPostfixExpression() {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		String actualResult = infixToPostfix.evaluatPostfixExpression("A + B");
		String expectedResult = "A B + ";
		assertEquals("output is evaluated properly", expectedResult, actualResult);
     }
	
	@Test
	public void test3EvaluatPostfixExpression() {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		String message = "";
		try{
		@SuppressWarnings("unused")
		String actualResult = infixToPostfix.evaluatPostfixExpression("A + B%");
		}catch(Exception e){
			message = e.getMessage();
		}
		assertEquals("cant evaluate as expression is invalid ", "invalid expression" , message);
     }

}
