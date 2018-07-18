package HexCalulator;

import java.util.*;

public class HexaDecimal {
	public static void main(String a[]) {
		Scanner sc = new Scanner(System.in);
		HexCalc ob = new HexCalc();

		String hexa1 = sc.next().trim();

		hexa1 = hexa1.toUpperCase();
		String hexa2 = sc.next().trim();
		hexa2 = hexa2.toLowerCase();
		if (!ob.isValidate(hexa1)) {
			System.out.println("invalid hexadecimal number");
		}

		if (!ob.isValidate(hexa1)) {
			System.out.println("invalid hexadecimal number");
		}

		while (true) {
			int choice;

			System.out.println("1: ADD ");
			System.out.println("2: SUBTRACT ");
			System.out.println("3: MULTIPLY ");
			System.out.println("4: DIVIDE ");
			System.out.println("5: COMPARE ");
			System.out.println("6: HEXA DECIMAL TO DECIMAL ");
			System.out.println("7: DECIMAL TO HEXADECIMAL ");
			System.out.println("8: exit");

			System.out.println("\nEnter Your Choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println(ob.addHexa(hexa1, hexa2));
				break;

			case 2:
				System.out.println(ob.subtractHexa(hexa1, hexa2));
				break;

			case 3:
				System.out.println(ob.multiplyHexa(hexa1, hexa2));
				break;

			case 4:
				System.out.println(ob.divideHexa(hexa1, hexa2));
				break;

			case 5:
				System.out.println("first number is greater than second: ?"
						+ ob.greaterThan(hexa1, hexa2));
				System.out.println("first number is smaller than second: ?"
						+ ob.lessThan(hexa1, hexa2));
				System.out.println("first number is equal to second: ?"
						+ hexa1.equals(hexa2));
				break;

			case 6:
				System.out.println(ob.hexadecimalToDEcimal(hexa1));
				System.out.println(ob.hexadecimalToDEcimal(hexa2));
				break;

			case 7:
				System.out.println("enter numbers: ");
				int num1,
				num2;
				num1 = sc.nextInt();
				System.out.println(ob.decimalToHexaDecimal(num1 + ""));
				// System.out.println(ob.decimalToHexaDecimal(hexa1));
				break;

			case 8:
				System.exit(1);
				break;

			}
		}

	}
}
