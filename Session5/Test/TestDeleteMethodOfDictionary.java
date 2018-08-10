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
						.takeInput("D:\\GETt\\DS-Assignment5\\src\\jsonFileInput\\inputFile.json"));
	}

	@Test
	public void testDeleteMethodForLeafNode() {
		boolean isDeleteFlag = dictionary.delete(17);
		assertEquals("no similar key exist elemet added successfully",true, isDeleteFlag);
	}

	@Test
	public void test2DeleteNodeWhichHave2Child() {
		boolean isDeleteFlag = dictionary.delete(1);
		
		assertEquals("two same keys can not be added" , true, isDeleteFlag);
	}

}
