package employee;

import java.util.Comparator;


class SortByName implements Comparator<Employee>
{
	@Override
	public int compare(Employee employee1, Employee employee2) {
	   return employee1.getName().compareTo(employee2.getName());
	}
}

