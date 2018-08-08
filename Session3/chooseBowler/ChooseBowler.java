package chooseBowler;

import java.util.List;
import java.util.ArrayList;

import priorityQueue.*;

public class ChooseBowler {
	private int numberOfBalls;
	List<Bowler> listOfBowlers;

	public ChooseBowler(int numberOfBalls, List<Bowler> listOfBowlers) {
		this.numberOfBalls = numberOfBalls;
		this.listOfBowlers = listOfBowlers;
	}
/**
 * checking validity of the function
 * @return
 */
	private boolean checkValidate() {
		boolean flag1 = false;
		boolean flag2 = true;
		int sumOfBalls = 0;
		for (Bowler bowler : listOfBowlers) {
			if (bowler.getQuota() < 0) {
				flag2 = false;
				break;
			}
			sumOfBalls += bowler.getQuota();
		}
		flag1 = sumOfBalls >= numberOfBalls ? true : false;

		return flag1 && flag2;
	}
/**
 * generating the bowling order according to their priority
 * @return
 */
	public List<Bowler> generateBowlingOrder() {
		if (checkValidate()) {
			PriorityQueue<Bowler> priorityQueue = new PriorityQueue<>(
					listOfBowlers.size());

			for (Bowler bowler : listOfBowlers) {
				Item<Bowler> item = new Item<Bowler>(bowler, bowler.getQuota());
				priorityQueue.enqueue(item);
			}

			List<Bowler> bowlingOrder = new ArrayList<Bowler>();
			while (numberOfBalls > 0) {
				Bowler bowler = priorityQueue.getHighestPriority().getItem();
				numberOfBalls -= bowler.getQuota();
				bowlingOrder.add(bowler);
				priorityQueue.deleteHighestPriority();
			}

			return bowlingOrder;
		} else {
			throw new RuntimeException("Input is not valid");
		}

	}

}
