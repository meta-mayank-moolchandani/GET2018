package lcmHcf;

public class HCF {
	/**
	 * function calculates the hcf
	 * 
	 * @return
	 */

	public int hcf(int number1, int number2) {
		
		if(number1==0 || number2==0){
			throw new ArithmeticException("numbers can not be zero ");
		}
		if (number1 == number2) {
			return number1;
		}
		if (number1 > number2) {
			return hcf(number1 - number2, number2);
		}
		if (number2 > number1) {
			return hcf(number1, number2 - number1);
		}
		return 0;
	}

}
