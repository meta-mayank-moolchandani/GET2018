package Test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import dictionary.Dictionary;
import dictionary.DictionaryTree;
import dictionary.JsonInputList;

public class TestDeleteMethodOfDictionary {

	Dictionary dictionary;

	@Before
	public void initializeDictionary() throws FileNotFoundException,
			IOException, ParseException {
		dictionary = new DictionaryTree(
				JsonInputList
						.takeInput("E:\\eclipse workspace\\Ds-Assignment5\\src\\jsonFileInput\\inputFile.json"));
	}

	@Test
	public void testDeleteMethodForElementWhichDoesNotExistInTree() {
		boolean isDeleteFlag = dictionary.delete(200);
		assertEquals("can not be delete element is not present in tree ",false, isDeleteFlag);
	}

	@Test
	public void test2DeleteNodeWhichHave1Child() {
		boolean isDeleteFlag = dictionary.delete(1);
		
		assertEquals("node deleted" , true, isDeleteFlag);
	}
	
	@Test
	public void test2DeleteNodeWhichHave2Child() {
		boolean isDeleteFlag = dictionary.delete(12);
		assertEquals("node deleted" , true, isDeleteFlag);
	}
	
	@Test
	public void test2DeleteNodeWhichHaveNoChild() {
		boolean isDeleteFlag = dictionary.delete(9);
		assertEquals("node deleted" , true, isDeleteFlag);
	}



}
