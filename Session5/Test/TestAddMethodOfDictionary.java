package Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import dictionary.*;
import static org.junit.Assert.*;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class TestAddMethodOfDictionary {

	Dictionary dictionary;

	@Before
	public void initializeDictionary() throws FileNotFoundException,
			IOException, ParseException {
		dictionary = new DictionaryTree(
				JsonInputList
						.takeInput("E:\\eclipse workspace\\Ds-Assignment5\\src\\jsonFileInput\\inputFile.json"));
	}

	@Test
	public void testAddMethod() {
		boolean isAddedFlag = dictionary.add(100, "hey");
		assertEquals("no similar key exist elemet added successfully",true, isAddedFlag);
	}

	@Test
	public void test2AddMethod() {
		dictionary.add(100, "dsa");
		boolean isAddedFlag = dictionary.add(100, "hey");
		assertEquals("two same keys can not be added" , false, isAddedFlag);
	}
}
