package getValue;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GetValueTest {
	List<Object> listOflist = new ArrayList<>();

	public GetValueTest() {
		listOflist.add(1);
		listOflist.add(2);
		listOflist.add(3);
		listOflist.add(4);
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		listOflist.add(list);
		List<Object> list2 = new ArrayList<Object>();
		list2.add(7);
		list2.add(8);
		list2.add(list);
		listOflist.add(list2);
	}

	@Test
	public void test1GetValue() {
		int result = GetValue.getValue("TTTTTHTH", listOflist);
		assertEquals(
				"after removing 5 elements from list and 1 eleemnt of nestsed list output will be 8",
				8, result);
	}

	@Test
	public void test2GetValue() {
		int result = GetValue.getValue("TH", listOflist);
		assertEquals("after removing the first element next head will be:", 2,
				result);
	}

	@Test(expected = AssertionError.class)
	public void test3GetValue() {
		@SuppressWarnings("unused")
		int result = GetValue.getValue("THH", listOflist); // getting assertion
															// error
	}
}
