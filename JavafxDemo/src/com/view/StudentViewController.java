package com.view;

import com.controller.MainApp;
import com.helper.Util;
import com.model.Student;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class StudentViewController {
	
	@FXML
	private TableView<Student> studentTable;
	
	@FXML
	private TableColumn<Student,String> firstNameColumn;
	
	@FXML
	private TableColumn<Student,String> LastNameColumn;
    
	@FXML
	private Label firstNameLabel;
	
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label NameLabel;
	@FXML
	private Label departmentLabel;
	@FXML
	private Label stIdLabel;
	@FXML
	private Label birthdayLabel;
	//private boolean isDone;
	
	private MainApp mainApp;
	
	public StudentViewController() {
		
	}
	

	@FXML
	private void handleNew(){
      Student st=new Student();
      boolean okClicked=mainApp.ShowStudentDialog(st);
      if(okClicked){
    	  mainApp.getStudents().add(st);
           
      
      }
	}
	
	@FXML
	private void handleEdit(){
		Student st=studentTable.getSelectionModel().getSelectedItem();
		boolean isDone;
		if(st!=null){
		 isDone=mainApp.ShowStudentDialog(st);
		 if(isDone)
			 showStudent(st);
		showStudent(st);
		}else 
			showAlret();
	}
	
	
	@FXML
	private void initialize(){
		firstNameColumn.setCellValueFactory(d-> d.getValue().getFirstNameProperty());
		LastNameColumn.setCellValueFactory(d-> d.getValue().getLastNameProperty());
		showStudent(null);
		
		studentTable.getSelectionModel().selectedItemProperty().addListener(
				(ob,olv,nv)->showStudent(nv)
				);
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp=mainApp;
		studentTable.setItems(mainApp.getStudents());
	}
	
	
	
	private void showStudent(Student student){
		if(student!=null){
			firstNameLabel.setText(student.getFirstName());
			lastNameLabel.setText(student.getLastName());
			stIdLabel.setText(""+student.getstID());
			departmentLabel.setText(student.getDepartment());
			birthdayLabel.setText(Util.dateToString(student.getBirthday()));
		}
		else{
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			stIdLabel.setText("");
			departmentLabel.setText("");
			birthdayLabel.setText("");
			
		}
	}
	
	
	@FXML
	private void DeleteStudent(){
		int selectedStudentIndex=studentTable.getSelectionModel().getSelectedIndex();
		if(selectedStudentIndex>=0)
		studentTable.getItems().remove(selectedStudentIndex);
		else
		{
			showAlret();
		}
	}
	
	private void showAlret(){
		Alert alert=new Alert(AlertType.WARNING);
		alert.initOwner(mainApp.getPrimaryStage());
		alert.setTitle("No Selection Avaliable");
		alert.setHeaderText("No Student has selected");
		alert.setContentText("Please Select a Student from the table");
	
		alert.showAndWait();
	}

	
	
}

