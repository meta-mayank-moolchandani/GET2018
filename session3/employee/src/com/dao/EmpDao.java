package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.dao.connection.Connect;


public class EmpDao implements Dao<Employee>{

	@Override
	public List<Employee> getAll() {
		String query = "SELECT first_name, last_name, email, age FROM employee;";
		List<Employee> listOfEmployee = new ArrayList<Employee>();
		try (Connection conn = Connect.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);) {
			ResultSet rset = pstmt.executeQuery();

			while (rset.next()) {
				String firstName = rset.getString("first_name");
				String lastName = rset.getString("last_name");
				String email = rset.getString("email");
				int age = rset.getInt("age");

				Employee employee = new Employee(firstName, lastName, email,
						age);

				listOfEmployee.add(employee);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listOfEmployee;
	}

	@Override
	public boolean insert(Employee employee) {
		String query = "INSERT INTO employee(first_name,last_name,email,age)VALUES(?,?,?,?);";
		int rowInserted = 0;
		try (Connection conn = Connect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);) {
			
			try{
					stmt.setString(1,employee.getFirstName());
					stmt.setString(2, employee.getLastName());
					stmt.setString(3, employee.getEmail());
					stmt.setInt(4, employee.getAge());
			}catch(Exception e){
				System.out.println(e.getLocalizedMessage());
				conn.rollback();
		  }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		return rowInserted==1;
	}

	@Override
	public List<Employee> get(String firstName, String lastName) {

		String query = "SELECT first_name, last_name, email, age FROM employee WHERE first_name = '"
				+ firstName + "' AND " + "last_name = '" + lastName + "';";
		List<Employee> listOfEmployee = new ArrayList<Employee>();

		try (Connection conn = Connect.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();) {
			while (rset.next()) {
				String email = rset.getString("email");
				int age = rset.getInt("age");
				Employee employee = new Employee(firstName, lastName, email,
						age);
				listOfEmployee.add(employee);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return listOfEmployee;
	}

}
