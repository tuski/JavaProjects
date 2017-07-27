package com.tusar;
import java.io.Serializable;

public class Student implements Serializable{

	private String firstName, lastName;
	private int age;
	public Student(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	
	
}
