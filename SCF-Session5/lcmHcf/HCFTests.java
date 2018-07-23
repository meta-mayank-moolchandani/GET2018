package lcmHcf;

import static org.junit.Assert.*;

import org.junit.Test;

public class HCFTests {

	@Test
	public void test1() {
		HCF objOfHCF = new HCF();
		int expectedResult = 5;
		int actualResult = objOfHCF.hcf(5,10);
		System.out.println(actualResult);
		assertEquals(expectedResult, actualResult);

	}
	
	@Test
	public void test2() {
		HCF objOfHCF = new HCF();
		int expectedResult = 1;
		int actualResult = objOfHCF.hcf(8,27);
		assertEquals(expectedResult, actualResult);

	}
	
	@Test
	public void test3() {
		HCF objOfHCF = new HCF();
		int expectedResult = 13;
		int actualResult = objOfHCF.hcf(91,104);
		assertEquals(expectedResult, actualResult);

	}
	
	@Test(expected=ArithmeticException.class)
	public void test4() {
		HCF objOfHCF = new HCF();
		int expectedResult = 5;
		int actualResult = objOfHCF.hcf(0,10);
		assertEquals(expectedResult, actualResult);

	}
	
	@Test
	public void test5() {
		HCF objOfHCF = new HCF();
		int expectedResult = 1;
		int actualResult = objOfHCF.hcf(1,7);
		assertEquals(expectedResult, actualResult);

	}
	
	@Test(expected=ArithmeticException.class)
	public void test6() {
		HCF objOfHCF = new HCF();
		int expectedResult = 5;
		int actualResult = objOfHCF.hcf(0,0);
		assertEquals(expectedResult, actualResult);

	}

}
