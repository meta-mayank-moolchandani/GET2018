package polynomial2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestGetDegree{
	private Poly poly;
	private int expectedResults;

//	poly = new Poly(a);
	
	public TestGetDegree(Poly p1, int expectedResult){
		this.poly = p1;
		this.expectedResults = expectedResult;
	}	
		
	
	
	@Parameters
    public static Collection<Object[]> data() {
	int[][] array1 = new int[][]{{1,18,19,20,12,3},{10,20,30,40,50,60}};
	Poly p1 = new Poly(array1);
	int[][] array2 = new int[][]{{1,5},{60,20}};
	Poly p2 = new Poly(array2);
	int[][] array3 = new int[][]{{12,3},{50,60}};
	Poly p3 = new Poly(array3);
	return Arrays.asList(new Object[][]{{p1,20},{p2,5},{p3,12}});
	}
	
	@Test
	public void testGetDegree() {
		System.out.println(poly.getDegree());
		assertEquals(expectedResults,poly.getDegree());
	}

}
