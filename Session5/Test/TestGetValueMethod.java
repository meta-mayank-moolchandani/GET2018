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

public class TestGetValueMethod {

	Dictionary dictionary;

	@Before
	public void initializeDictionary() throws FileNotFoundException,
			IOException, ParseException {
		dictionary = new DictionaryTree(
				JsonInputList
						.takeInput("D:\\GETt\\DS-Assignment5\\src\\jsonFileInput\\inputFile.json"));
	}

	@Test
	public void testAddMethod() {
	    dictionary.add(100, "hey");
		String actualResult = dictionary.getValue(100);
		assertEquals("no similar key exist elemet added successfully","hey", actualResult);
	}

	@Test
	public void test2AddMethod() {
	    assertEquals("NO SUCH DATA EXIST IN MAP ERROR: null", dictionary.getValue(5000));
	  }
	}
