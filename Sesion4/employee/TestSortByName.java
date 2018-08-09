package employee;

import static org.junit.Assert.*;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestSortByName {

	@Test
	public void test() {
		Employee emp1 = new Employee("GH", 232, "b", "c", 5);
		Employee emp2 = new Employee("B", 232, "b", "c", 7);
		Employee emp3 = new Employee("AB", 232, "b", "c", 8);
		Employee emp4 = new Employee("BH", 232, "b", "c", 2);
		Employee emp5 = new Employee("AA", 232, "b", "c", 4);

		List<Employee> listOfEmployee = new ArrayList<Employee>();

		listOfEmployee.add(emp1);
		listOfEmployee.add(emp2);
		listOfEmployee.add(emp3);
		listOfEmployee.add(emp4);
		listOfEmployee.add(emp5);

		Collections.sort(listOfEmployee, new SortByName());

		String arrayOfSortedName[] = new String[listOfEmployee.size()];
		int index = 0;
		for (Employee emp : listOfEmployee) {
			arrayOfSortedName[index] = emp.getName();
			index++;
		}
		String expectedResult[] = new String[] { "AA", "AB", "B", "BH", "GH" };
		assertArrayEquals("collection is sorting by the id of the employee",
				expectedResult, arrayOfSortedName);
	}
	
	@Test
	public void test2() {
		Employee emp1 = new Employee("A", 232, "b", "c", 5);
		Employee emp2 = new Employee("AA", 232, "b", "c", 7);
		Employee emp3 = new Employee("AA", 232, "b", "c", 8);
		Employee emp4 = new Employee("BB", 232, "b", "c", 2);
		Employee emp5 = new Employee("BB", 232, "b", "c", 4);

		List<Employee> listOfEmployee = new ArrayList<Employee>();

		listOfEmployee.add(emp1);
		listOfEmployee.add(emp2);
		listOfEmployee.add(emp3);
		listOfEmployee.add(emp4);
		listOfEmployee.add(emp5);

		Collections.sort(listOfEmployee, new SortByName());

		String arrayOfSortedName[] = new String[listOfEmployee.size()];
		int index = 0;
		for (Employee emp : listOfEmployee) {
			arrayOfSortedName[index] = emp.getName();
			index++;
		}
		String expectedResult[] = new String[] { "A", "AA", "AA", "BB", "BB" };
		assertArrayEquals("collection is sorting by the name of the employee",
				expectedResult, arrayOfSortedName);
	}


}
