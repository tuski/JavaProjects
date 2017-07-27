package com.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.controller.util.DBConnector;
import com.model.Student;

public class DBManager {

private static DBConnector dbc;

static{
	try {
		dbc=new DBConnector();
	} catch (SQLException e) {
		// TODO Auto-generated catch dblock
		e.printStackTrace();
	}
}
	
 public static int insertIntoStudent(String sName,String stID,String department) throws SQLException{
	String query="INSERT INTO students (name,id,department)"+" VALUES ('"+sName+"','"+stID+"','"+department+"')";
	
	return dbc.getStatement().executeUpdate(query);
}

public static List<Student> getAllStudent() throws SQLException{
	String query="Select * from students";
	List<Student> student= new ArrayList<>();
	ResultSet rs=dbc.getStatement().executeQuery(query);
	while(rs.next()){
		student.add(new Student(rs.getString("name"),rs.getString("stId"),rs.getString("department")));
		
	}
		
	return student;
}
 

public static Student getStudentByID(String id) throws SQLException{
	
	String sql="Select * from students where students.roll=?";
PreparedStatement pst=dbc.getPreparedStatement(sql);
	pst.setString(1, id);
	
	ResultSet rs= pst.executeQuery();
	Student st=null;
	
	if(rs.next()){
		st=new Student(rs.getString("name"),rs.getString("stId"),rs.getString("department"));
	}
	
	return st;
			
			
}

 
}
