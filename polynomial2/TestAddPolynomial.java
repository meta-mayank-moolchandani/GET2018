package polynomial2;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestAddPolynomial {
	private int expectedResults[][];
	private Poly input1;
	private Poly input2;
	
	public TestAddPolynomial(Poly input1, Poly input2,int expectedResult[][]){
		this.expectedResults = expectedResult;
		this.input1 = input1;
		this.input2 = input2;
	}	
	
	@Parameters
    public static Collection<Object[]> data() {

    int[][] test1array1 = new int[][]{{5,2,0},{3,2,7}};
	Poly test1input1 = new Poly(test1array1);
	int[][] test1array2 = new int[][]{{7,4,2,0},{5,2,3,9}};
	Poly test1input2 = new Poly(test1array2);
	int[][] test1array3 = new int[][]{{7,5,4,2,0},{5,3,2,5,16}};

    int[][] test2array1 = new int[][]{{5,2,0},{3,2,7}};
	Poly test2input1 = new Poly(test2array1);
	int[][] test2array2 = new int[][]{{5,2,0},{3,2,7}};
	Poly test2input2 = new Poly(test2array2);
	int[][] test2array3 = new int[][]{{5,2,0},{6,4,14}};

    int[][] test3array1 = new int[][]{{91,10},{100,200}};
	Poly test3input1 = new Poly(test3array1);
	int[][] test3array2 = new int[][]{{91,20},{-90,5}};
	Poly test3input2 = new Poly(test3array2);
	int[][] test3array3 = new int[][]{{91,20,10},{10,5,200}};
	
	

	return Arrays.asList(new Object[][]{{test1input1,test1input2,test1array3},{test2input1,test2input2,test2array3},{test3input1,test3input2,test3array3}});
  }

	@Test
	public void testAddPoly() {
			assertArrayEquals(expectedResults, input1.addPoly(input2).getPoly());
	}

}
