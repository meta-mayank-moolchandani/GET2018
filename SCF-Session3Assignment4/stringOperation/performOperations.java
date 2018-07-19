package stringOperation;

import java.util.*;

public class performOperations {
	static Scanner scan = new Scanner(System.in);

	public static void main(String args[]) {
		String input1;
		String input2;

		while (true) {
			System.out.println("1: compare: ");
			System.out.println("2: reverse: ");
			System.out.println("3: inverse case: ");
			System.out.println("4: longest word: ");
			System.out.println("5: exit: ");

			int choice = inputValidation.isInt();

			switch (choice) {
			case 1:
				System.out.println("Enter First Input: ");
				input1 = scan.nextLine();
				System.out.println("Enter Second Input: ");
				input2 = scan.nextLine();
				System.out.println("comparison result:"
						+ StringOperations.compare(input1, input2) + "\n");
				break;

			case 2:
				System.out.println("Enter Input: ");
				input1 = scan.nextLine();
				System.out.println("reverse result:"
						+ StringOperations.reverse(input1) + "\n");
				break;

			case 3:
				System.out.println("Enter Input: ");
				input1 = scan.nextLine();
				System.out.println("Inverse result:"
						+ StringOperations.inverseCase(input1) + "\n");
				break;

			case 4:
				System.out.println("Enter Input: ");
				input1 = scan.nextLine();
				System.out.println("Longest word:"
						+ StringOperations.longestWord(input1) + "\n");
				break;

			case 5:
				System.exit(1);
				break;

			}

		}

	}
}
