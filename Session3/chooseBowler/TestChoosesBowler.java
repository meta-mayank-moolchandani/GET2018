package chooseBowler;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestChoosesBowler {
	private List<Bowler> list = new ArrayList<Bowler>();

	@Before
	public void initalize() {
		Bowler bowler1 = new Bowler("A", 40);
		Bowler bowler2 = new Bowler("B", 30);
		Bowler bowler3 = new Bowler("C", 13);
		Bowler bowler4 = new Bowler("D", 7);
		Bowler bowler5 = new Bowler("E", 2);
		Bowler bowler6 = new Bowler("F", 10);
		Bowler bowler7 = new Bowler("G", 1);

		list.add(bowler1);
		list.add(bowler2);
		list.add(bowler3);
		list.add(bowler4);
		list.add(bowler5);
		list.add(bowler6);
		list.add(bowler7);

	}

	@Test
	public void testGenerateBowlingOrder() {

		ChooseBowler chooseBowler = new ChooseBowler(25, list);

		List<Bowler> resultList = chooseBowler.generateBowlingOrder();
		String resultArray[] = new String[resultList.size()];
		int index = 0;
		for (Bowler bowler : resultList) {
			resultArray[index] = bowler.getName();
			index++;
		}
		String[] expectedOutput = new String[] { "G", "E", "D", "F", "C" };
		assertArrayEquals("bowler will bowl according to there priority",
				expectedOutput, resultArray);

	}

	@Test
	public void test2GenerateBowlingOrder() {
		String message = "";
		try {
			ChooseBowler chooseBowler = new ChooseBowler(250, list);
			chooseBowler.generateBowlingOrder();
		} catch (Exception e) {
			message = e.getMessage();
		}
		assertEquals("all bowlers combined can not 250 balls at a time",
				"Input is not valid", message);
	}

}
