package com.controller;

import java.io.IOException;

import com.model.Student;
import com.view.StudentEditController;
import com.view.StudentViewController;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Student>students=FXCollections.observableArrayList();
	private String initDir="/com/view/";
	public MainApp(){
		for(int i=1;i<10;i++)
		students.add(new Student("StudentFirstName:"+i,"StudentLN"+i) );
	}
	
	public ObservableList<Student>getStudents(){
		return this.students;
	}
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Student View");
		
		initRoot();
		addStudentOverview();
		
	}

	private void addStudentOverview() {
		
		try {
			FXMLLoader loader=getLoader(initDir+"StudentView.fxml");
			//loader.setLocation(MainApp.class.getResource("/com/view/StudentView.fxml"));
			AnchorPane stView= loader.load();
			rootLayout.setCenter(stView);
			StudentViewController stVController= loader.getController();
			stVController.setMainApp(this);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void initRoot() {
		
		try {
//			FXMLLoader loader=new FXMLLoader();
			//loader.setLocation(MainApp.class.getResource("/com/view/rootView.fxml"));
			
			FXMLLoader loader=getLoader(initDir+"RootView.fxml");
			rootLayout= loader.load();
			Scene scene= new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean ShowStudentDialog(Student student){
		
		try {
			FXMLLoader loader=getLoader(initDir+"StudentEditDialog.fxml");
			AnchorPane dialogView= loader.load();
			
			//creating stage and initialize it
			
			Stage stage=new Stage();
			stage.setTitle("St edit");
			stage.initOwner(primaryStage);
			stage.initModality(Modality.WINDOW_MODAL);
			
			Scene dialogScene= new Scene(dialogView);
			stage.setScene(dialogScene);
			
			
			StudentEditController controller=loader.getController();
			controller.setDialogStage(stage);
			controller.setStudent(student);
			
			return controller.isOkCicked();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public FXMLLoader getLoader(String linkOfLoader){
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(MainApp.class.getResource(linkOfLoader));
		return loader;
	}
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
