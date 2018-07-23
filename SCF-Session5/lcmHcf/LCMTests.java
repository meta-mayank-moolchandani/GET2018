package lcmHcf;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCMTests {

	@Test
	public void test1() {
		LCM objOfLCM = new LCM(7,8);
		int expectedResult = 56;
		int actualResult = objOfLCM.calculateLcm();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test2() {
		LCM objOfLCM = new LCM(15,17);
		int expectedResult = 255;
		int actualResult = objOfLCM.calculateLcm();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test3() {
		LCM objOfLCM = new LCM(4,12);
		int expectedResult = 12;
		int actualResult = objOfLCM.calculateLcm();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = ArithmeticException.class)
	public void test4() {
		LCM objOfLCM = new LCM(0,3);
		int expectedResult = 56;
		int actualResult = objOfLCM.calculateLcm();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test(expected = ArithmeticException.class)
	public void test5() {
		LCM objOfLCM = new LCM(0,0);
		int expectedResult = 0;
		int actualResult = objOfLCM.calculateLcm();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void test6() {
		LCM objOfLCM = new LCM(5,5);
		int expectedResult = 5;
		int actualResult = objOfLCM.calculateLcm();
		assertEquals(expectedResult, actualResult);
	}

}
