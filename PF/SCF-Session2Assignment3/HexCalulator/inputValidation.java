package HexCalulator;

import java.util.*;

public class inputValidation {

	HexCalc hexCal = new HexCalc();
	static Scanner scan = new Scanner(System.in);

	/**
	 * function throws the exception for invalid inputs
	 * 
	 * @return valid input
	 */

	public static String isvalidHexa() {
		String choice = "";
		boolean flag = false;
		do {

			try {
				choice = scan.next();
				choice = choice.toUpperCase();

				if (!(HexCalc.isValidate(choice))) {
					throw new ArithmeticException(
							"Invalid Please enter a Hexa Decimal input ");
				}
				flag = false;

			} catch (ArithmeticException e) {
				flag = true;
				System.out.println(e.getMessage());
			} catch (Exception e) {
				flag = true;
				System.out.println(e.getMessage());
			}
		} while (flag);

		return choice;
	}

	/**
	 * check the valid input;
	 * 
	 * @return
	 */
	public static int isInt() {
		int flag, choice = 0;
		do {

			try {
				choice = scan.nextInt();

				if (choice <= 0 && choice >= 8) {
					throw new ArithmeticException(
							"Invalid Please enter a positive number from the choices");
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