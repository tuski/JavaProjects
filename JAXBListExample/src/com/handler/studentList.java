package com.handler;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "student list")
public class studentList {


    @XmlElement(name = "student", type = student.class)
    private List<student> studentList = new ArrayList<student>();
    
    public studentList(List<student> s) {
    	 this.studentList = s;
	}

	public studentList() {
		// TODO Auto-generated constructor stub
	}

	 
 
    public List<student> getStudents() {
        return studentList;
    }
 
    public void setStudents(List<student> students) {
        this.studentList = students;
    }   
    
	
}
