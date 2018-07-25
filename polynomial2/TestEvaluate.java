package polynomial2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEvaluate {
	private float expectedResults;
	private float input; 
	private Poly poly;
	
	public TestEvaluate(Poly poly,float expectedResult,float input){
		this.expectedResults = (float)expectedResult;
		this.input = (float)input;
		this.poly = poly;
	}	
	
	@Parameters
    public static Collection<Object[]> data() {
	int[][] array1 = new int[][]{{1,2,3},{10,10,10}};
	Poly p1 = new Poly(array1);
	
	
	int[][] array2 = new int[][]{{1},{3}};
	Poly p2 = new Poly(array2);
	int[][] array3 = new int[][]{{},{}};
	Poly p3 = new Poly(array3);
	return Arrays.asList(new Object[][]{{p1,30,1},{p2,9,3},{p3,0,0}});
  }

	@Test
	public void test() {
		assertEquals(expectedResults,poly.Evaluate(input),0.0002);
	}

}
