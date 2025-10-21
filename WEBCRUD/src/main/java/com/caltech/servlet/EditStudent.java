package com.caltech.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caltech.dao.StudentDAO;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id"); 
		StudentDAO dao=new StudentDAO(); 
		PrintWriter pw=response.getWriter(); 
		pw.print("<html><body><form action='EditController'>" 
		+ "<input type='hidden' name='id' value="+id+">" 
		+ "Enter the student name to be updated <input type='text' name='name'> " 
		+ "Enter the student email to be updated <input type='text' name='email'> "
		+ "<input type='submit' value='update'></form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
