package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDao;
import com.dao.Employee;

/**
 * Servlet implementation class SearchEmployee
 */

public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");

		EmpDao empDao = new EmpDao();
		List<Employee> listOfEmployee = empDao.get(firstName, lastName);

		out.println("<table border = 'solid' align = 'center'><th>Name</th><th>Email</th><th>Age</th>");

		for (Employee emp : listOfEmployee) {
			out.println("<tr><td>" + emp.getFirstName() + emp.getLastName()
					+ "</td><td>" + emp.getEmail() + "</td><td>" + emp.getAge()
					+ "</td></tr>");
		}

		out.println("</table>");
		out.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
