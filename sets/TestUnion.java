package sets;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;

public class TestUnion extends TestCase {
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
	public void test1Union() {
		Sets union = dummySet1.union(dummySet2);
		int expectedOutput[] = {1,2,3,4,10,13,15,1000};
		assertArrayEquals(expectedOutput, union.getSet());
    }
	
	@Override
	protected void tearDown(){
		dummySet1 = null;
		dummySet2 = null;
		assertNull(dummySet1);
		assertNull(dummySet2);
    }

}
