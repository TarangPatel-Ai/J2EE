package com.caltech.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caltech.dao.StudentDAO;
import com.caltech.pojo.Student;

/**
 * Servlet implementation class InsertStudent
 */
@WebServlet("/InsertStudent")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		student.setSid(Integer.parseInt(request.getParameter("id")));
		student.setSname(request.getParameter("name"));
		student.setSemail(request.getParameter("email"));
		
		StudentDAO dao = new StudentDAO();
		try {
			if(dao.insertStudentintodb(student)>0) {
				response.sendRedirect("display.html");
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
