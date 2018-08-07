package evalPostfix;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestevaluateExpression {

	@Test
	public void testEvaluateExpression() {
		EvaluatePostfix eval = new EvaluatePostfix();
		int result = eval.evaluateExpression("10 12 * 9 13 * + 11 -");
		assertEquals("evaluated expression will be 226", 226, result);
	}

	@Test
	public void test2EvaluateExpression() {
		EvaluatePostfix eval = new EvaluatePostfix();
		int result = eval.evaluateExpression("10 5 / 3 +");
		assertEquals("evaluated expression will be 5", 5, result);
	}

	@Test
	public void test3EvaluateExpression() {
		EvaluatePostfix eval = new EvaluatePostfix();
		String actualExceptionMessage = "";
		try {
			@SuppressWarnings("unused")
			int result = eval.evaluateExpression("10 12 % 9 13 * + 11 -");
		} catch (Exception e) {
			actualExceptionMessage = e.getMessage();
		}
		assertEquals("expression is not valid due to '%' operator, program will throw exception",
				"expression was invalid", actualExceptionMessage);
	}

}
