package student;

import java.util.*;

public class inputValidation {


	static Scanner scan = new Scanner(System.in);

	/**
	 * check the valid input;
	 * 
	 * @return
	 */
	public static int isValidateMarks() {
		int flag, choice = 0;
		do {

			try {
				choice = scan.nextInt();

				if (choice <= 0 || choice >= 100) {
					throw new ArithmeticException(
							"Invalid Please enter a number from 0 to 100");
				}
				flag = 0;

			} catch (InputMismatchException e) {
				flag = 1;
				System.out.println("Please enter a valid input");
				scan.next();
			} catch (ArithmeticException e) {
				flag = 1;
				System.out.println(e.getMessage());
			} catch (Exception e) {
				flag = 1;
				System.out.println(e.getMessage());
			}
		} while (flag != 0);

		return choice;
	}
/**
 * check if a integer is valid or not	
 * @return
 */
	public static int isValidInteger() {
		int flag, choice = 0;
		do {

			try {
				choice = scan.nextInt();
				flag = 0;

			} catch (InputMismatchException e) {
				flag = 1;
				System.out.println("Please enter a valid input");
				scan.next();
			} 
		} while (flag != 0);

		return choice;
	}	

}