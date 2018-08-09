
import static org.junit.Assert.*;

import org.junit.Test;

import employee.Employee;

public class TestEmployeeCollectionDuplicateHandling {

	@Test
	public void testAdd1() {
		EmployeeCollectionDuplicateHandling newSetCollectionOfEmployee = new EmployeeCollectionDuplicateHandling();
		Employee emp1 = new Employee("A", 232, "b", "c", 5);
		assertEquals(true, newSetCollectionOfEmployee.addEmployee(emp1));
	}

	@Test
	public void testAdd2() {
		EmployeeCollectionDuplicateHandling newSetCollectionOfEmployee = new EmployeeCollectionDuplicateHandling();
		Employee emp1 = new Employee("A", 232, "b", "c", 5);
		Employee emp2 = new Employee("B", 232, "b", "c", 7);
		assertEquals(true, newSetCollectionOfEmployee.addEmployee(emp1));
		assertEquals(false, newSetCollectionOfEmployee.addEmployee(emp1));
		assertEquals(true, newSetCollectionOfEmployee.addEmployee(emp2));
	}

	@Test
	public void testAdd3() {
		EmployeeCollectionDuplicateHandling newSetCollectionOfEmployee = new EmployeeCollectionDuplicateHandling();
		Employee emp3 = new Employee("C", 232, "b", "c", 8);
		Employee emp4 = new Employee("D", 231, "M", "G", 8);
		assertEquals(true, newSetCollectionOfEmployee.addEmployee(emp3));
		assertEquals(false, newSetCollectionOfEmployee.addEmployee(emp4));

	}

}
