package com.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.handler.JAXBHandler;
import com.handler.student;

public class mainClass {

	public static void main(String[] args) throws IOException {
		
		student s1=new student();
		s1.setName("Tusar");
	    s1.setId("123101");
	    s1.setDepartment("CSE");
	    s1.setHomeotwn("Rajshahi");
	    
	    student s2=new student();
		s2.setName("Rasel");
	    s2.setId("123102");
	    s2.setDepartment("CSE");
	    s2.setHomeotwn("Rajshahi");
	    
	    List<student> stList= new ArrayList<>();
	    
	    stList.add(s1);
	    stList.add(s2);
	    
	    try {
            JAXBHandler.marshal(stList, new File("students.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
         
        //Unmarshalling: Converting XML content to Java objects
        try {
            stList = JAXBHandler.unmarshal(new File("students.xml"));
        } catch (JAXBException e) {
            //e.printStackTrace();
            e.getMessage();
        }
        System.out.println(stList);
	    
	}

}
