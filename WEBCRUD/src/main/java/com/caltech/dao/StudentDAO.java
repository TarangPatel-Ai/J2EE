package com.caltech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.caltech.dbUtil.DbUtil;
import com.caltech.pojo.Student;

public class StudentDAO {
	
	public int insertStudentintodb(Student student) throws ClassNotFoundException, SQLException {
		Connection con = DbUtil.getConn();
		if(con!=null) {
			System.out.println("Database Connect Successfully");
		}else {
			System.out.println("Database Not connected");
		}
		//prepare statement for Database ---- Statement, PreparedStatement
		//Statement st = con.createStatement();	
		//String sql = "insert into Student values(" +student.getSid() + ",'" +student.getSname()+"','"+student.getSemail()+"')";
		String sql = "insert into Student values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		//System.out.println(sql);
		ps.setInt(1, student.getSid());
		ps.setString(2, student.getSname());
		ps.setString(3, student.getSemail());
		
		int i = ps.executeUpdate(); //the number of rows
		//insert, update, delete---executeUpdate 
		return i;
		
	
	}
	
	public List<Student> retreiveStudentData() throws SQLException, ClassNotFoundException {
		Connection con = DbUtil.getConn();
		if(con!=null) {
			System.out.println("Database Connect Successfully");
		}else {
			System.out.println("Database Not connected");
		}
		//prepare statement for Database ---- Statement, PreparedStatement
		//Statement st = con.createStatement();
		String sql = "select * from Student";
		PreparedStatement ps = con.prepareStatement(sql);
		//System.out.println(sql);
		ResultSet rs = ps.executeQuery(); //Select
		//in rs object we get the table object
		
		List<Student> list = new ArrayList<>();
		
		while(rs.next()) { //Whether the row has data or not
			Student student = new Student();
			student.setSid(rs.getInt("sid"));
			student.setSname(rs.getString("sname"));
			student.setSemail(rs.getString("semail"));
			list.add(student);
		} 
		return list;
	}
	
	public List<Student> deleteStudentData(int studentId) throws SQLException, ClassNotFoundException {
		Connection con = DbUtil.getConn();
		if(con!=null) {
			System.out.println("Database Connect Successfully");
		}else {
			System.out.println("Database Not connected");
		}
		//prepare statement for Database ---- Statement, PreparedStatement
		//Statement st = con.createStatement();	
		//String sql = "insert into Student values(" +student.getSid() + ",'" +student.getSname()+"','"+student.getSemail()+"')";
		String sql = "delete from Student where sid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		//System.out.println(sql);
		ps.setInt(1, studentId);
		
		int i = ps.executeUpdate(); //the number of rows
		//insert, update, delete---executeUpdate 
		
		return retreiveStudentData();
		
	}	
	
	
	public List<Student> updateStudentData(int studentId, String newName, String newEmail) throws ClassNotFoundException, SQLException {
		Connection con = DbUtil.getConn();
		if(con!=null) {
			System.out.println("Database Connect Successfully");
		}else {
			System.out.println("Database Not connected");
		}
		//prepare statement for Database ---- Statement, PreparedStatement
		//Statement st = con.createStatement();	
		//String sql = "insert into Student values(" +student.getSid() + ",'" +student.getSname()+"','"+student.getSemail()+"')";
		String sql = "UPDATE Student SET sname = ?, semail = ? WHERE sid = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		//System.out.println(sql);
		ps.setString(1, newName);
        ps.setString(2, newEmail);
        ps.setInt(3, studentId);
		
		int i = ps.executeUpdate(); //the number of rows
		//insert, update, delete---executeUpdate 
		
		return retreiveStudentData();
	
	}
	
}
