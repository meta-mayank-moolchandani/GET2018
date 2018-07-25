package sets;

import java.util.Arrays;


public final class Sets {
	private final int set[];
	private final int MAX = 1000;
	private final int MIN = 1;

	public int[] getSet() {
		int arr[] = new int[set.length];
		for(int i =0; i<arr.length;i++){
			arr[i]=set[i];
		}
		return arr;
	}

	Sets(int set[]) {
		this.set = set;
		if (!isValidSet()) {
			throw new AssertionError("Set is not valid");
		}
	}

	/**
	 * check if element x is a member of the set or not
	 * 
	 * @param element
	 * @return true if element is member of set else false
	 */
	public boolean isMemeber(int element) {
		return isExist(element, -1,set) ? true : false; // in is exist is iterating
													// from start+1
	}

	/**
	 * function check that if set is valid or not. the set which is consisting
	 * duplicate elements is invalid. the set which is not consisting the
	 * integers MIN to MAX is invalid.
	 * 
	 * @return true if set is valid
	 */
	private boolean isValidSet() {
		boolean flag = true;
		for (int index = 0; index < set.length; index++) {
			if (set[index] < MIN || set[index] > MAX) {
				flag = false;
				break;
			}
			if (isExist(set[index], index,set)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * function returns the size of the set
	 * 
	 * @return
	 */
	public int size() {
		return set.length;
	}

	/**
	 * functions check that current set is the subset of set 2 or not
	 * 
	 * @param set2
	 * @return
	 */
	public boolean isSubset(Sets set2) {
		boolean flag = true;

		if (this.size() < set2.size()) {
			for (int i = 0; i < this.size(); i++) {
				if (!set2.isMemeber(this.set[i])) {
					flag = false; // if set[i] is not a member of set2
					break;
				}
			}
		} else {
			flag = false; // if size of first set is greater
		}
		return flag;
	}

	/**
	 * function returns the compliment of the set (sets which is consisting the
	 * other elements than existed elements)
	 * 
	 * @return new object of the set
	 */
	public Sets getCompliment() {
		System.out.println(isMemeber(1));
		int complimentSet[] = new int[MAX - this.size()];
		int Cindex = 0; // index of complimentSet
		for (int i = MIN; i <= MAX; i++) {
			if (!isMemeber(i)) {
				complimentSet[Cindex] = i;
				Cindex++;
			}
		}
		Sets newSet = new Sets(complimentSet);
		return newSet;
	}
	
/**
 * returns the union of two sets	
 * @param set2
 * @return new set object having the union set
 */
	public Sets union(Sets set2) {
		int[] arraySet1 = this.getSet();
		int[] arraySet2 = set2.getSet();

		int[] smallArraySet = arraySet1.length <= arraySet2.length ? arraySet1
				: arraySet2;
		int[] largeArraySet = arraySet1.length >= arraySet2.length ? arraySet1
				: arraySet2;
		
		int count = 0; //for evaluating the size of union

		for (int i = 0; i < smallArraySet.length; i++) { // i is index
			if (isExist(smallArraySet[i], -1, largeArraySet)) {
				count++;
			}
		}

		int sizeOfUnion = smallArraySet.length + largeArraySet.length - count;

		int[] unionSet = new int[sizeOfUnion];

		int unionIndex;
		for (unionIndex = 0; unionIndex < smallArraySet.length; unionIndex++) {
			unionSet[unionIndex] = smallArraySet[unionIndex];
		}

		for (int largeIndex = 0; largeIndex < largeArraySet.length; largeIndex++) {
			if (!isExist(largeArraySet[largeIndex], -1, unionSet)) {
				unionSet[unionIndex] = largeArraySet[largeIndex];
				unionIndex++;

			}
		}
		
        Arrays.sort(unionSet);
		return new Sets(unionSet);
	}

	/**
	 * function checks if element exist in set from index start to the end
	 * 
	 * @param element
	 * @param start
	 *            starting index
	 * @return true if element exists in set
	 */
	private boolean isExist(int element, int start, int array[]) {
		boolean flag = false;
		for (int i = start + 1; i < array.length; i++) {
			if (array[i] == element) {
				flag = true; // element found
				break;
			}
		}
		return flag;
	}

	
/**
 * getting the union of two arrays in reverse sorted order with time complexity n 	
 *//*
	private int[] getUnion(int array1[], int array2[]) {
		int array1Index = 0;
		int array2Index = 0;
		int unionIndex = 0;
		int union[] = new int[array1.length + array2.length];
		while (array1Index < array1.length && array2Index < array2.length) {
			if (array1[array1Index] < array2[array2Index]) {
				union[unionIndex] = array2[array2Index];
				array2Index++;
			} else if (array1[array1Index] > array2[array2Index]) {
				union[unionIndex] = array1[array1Index];
				array1Index++;
			} else {
				union[unionIndex] = array1[array1Index];
				array1Index++;
				array2Index++;
			}
			unionIndex++;
		}

		while (array1Index < array1.length) {
			union[unionIndex] = array1[array1Index];
			array1Index++;
			unionIndex++;
		}
		while (array2Index < array2.length) {
			union[unionIndex] = array2[array2Index];
			array2Index++;
			unionIndex++;
		}

		int finalUnion[] = new int[unionIndex]; // for deleting extra elements

		for (int m = 0; m < finalUnion.length; m++) {
			finalUnion[m] = union[m];
		}
		return finalUnion;
	}
*/
}
