package com.model;

public class Student {
	
	private  String studentName;
	private String studentId,department;
	
	public Student(String studentName, String studentId, String department) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.department = department;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", department=" + department + "]";
	}
	

}
