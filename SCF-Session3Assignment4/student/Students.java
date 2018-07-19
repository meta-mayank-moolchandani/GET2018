package student;

public class Students {
	
	public int grades[];
	
	Students(int size){
		grades = new int[size];
	}

/**
 * calculates the sum of array	
 * @param arr
 * @return
 */
	public int sumOfGrades(int arr[]) {
		int sumOfArray = 0;

		for (int index = 0; index < arr.length; index++) {
			sumOfArray += arr[index];
		}
		return sumOfArray;
	}
	
/**
 * calculates the maximum number from array	
 * @param arr
 * @return
 */
	public int maxFromGrades(int arr[]) {
		int max = arr[0];

		for (int index = 1; index < arr.length; index++) {
			if(max<arr[index]){
				max=arr[index];
			}
		}
		return max;
	}

	/**
	 * calculates the minimum number from array	
	 * @param arr
	 * @return
	 */	
	public int minFromGrades(int arr[]) {
		int min = arr[0];

		for (int index = 1; index < arr.length; index++) {
			if(min>arr[index]){
				min=arr[index];
			}
		}
		return min;
	}

/**
 * calculate the number of passed students	
 * @param arr
 * @return
 */
	public float passedStudentsPercentage(int arr[]) {
		float totalStudents = arr.length;
		float sumOfPassed = 0;
		for (int index = 1; index < arr.length; index++) {
			if(arr[index]>=40){
				sumOfPassed++;
			}
		}
		float passedStudentsPercentage = (float)(sumOfPassed/totalStudents)*100;
		return passedStudentsPercentage;
	}	
	
	public static void main(String args[]) {
		int num;
		System.out.println("Enter the number of students: ");
		num = inputValidation.isValidInteger();
		Students students  = new Students(num); 
		
		for(int i =0;i<num;i++){
			System.out.println("Enter the marks of student(" + (i+1) +"): ");
			students.grades[i]=inputValidation.isValidateMarks();
		}
		
		System.out.println("average marks: " + students.sumOfGrades(students.grades)/num );
		System.out.println("maximum marks: " + students.maxFromGrades(students.grades) );
		System.out.println("minimum marks: " + students.minFromGrades(students.grades) );
		System.out.println("passed percentage passed students : " + students.passedStudentsPercentage(students.grades) ) ;

	}
}
