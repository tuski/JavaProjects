package com.role;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

	private String Doc_Name,Specialised;
	
	private int Doc_id,Visiting_start,Visiting_end;
	List<String> patientList=new ArrayList();
	

	public Doctor(int doc_id, String doc_Name, String specialised, int visiting_start, int visiting_end) {
		super();
		Doc_id = doc_id;
		Doc_Name = doc_Name;
		Specialised = specialised;
		Visiting_start = visiting_start;
		Visiting_end = visiting_end;
	}

	public String getDoc_Name() {
		return Doc_Name;
	}

	public void setDoc_Name(String doc_Name) {
		Doc_Name = doc_Name;
	}

	public String getSpecialised() {
		return Specialised;
	}

	public void setSpecialised(String specialised) {
		Specialised = specialised;
	}

	public int getDoc_id() {
		return Doc_id;
	}

	public void setDoc_id(int doc_id) {
		Doc_id = doc_id;
	}

	public int getVisiting_start() {
		return Visiting_start;
	}

	public void setVisiting_start(int visiting_start) {
		Visiting_start = visiting_start;
	}

	public int getVisiting_end() {
		return Visiting_end;
	}

	public void setVisiting_end(int visiting_end) {
		Visiting_end = visiting_end;
	}

	public List<String> getPatientList() {
		return patientList;
	}

	public void setPatientList(List<String> patientList) {
		this.patientList = patientList;
	}
	
	
	
	
	
}
