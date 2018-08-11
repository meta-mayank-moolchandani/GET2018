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
import dictionary.KeyValuePair;

public class SortInRange {
	Dictionary dictionary;

	@Before
	public void initializeDictionary() throws FileNotFoundException,
			IOException, ParseException {
		dictionary = new DictionaryTree(
				JsonInputList
						.takeInput("E:\\eclipse workspace\\Ds-Assignment5\\src\\jsonFileInput\\inputFile.json"));
	}

	@Test
	public void testSortMethod() {
		int [] sortedKeyList = new int[dictionary.getSortedListOfKeyValuePairInRange(3, 13).size()];
		int index =0;
		for(KeyValuePair pair:dictionary.getSortedListOfKeyValuePairInRange(3,13) ){
			sortedKeyList[index] = pair.getKey();
			index++;
		}
		int actualResult[] = new int[]{3, 5, 7, 9, 12, 13};
		assertArrayEquals("sorted list",sortedKeyList, actualResult);
	}

}
