package stringOperation;

import java.util.*;

public abstract class inputValidation {

//	HexCalc hexCal = new HexCalc();
	static Scanner scan = new Scanner(System.in);

	public static int isInt() {
		int flag, choice = 0;
		do {

			try {
				choice = scan.nextInt();

				if (choice <= 0 && choice >= 5) {
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