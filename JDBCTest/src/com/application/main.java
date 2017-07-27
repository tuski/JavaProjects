package com.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import com.controller.DBManager;
import com.model.Student;

public class main {

	public static void main(String[] args) {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please enter student Name");
		
		try {
			
			try {
				String name=br.readLine();
				System.out.println("Please enter student ID");
				String id=br.readLine();
				System.out.println("Please enter student Department");
				String department=br.readLine();
				int done =DBManager.insertIntoStudent(name, id, department);
				if( done>0)
					System.out.println("Inserted Successufully");
				
			List<Student> allstudent= DBManager.getAllStudent();
			
			for(Student st:allstudent){
				System.out.println(st.toString());
			}
				
			
//			Student st=DBManager.getStudentByID(id);
//			System.out.println(st.toString());
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
	}
	}


