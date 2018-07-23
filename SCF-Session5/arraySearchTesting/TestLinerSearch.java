package arraySearchTesting;
import arraySearch.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinerSearch {

	@Test
	public void test1LinearSearch() {
		Search search = new Search();
		int array[] = new int[]{13,1,7,15,3,4};
		int actualResult = search.linearSearch(array, 15);
		int expectedResult = 3;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void test2LinearSearch() {
		Search search = new Search();
		int array[] = new int[]{13,1,7,15,3,4};
		int actualResult = search.linearSearch(array, 13);
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void test3LinearSearch() {
		Search search = new Search();
		int array[] = new int[]{13,1,7,15,3,4};
		int actualResult = search.linearSearch(array, 201);
		int expectedResult = -1;
		assertEquals(expectedResult, actualResult);
	}
}