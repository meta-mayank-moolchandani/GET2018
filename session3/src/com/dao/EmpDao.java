package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.dao.connection.Connect;


public class EmpDao implements Dao<Employee>{
	
/**
 *for getting all the data of the employee 
 */
	
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

/**
 * insert the employee data in the database	
 */
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
					
					rowInserted = stmt.executeUpdate();
					
					
			}catch(Exception e){
				System.out.println("MESSAGE" + e.getLocalizedMessage());
		  }
			
		} catch (Exception e) {
			System.out.println("message"+ e.getMessage());
		}
		

		return rowInserted==1;
	}

/**
 * get the data of the employee whose firstName and lastName is given	
 */
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
	
/**
 * get the data of employee whose employee email is given	
 */
	public Employee get(String email){
		String query = "SELECT first_name, last_name, email, age FROM employee WHERE email = '"+ email + "'";
		Employee emp = null;
		try (Connection conn = Connect.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rset = pstmt.executeQuery();) {

			rset.next();
			String firstName = rset.getString("first_name");
				String lastName = rset.getString("last_name");
				int age = rset.getInt("age");
				Employee employee = new Employee(firstName, lastName, email,
						age);
				emp = employee;


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return emp;

	}
	
	/**
	 * updating the employee details 
	 */
	
	public boolean update(Employee emp){
		String query  = "UPDATE employee SET first_name =  ? , last_name = ? , email = ? , age = ? WHERE email = ? ;";
		boolean isEmployeeUpdateFalg = false;
		
		try(Connection conn = Connect.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);	
			){
			pstmt.setString(1,emp.getFirstName());
			pstmt.setString(2,emp.getLastName());
			pstmt.setString(3,emp.getEmail());
			pstmt.setInt(4,emp.getAge());

			pstmt.setString(5,emp.getEmail());

			isEmployeeUpdateFalg = pstmt.executeUpdate()==0?false:true;
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return isEmployeeUpdateFalg;
	}

}
