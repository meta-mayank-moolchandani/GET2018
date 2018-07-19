package fcfs;

import java.util.*;

public class inputValidation {

	static Scanner scan = new Scanner(System.in);

	/**
	 * function throws the exception for invalid inputs
	 * 
	 * @return valid input
	 */

	public static int isInt() {
		int flag, choice = 0;
		do {

			try {
				choice = scan.nextInt();

				if (choice <= 0) {
					throw new ArithmeticException(
							"Invalid Please enter a positive number ");
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

}