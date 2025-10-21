package com.caltech.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caltech.dao.StudentDAO;
import com.caltech.pojo.Student;

/**
 * Servlet implementation class ReadStudent
 */
@WebServlet("/ReadStudent")
public class ReadStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAO dao = new StudentDAO();
		PrintWriter pw = response.getWriter();
		try {
			List<Student> list = dao.retreiveStudentData();
			pw.print("<html>"
					+ "<body>"
					+ "<center>"
					+ "<h1>List of Student Information</h1>"
					+ "<table border='1' align='center'>"
					+ "<tr>"
					+ "	<th>Student Id</th>"
					+ "	<th>Student Name</th>"
					+ "	<th>Student Email</th>"
					+ "	<th>Edit</th>"
					+ "	<th>Delete</th>"
					+ "</tr>" );
					
					for(Student student:list) {
					pw.print("<tr>"
					+ "	<td>"+student.getSid()+"</td>"
					+ "	<td>"+student.getSname()+"</td>"
					+ "	<td>"+student.getSemail()+"</td>"
					+ "	<td><a href='./EditStudent?id="+student.getSid()+"'>Edit</a></td>"
					+ "	<td><a href='./DeleteStudent?id="+student.getSid()+"'>Delete</a></td>"
					+ "</tr>");
					}
					pw.print("</table>"
					+ "</center>"
					+ "</body>"
					+ "</html>");
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
