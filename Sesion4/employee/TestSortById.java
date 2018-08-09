package employee;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestSortById {

	@Test
	public void test() {
		Employee emp1 = new Employee("A", 232, "b", "c", 5);
		Employee emp2 = new Employee("B", 232, "b", "c", 7);
		Employee emp3 = new Employee("C", 232, "b", "c", 8);
		Employee emp4 = new Employee("D", 232, "b", "c", 2);
		Employee emp5 = new Employee("E", 232, "b", "c", 4);

		List<Employee> listOfEmployee = new ArrayList<Employee>();

		listOfEmployee.add(emp1);
		listOfEmployee.add(emp2);
		listOfEmployee.add(emp3);
		listOfEmployee.add(emp4);
		listOfEmployee.add(emp5);

		Collections.sort(listOfEmployee, new SortById());

		int arrayOfSortedId[] = new int[listOfEmployee.size()];
		int index = 0;
		for (Employee emp : listOfEmployee) {
			arrayOfSortedId[index] = emp.getId();
			index++;
		}
		int expectedResult[] = new int[] { 2, 4, 5, 7, 8 };
		assertArrayEquals("collection is sorting by the id of the employee",
				expectedResult, arrayOfSortedId);
	}

}
