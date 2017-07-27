package com.handler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "student")
public class student {
private String Name,department,id,homeotwn;

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getHomeotwn() {
	return homeotwn;
}

public void setHomeotwn(String homeotwn) {
	this.homeotwn = homeotwn;
}

@Override
public String toString() {
	return "student [Name=" + Name + ", department=" + department + ", id=" + id + ", homeotwn=" + homeotwn + "]";
}


}
