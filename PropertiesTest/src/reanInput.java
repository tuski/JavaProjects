import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.xml.sax.InputSource;

public class reanInput {


	public static void main(String[] args) {
	
	Properties p =new Properties();
	
//	//try er moddhe argument hisebe dile connection auto close hobe
//	try(InputStream is= new FileInputStream("resource/Config.properties")){
//		
//       p.load(is);		
//       System.out.println(p.getProperty("myName"));
//       String s= p.getProperty("myName");
//     //  System.out.println(p.getProperty("Class"));
//       
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
	
	try(InputStream is= new FileInputStream("mInfo/MyInfo.txt")){
		
	       p.load(is);		
	       System.out.println(p.getProperty("myName"));
	     //  String s= p.getProperty("subject");
	      // String s= p.getProperty("University");
	       System.out.println("Name: "+p.getProperty("myName")+"\nUniversity: "+p.getProperty("University")+"\nSubject: "+p.getProperty("subject"));
	       
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	
	}
	
	
}
