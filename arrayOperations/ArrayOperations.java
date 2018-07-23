package arrayOperations;

import java.util.*;

/**
 * class ArrayOperations is for performing following operations on arrays: 1.
 * getting the clumps 2. getting the index which splits the equivalent sum at
 * the both sides of array 3. getting the largest size of mirror 4. getting the
 * fix array of fix_xy problem
 * 
 * @author mayankk
 *
 */
public class ArrayOperations {
	// all operations are performed on this array
	private int array[];

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	/**
	 * Return the index if there is a place to split the input array so that the
	 * sum of the numbers on one side is equal to the sum of the numbers on the
	 * other side else return -1. For ex
	 * 
	 * splitArray([1, 1, 1, 2, 1]) → 3 , splitArray([2, 1, 1, 2, 1]) → -1 ,
	 * splitArray([10, 10]) → 1
	 * 
	 * Throw assertion error in case array is empty.
	 * 
	 * @return the index where array is splitting according to the description.
	 */

	public int splitArray() {
		if (array.length == 0 || areAllZero()) { // areallZero returns true if
													// all elements of array are
													// 0
			throw new AssertionError(
					"ASSERTION ERROR: ARRAY CAN NOT EMPTY OR ALL ELEMENTS CAN'T BE ZERO ");
		}

		int index;
		for (index = 0; index < array.length - 1; index++) {
			int leftSum = 0;
			int rightSum = 0;
			for (int leftIndex = 0; leftIndex <= index; leftIndex++) {
				leftSum += array[leftIndex]; // calculating the sum from 0 to
												// index
			}
			for (int rightIndex = index + 1; rightIndex < array.length; rightIndex++) {
				rightSum += array[rightIndex]; // calculating sum from the index
												// to the end
			}
			if (leftSum == rightSum) {
				break; // if both side's sums are equal
			}
		}
		return (index == (array.length - 1) ? -1 : index + 1); // -1 if no such
																// index exist
	}

	/**
	 * @return true if all elements of an array are zero
	 */

	public boolean areAllZero() {
		boolean flag = true;
		for (int index = 0; index < array.length; index++) {
			if (array[index] != 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * function calculates the number of clumps. Clump in an array is a series
	 * of 2 or more adjacent elements of the same value. For example
	 * 
	 * countClumps([1, 2, 2, 3, 4, 4]) → 2 countClumps([1, 1, 2, 1, 1]) → 2
	 * countClumps([1, 1, 1, 1, 1]) → 1
	 * 
	 * Throw assertion error in case array is empty.
	 * 
	 * @return number of clumps
	 */

	public int getClumps() {
		if (array.length == 0) {
			throw new AssertionError(
					"ASSERTION ERROR: ARRAY CAN NOT EMPTY OR ALL ELEMENTS CAN'T BE ZERO ");
		}
		if (array.length == 1) {
			return -1; // only one element can not make a clump
		}
		int clumps = 0;
		for (int index = 0; index < array.length; index++) {
			int count = 0;
			while (true) {
				if (index < array.length - 1 // array should not be out of bound
						&& array[index] == array[index + 1]) {
					count++; // similar element is found
					index++;
				} else {
					break; // if two consecutive elements are different
				}
			}
			if (count > 0) {
				clumps++;
			}
		}
		return clumps > 0 ? clumps : -1; // -1 if no clumps exist;
	}

	/**
	 * Function returns an array that contains exactly the same numbers as the
	 * input array, but rearranged so that every X is immediately followed by a
	 * Y. Do not move X within array, but every other number may move. For ex:
	 * 
	 * Let’s say value of X is 4 and Y is 5. Then
	 * 
	 * fixXY([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9] fixXY([1, 4, 1, 5]) → [1,
	 * 4, 5, 1] fixXY([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
	 * 
	 * Throwing an assertion in following cases : - If array is empty - If there
	 * are unequal numbers of X and Y in input array. - If two adjacents X
	 * values are there. - If X occurs at the last index of array.
	 * 
	 * @param x
	 *            is the element x of array
	 * @param y
	 *            is the element y of array
	 * @return the fixed array of fix_xy problem
	 */
	public int[] getFix_xyArray(int x, int y) {
		if (checkFix_XY(x, y)) { // checking all assertion errors conditions

			for (int index = 0; index < array.length; index++) {
				int indexOfX = indexOfX(x, index, array.length); // returns the
																	// index of
																	// x
				int indexOfY = indexOfY(x, y);// returns the first index of y
												// which is not at the next
												// right to the x
				if (indexOfY < 0) {
					break; // if all y are arranged
				}
				int temp = array[indexOfX + 1]; // swapping the next element to
												// the x with the index of y
				array[indexOfX + 1] = array[indexOfY];
				array[indexOfY] = temp;
				index = indexOfX + 1;
			}
			return array;
		} else {
			throw new AssertionError(
					"ERROR: CANT BE FIXED BY THE FIX_XY PROBLRM");
		}
	}

	/**
	 * 
	 * @param x
	 *            element x of fix_xy problem
	 * @param y
	 *            element y of fix_xy problem
	 * @return true if equal number of x and y are there in array, x does not
	 *         occurs at last index of array, two x are not adjacent in
	 *         array,array size is not zero,if there is equal number of x and y
	 *         else returns false.
	 */
	public boolean checkFix_XY(int x, int y) {
		if (checkEqualityOf(x, y) && checkAdjacentsX(x) && checkSize()
				&& lastOccurrence(x)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param x
	 *            element x of fix_xy problem
	 * @param y
	 *            element y of fix_xy problem
	 * @return true if there is equal number of x and y else false
	 */
	public boolean checkEqualityOf(int x, int y) {
		int xCount = 0;
		int yCount = 0;
		for (int index = 0; index < array.length; index++) {
			if (array[index] == x) {
				xCount++;
			}
		}
		for (int index = 0; index < array.length; index++) {
			if (array[index] == y) {
				yCount++;
			}
		}
		if (xCount == yCount) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param x
	 * @return true if two x are not adjacent in array else false
	 */
	public boolean checkAdjacentsX(int x) {
		boolean flag = true;
		for (int index = 0; index < array.length - 1; index++) {
			if (array[index] == x) {
				if (array[index] == array[index + 1]) {
					flag = false;
				}
			}
		}
		return flag;
	}

	/**
	 * 
	 * @return true if size of an array is not zero
	 */
	public boolean checkSize() {
		if (array.length == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param x
	 * @return true if x does not occur at last position of an array
	 */
	public boolean lastOccurrence(int x) {
		if (array[array.length - 1] == x) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * returns the index of the element which occurs from start to end
	 * 
	 * @param element
	 * @param start
	 *            starting position
	 * @param end
	 *            end position
	 * @return the index of the element which occurs from start to end
	 */
	public int indexOfX(int element, int start, int end) {
		int index;
		for (index = start; index < end; index++) {
			if (array[index] == element) {
				break;
			}
		}
		return index;
	}

	/**
	 * returns the only index of which does not occurs at the next right to the
	 * x eg:{1,2,3,4,5,6,5} if x is 4 and y is 5 function will return the index
	 * 6 as an index of y
	 *
	 * @param x
	 * @param y
	 * @return the index of y
	 */
	public int indexOfY(int x, int y) {
		if (array[0] == y) {
			return 0; // if y occurs at start
		}
		int index;
		for (index = 1; index < array.length; index++) {
			if (array[index] == y && array[index - 1] != x) {
				break;
			}
		}
		return index;
	}

	/**
	 * Return the size of the largest mirror section found in the input array.
	 * 
	 * Mirror section in an array is a group of contiguous elements such that
	 * somewhere in the array, the same group appears in reverse order. For
	 * example
	 * 
	 * maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3 maxMirror([7, 1, 4, 9, 7, 4, 1])
	 * → 2 maxMirror([1, 2, 1, 4]) → 3 maxMirror*([1, 4, 5, 3, 5, 4, 1]) → 7
	 * 
	 * Throw assertion error in case array is empty.
	 * 
	 * @return the size of largest mirror
	 */

	public int getMirrorSize() {
		if (array.length == 0) {
			throw new AssertionError("ERROR:ARRAY SIZE IS ZERO");
		}
		if (checkInReverse(array, array)) {
			return array.length; // returning length if array is palindrome
		}
		int maximumMirrorCount = 1; //
		for (int index = 0; index < (array.length) - 1; index++) {
			int mirrorCount = 1;
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(array[index]);
			arr.add(array[index + 1]);
			while (true) {
				int listArray[] = arrayListToarray(arr);
				if (checkInReverse(listArray, array) // true if listArray is
														// present in reverse of
														// array
						&& index != array.length - 2) {
					arr.add(array[index + 2]);
					index++;
					mirrorCount++;
				} else {
					break;
				}
			}
			if (maximumMirrorCount < mirrorCount) {
				maximumMirrorCount = mirrorCount;
			}
		}
		return maximumMirrorCount;
	}

	/**
	 * converts Integer arrayList to int array
	 * 
	 * @param list
	 * @return list of int
	 */
	public int[] arrayListToarray(ArrayList<Integer> list) {
		int[] resultList = new int[list.size()];

		for (int index = 0; index < list.size(); index++) {
			resultList[index] = list.get(index);
		}
		return resultList;
	}

	/**
	 * check if innerArray exists in the reverse outer array or not
	 * 
	 * @param innerArray
	 * @param outerArray
	 * @return true if exists
	 */
	public boolean checkInReverse(int innerArray[], int outerArray[]) {
		String inner = "";
		String outer = "";

		for (int index = 0; index < innerArray.length; index++) {
			inner = inner + innerArray[index];
		}

		for (int index = outerArray.length - 1; index >= 0; index--) {
			outer = outer + outerArray[index];
		}
		if (outer.indexOf(inner) >= 0) {
			return true;
		} else {
			return false;
		}

	}
}
