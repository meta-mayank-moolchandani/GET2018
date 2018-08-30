package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDao;
import com.dao.Employee;

/**
 * Servlet implementation class AddEmployee
 */

public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"
				+ "");
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
	    String age = request.getParameter("age");
	    
	    PrintWriter out = response.getWriter();
		Employee employee = new Employee(firstName, lastName, email, Integer.parseInt(age));
		EmpDao empDao = new EmpDao();
		boolean isEmployeeAddedflag = empDao.insert(employee); 
		

		
		if (isEmployeeAddedflag) {
			out.println("<h2>Employee Successfully Added !!</h2>");
			
			RequestDispatcher requestdispatch = request
					.getRequestDispatcher("index.html");
            requestdispatch.include(request, response);
		}
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
