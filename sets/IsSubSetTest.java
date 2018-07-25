package sets;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class IsSubSetTest extends TestCase{
	private Sets dummySet1;
	private Sets dummySet2;
	
	@Override
	protected void setUp(){
		int array1[] = new int[]{1,10,15,13,2,3,4,1000};
		int array2[] = new int[]{1,10,15};
		dummySet1 = new Sets(array1);
		dummySet2 = new Sets(array2);
    }
	
	@Test
	public void test1IsSubset() {
		assertEquals(true, dummySet2.isSubset(dummySet1));
	}
	
	@Test
	public void test2IsSubset() {
		assertNotEquals(true, dummySet1.isSubset(dummySet2));
	}
	
	@Override
	protected void tearDown(){
		dummySet1 = null;
		dummySet2 = null;
		assertNull(dummySet1);
		assertNull(dummySet2);
    }

}
