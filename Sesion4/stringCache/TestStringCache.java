package stringCache;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringCache {
	StringCache operation = new StringCache();

	@Test
	public void test1GetUniqueCount() {
		int actual = operation.getUniqueCount("abbcde");
		assertEquals(5, actual);
	}
	
	@Test
	public void test2GetUniqueCount() {
		int actual = operation.getUniqueCount("abbcde");
		assertEquals(5, actual);
	}

	@Test
	public void test3GetUniqueCount() {
		int actual = operation.getUniqueCount("abbbbbcddddde");
		assertEquals(5, actual);
	}
}
