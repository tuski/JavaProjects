package com.view;

import com.model.Student;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentEditController {

	
	@FXML
	private TextField firstNameFiled;
	
	@FXML
	private TextField lastNameFiled;
	@FXML
	private TextField departmentFiled;
	@FXML
	private TextField stIdFiled;
//	@FXML
//	private DatePicker birthdayFiled;
	private Stage dialogStage;
	private Student student;
	private boolean okClicked=false;
	@FXML
	private void initialize(){
		
		
	}
	
	public void setDialogStage(Stage dialogStage){
		this.dialogStage=dialogStage;
	}
	
	public void setStudent(Student clickedStudent){
		this.student=clickedStudent;
		firstNameFiled.setText(clickedStudent.getFirstName());
		lastNameFiled.setText(clickedStudent.getLastName());
		stIdFiled.setText(""+clickedStudent.getstID());
		departmentFiled.setText(clickedStudent.getDepartment());
	}
	@FXML
private void handleOkClicked(){
		 student.setFirstName(firstNameFiled.getText());
		 student.setLastName(lastNameFiled.getText());
		 student.setStId(Integer.parseInt(stIdFiled.getText()));
		 student.setDepartment(departmentFiled.getText());
		 
		 
		 okClicked=true;
		 
		 dialogStage.close();
	}
	
	@FXML
private void handleCancelClicked(){
		dialogStage.close();
	}
	
	public boolean isOkCicked(){
		return okClicked;
	}
	
	
}
