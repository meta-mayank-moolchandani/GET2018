package employee;

import java.util.Comparator;


class SortById implements Comparator<Employee>
{
	@Override
	public int compare(Employee employee1, Employee employee2) {
	   return employee1.getId()-employee2.getId();
	}
}

