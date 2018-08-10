package dictionary;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import org.json.simple.parser.ParseException;


public class JaiBhawani {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	List<KeyValuePair> list = 	JsonInputList.takeInput("D:\\GETt\\DS-Assignment5\\src\\jsonFileInput\\inputFile.json");
	
	System.out.println("-----------");
	for(KeyValuePair pair: list){
		System.out.println(pair.toString());
	}

	Dictonary dict = new DictionaryTree(list);
	System.out.println(dict.add(5, "hey"));
	System.out.println(dict.add(3, "A"));
	System.out.println(dict.add(1, "B"));
	System.out.println(dict.add(4, "C"));
	System.out.println(dict.add(4, "D"));
	System.out.println(dict.add(10, "hey"));
	System.out.println(dict.add(100, "A"));
	System.out.println(dict.add(201, "B"));
	System.out.println(dict.add(2, "C"));
	System.out.println(dict.add(13, "D"));

	System.out.println(dict.getValue(5));
	System.out.println(dict.getValue(3));
	System.out.println(dict.getValue(1));
	System.out.println(dict.getValue(4));
	
	System.out.println(dict.getSortedListOfKeyValuePair().toString());
	System.out.println(dict.getSortedListOfKeyValuePairInRange(500, 600).toString());


	System.out.println(dict.getValue(10));
	
	dict.delete(13);   
	System.out.println(dict.getSortedListOfKeyValuePair().toString());
	
	dict.delete(1);
	System.out.println(dict.getSortedListOfKeyValuePair().toString());
	
	dict.delete(5);
	System.out.println(dict.getSortedListOfKeyValuePair().toString());
	
	
	
	}
}
