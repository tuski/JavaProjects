package com.handler;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBHandler {
	  // Export
    public static void marshal(List<student> s, File selectedFile)
            throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(studentList.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(new studentList(s), writer);
        writer.close();
    }
 
    // Import
    public static List<student> unmarshal(File importFile) throws JAXBException {
    	studentList sttList = new studentList();
 
        JAXBContext context = JAXBContext.newInstance(studentList.class);
        Unmarshaller um = context.createUnmarshaller();
        sttList = (studentList) um.unmarshal(importFile);
 
        return sttList.getStudents();
    }
}
