package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.dao.EmpDao;
import com.dao.Employee;

/**
 * Servlet implementation class UpdateDataOfEmployee
 */

public class UpdateDataOfEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDataOfEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("called");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<body><html>");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");

		Dao<Employee> empdao = new EmpDao();

		boolean isDataUpdate = empdao.update(new Employee(firstName, lastName,
				email, age));
		String message = isDataUpdate ? "Data Has Been Update"
				: "Data is Not Updated";

		out.println("<h1 align = 'center'>" + message + "</h1>");

		out.println("<a href = 'index.html'>Home</a>");

		out.println("</body></hrml>");
		System.out.println("data has been updtaed: " + isDataUpdate);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
