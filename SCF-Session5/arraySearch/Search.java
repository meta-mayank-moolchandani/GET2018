package arraySearch;

public class Search {

	/**
	 * helper function for searching the element
	 * 
	 * @param array
	 * @param element
	 * @return
	 */
	public int linearSearch(int array[], int element) {
		return searchLinearly(array, element, 0);
	}

	/**
	 * performing linear search
	 * 
	 * @param array
	 * @param element
	 *            is the element which is searched in array
	 * @param index
	 *            is the index of the element
	 * @return
	 */
	public int searchLinearly(int array[], int element, int index) {
		if (index == array.length) {
			return -1;
		}

		if (array[index] == element) {
			return index;
		}
		index++;
		return searchLinearly(array, element, index);
	}

	/**
	 * function is used for calling the searchbinary
	 * 
	 * @param array
	 * @param element
	 * @return
	 */
	public int binarySearch(int array[], int element) {
		return searchBinary(array, 0, array.length - 1, element);
	}

	/**
	 * performing binary search operation
	 * 
	 * @param array
	 * @param start
	 *            starting index from where searching is being performed
	 * @param end
	 * @param element
	 *            which is searched
	 * @return
	 */
	public int searchBinary(int array[], int start, int end, int element) {
		if (start <= end) {
			int mid = start + (end - start) / 2;

			if (array[mid] == element) {
				return mid;  //element found
			}
			if (element > array[mid]) {
				return searchBinary(array, mid + 1, end, element);
			}
			if (element < array[mid]) {
				return searchBinary(array, start, mid - 1, element);
			}
		}
		return -1; //if no element is ever returned
	}

}
