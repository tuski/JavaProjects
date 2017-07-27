package com.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;




public class Student {

	private final StringProperty firstNameProperty;
	private final StringProperty lastNameProperty;
	private final IntegerProperty stIdProperty;
	private final StringProperty departmentProperty;
	private final ObjectProperty<LocalDate> birthdayProperty;
	
	
	public Student(){
		this(null,null);
	}
	


	public Student(String firstNameProperty, String lastNameProperty) {
		super();
		this.firstNameProperty = new SimpleStringProperty( firstNameProperty);
		this.lastNameProperty = new SimpleStringProperty( lastNameProperty);
		this.departmentProperty=new SimpleStringProperty( "CSE");
		this.stIdProperty= new SimpleIntegerProperty(123);
		this.birthdayProperty=new SimpleObjectProperty<LocalDate>(LocalDate.of(1992, 8, 14));
	}
	public StringProperty getFirstNameProperty() {
		return firstNameProperty;
	}

	public StringProperty getLastNameProperty() {
		return lastNameProperty;
	}

	public IntegerProperty getStIdProperty() {
		return stIdProperty;
	}

	public StringProperty getDepartmentProperty() {
		return departmentProperty;
	}

	public ObjectProperty<LocalDate> getBirthdayProperty() {
		return birthdayProperty;
	}
	
	public void setFirstName(String firstName){
		this.firstNameProperty.set(firstName);
	}
	
	public void setLastName(String lastName){
		this.lastNameProperty.set(lastName);
	}
	
	public void setStId(int value){
		this.stIdProperty.set(value);
	}
	
	public void setDepartment(String dept){
		this.departmentProperty.set(dept);
	}
	
	public void setBirthday(LocalDate date){
		this.birthdayProperty.set(date);
	}
	
	public String getFirstName(){
		return firstNameProperty.get();
	}
	
	public String getLastName(){
		return lastNameProperty.get();
	}
	
	public String getDepartment(){
		return departmentProperty.get();
	}
	public int getstID(){
		return stIdProperty.get();
	}
	public LocalDate getBirthday(){
		return birthdayProperty.get();
	}
}
