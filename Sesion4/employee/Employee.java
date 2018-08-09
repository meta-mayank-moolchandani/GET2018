package employee;

import java.util.Objects;

public class Employee {
	private String name;
	private int id;
	private Address address;

	public Employee(String name, int houseNo, String locality, String city,
			int id) {
		this.name = name;
		this.address = new Address(houseNo, locality, city);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Employee) {
			boolean isEqualFlag = false;
			if (this.id == ((Employee) o).getId()) {
				isEqualFlag = true;
				System.out.print(isEqualFlag);
			}
			return isEqualFlag;
		} else {
			return false;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(name, address, id);
	}
}
