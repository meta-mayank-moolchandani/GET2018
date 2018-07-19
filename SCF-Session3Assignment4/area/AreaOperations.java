package area;


import stringOperation.inputValidation;

public class AreaOperations {
	
	public static void main(String args[]){
	int num1;
	int num2;

	while (true) {
		System.out.println("1: Triangle: ");
		System.out.println("2: Rectangle: ");
		System.out.println("3: Square: ");
		System.out.println("4: circle: ");
		System.out.println("5: exit: ");

		int choice = inputValidation.isInt();

		switch (choice) {
		case 1:
			System.out.println("Enter First Input: ");
			num1 = inputValidation.isInt();
			System.out.println("Enter Second Input: ");
			num2 = inputValidation.isInt();
			System.out.println("Area of Trinagle: "
					+ Area.areaOfTraiangle(num1, num2) + "\n");
			break;

		case 2:
			System.out.println("Enter First Input: ");
			num1 = inputValidation.isInt();
			System.out.println("Enter Second Input: ");
			num2 = inputValidation.isInt();
			System.out.println("Area of Rectangle: "
					+ Area.areaOfRectangle(num1, num2) + "\n");
			break;

		case 3:
			System.out.println("Enter Input: ");
			num1 = inputValidation.isInt();

			System.out.println("Area of Square: "
					+ Area.areaOfSquare(num1) + "\n");
			break;

		case 4:
			System.out.println("Enter Input: ");
			num1 = inputValidation.isInt();
			System.out.println("Area of circle:"
					+ Area.areaOfCircle(num1) + "\n");
			break;

		case 5:
			System.exit(1);
			break;
		
		default: System.out.println("Invalid Input");	

		}

	}

}	
}

