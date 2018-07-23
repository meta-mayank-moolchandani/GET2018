package arraySearchTesting;
import arraySearch.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestBinarySearch {


	@Test
	public void test1BinarySearch() {
		Search search = new Search();
		int array[] = new int[]{1,3,15,17,20};
		int actualResult = search.binarySearch(array, 15);
		System.out.println(actualResult);
		int expectedResult = 2;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void test2BinarySearch() {
		Search search = new Search();
		int array[] = new int[]{15,102,900,1020};
		int actualResult = search.binarySearch(array, 1020);
		
		System.out.println(actualResult);
		int expectedResult = 3;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void test3BinarySearch() {
		Search search = new Search();
		int array[] = new int[]{1,15,102,900,1020};
		int actualResult = search.binarySearch(array, 201);
		int expectedResult = -1;
		System.out.println(actualResult);
		assertEquals(expectedResult, actualResult);
	}
}
