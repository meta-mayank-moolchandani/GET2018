package jsonInput;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestGetList {
	List<Object> listOflist = new ArrayList<>();

	public TestGetList() {
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
	public void testGetList() {
		JsonInput jsReadFile = new JsonInput(
				"D://GETt//DS-Assignment2//src//jsonInput//jsonFiles//data3.json");
		List<Object> result = jsReadFile.getList();
		assertEquals("both lists are same ", listOflist, result);
	}

}
