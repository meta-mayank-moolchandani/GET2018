package nestedList;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestSearch extends NestedListImpl {
	List<Object> nestedList = new ArrayList<>();
	NestedListImpl operations = new NestedListImpl();

	public TestSearch() {
		nestedList.add(1);
		nestedList.add(2);
		nestedList.add(3);
		nestedList.add(4);
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		nestedList.add(list);
		List<Object> list2 = new ArrayList<Object>();
		list2.add(7);
		list2.add(8);
		list2.add(list);
		nestedList.add(list2);
	}

	@Test
	public void testSearch() {
		System.out.println("list for test1 : " + nestedList.toString());
		boolean result = operations.search(nestedList, 8);
		assertEquals("element found", true, result);
	}

	@Test
	public void test2Search() {
		nestedList.remove(5);
		System.out.println("list for test2 : " + nestedList.toString());
		boolean result = operations.search(nestedList, 8);
		assertEquals("element is not found", false, result);
	}

}
