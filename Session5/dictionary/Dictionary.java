package dictionary;

import java.util.List;

public interface Dictionary {
	public boolean add(int key, String value);

	public boolean delete(int key);

	public String getValue(int key);

	public List<KeyValuePair> getSortedListOfKeyValuePair();

	public List<KeyValuePair> getSortedListOfKeyValuePairInRange(int key1,
			int key2);
}
