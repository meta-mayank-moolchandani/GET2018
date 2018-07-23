package lcmHcf;
public class LCM {
	private int firstNum;
	private int secondNum;
	private static int factor;

	LCM(int firstNum, int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		factor = firstNum >= secondNum ? firstNum : secondNum;
	}
/**
 * calculates the lcm of two numbers
 * @return
 */
	
	int calculateLcm() {
		if(firstNum==0 || secondNum==0){
			throw new ArithmeticException("numbers can not be zero ");
		}
		
		if (factor % firstNum == 0 && factor % secondNum == 0) {
			return factor;
		}
		factor++;
		return calculateLcm();
	}
}
