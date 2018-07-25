package sets;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class IsMemeberTest1 extends TestCase {
	private Sets dummySet;
	
	@Override
	protected void setUp(){
		int array[] = new int[]{1,10,15,13,2,3,4,1000};
		dummySet = new Sets(array);
    }

	@Test
	public void test1IsMemeber() {
		assertEquals(true, dummySet.isMemeber(1));
	}
	
	@Test
	public void test2IsMemeber() {
		assertNotEquals(true, dummySet.isMemeber(200));
	}
	
	@Test
	public void test3IsMemeber() {
		assertEquals(true, dummySet.isMemeber(1000));
	}
	
	@Test
	public void test4IsMemeber() {
		assertEquals(true, dummySet.isMemeber(3));
	}
	
	@Test
	public void test5IsMemeber() {
		assertNotEquals(true, dummySet.isMemeber(201));
	}
	
	@Override
	protected void tearDown(){
		dummySet = null;
		assertNull(dummySet);
    }

}
