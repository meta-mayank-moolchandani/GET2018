package fcfs;

public class JobScheduler {

	public final int COL_SIZE = 3;

	/**
	 * function returns the sorted 2d array according to the column 1
	 * 
	 * @param arr
	 * @return sorted array
	 */

	public int[][] sort(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i][1] > arr[j][1]) {
					int temp = arr[i][1];
					int temp2 = arr[i][0];
					int temp3 = arr[i][2];
					arr[i][1] = arr[j][1];
					arr[i][0] = arr[j][0];
					arr[i][2] = arr[j][2];
					arr[j][1] = temp;
					arr[j][0] = temp2;
					arr[j][2] = temp3;
				}
			}
		}
		return arr;
	}

	/**
	 * for calculating completion time
	 * 
	 * @param inArray
	 *            is inputArray
	 * @param compTime
	 *            is completion time
	 * @return array ofcalculated completion time
	 */
	public int[] calculateCompletionTime(int inArray[][], int compTime[]) {
		compTime[0] = inArray[0][COL_SIZE - 2] + inArray[0][COL_SIZE - 1];
		for (int i = 1; i < inArray.length; i++) {
			if (compTime[i - 1] > inArray[i][COL_SIZE - 2]) {
				compTime[i] = compTime[i - 1] + inArray[i][COL_SIZE - 1];
			} else {
				compTime[i] = inArray[i][COL_SIZE - 2]
						+ inArray[i][COL_SIZE - 1];
			}
		}

		return compTime;
	}

	/**
	 * function calculates the turn around time
	 * 
	 * @param inArray
	 * @param turnAroundTime
	 * @param completionTime
	 * @return completionTime - Arrival Time
	 */
	public int[] calculateTurnAroundTime(int inArray[][], int turnAroundTime[],
			int completionTime[]) {

		for (int i = 0; i < inArray.length; i++) {
			turnAroundTime[i] = completionTime[i] - inArray[i][COL_SIZE - 2];
		}
		return turnAroundTime;
	}

	// turn-burst

	/**
	 * function calculates the waiting time
	 * 
	 * @param inArray
	 * @param waitTime
	 * @param turnAroundTime
	 * @return turnaround time - burst time
	 */
	public int[] calculateWaitTime(int inArray[][], int waitTime[],
			int turnAroundTime[]) {

		for (int i = 0; i < inArray.length; i++) {
			waitTime[i] = turnAroundTime[i] - inArray[i][COL_SIZE - 1];
		}
		return waitTime;
	}

	/**
	 * for calculate average of an array
	 * 
	 * @param passedArray
	 * @return average value
	 */
	public float calculateAvg(int passedArray[]) {
		float sum = 0;
		for (int i = 0; i < passedArray.length; i++) {
			sum = sum + passedArray[i];
		}
		return (sum / (float) passedArray.length);
	}

	/**
	 * calculate maximum element from array
	 * 
	 * @param passedArray
	 * @return max element
	 */
	public int calculateMax(int passedArray[]) {
		int max = 0;
		for (int i = 0; i < passedArray.length; i++) {
			if (passedArray[i] > max) {
				max = passedArray[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {

		JobScheduler jobSch = new JobScheduler();
		// final int COL_SIZE = 3;

		System.out.println("Enter Number Of Processes: ");
		int size = inputValidation.isInt();

		int inputArray[][] = new int[size][3];

		for (int index = 0; index < size; index++) {
			inputArray[index][jobSch.COL_SIZE - 3] = index + 1;

			System.out.println("Enter Arrival time of process " + (index + 1)
					+ ": ");
			inputArray[index][jobSch.COL_SIZE - 2] = inputValidation.isInt();

			System.out.println("Enter Burst time of process " + (index + 1)
					+ ": ");
			inputArray[index][jobSch.COL_SIZE - 1] = inputValidation.isInt();

		}

		System.out.println("YOU HAVE ENTERED: \n\n");
		System.out.println();
		inputArray = jobSch.sort(inputArray);

		int compTime[] = new int[size];
		int turnTime[] = new int[size];
		int waitTime[] = new int[size];
		compTime = jobSch.calculateCompletionTime(inputArray, compTime);
		turnTime = jobSch.calculateTurnAroundTime(inputArray, turnTime,
				compTime);
		waitTime = jobSch.calculateWaitTime(inputArray, waitTime, turnTime);

		for (int i = 0; i < size; i++) {

			System.out.println("P" + inputArray[i][jobSch.COL_SIZE - 3] + "\t"
					+ inputArray[i][jobSch.COL_SIZE - 2] + "(AT)\t"
					+ inputArray[i][jobSch.COL_SIZE - 1] + "(BT)\t"
					+ compTime[i] + "(CT)\t" + turnTime[i] + "(TT)\t"
					+ waitTime[i] + "(WT)");

		}

		System.out.println("\nMaximum waiting time="
				+ jobSch.calculateMax(waitTime));
		System.out.println("Average waiting time="
				+ jobSch.calculateAvg(waitTime));

	}
}
