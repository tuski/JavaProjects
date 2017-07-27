import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class mainClass {

	public static void main(String[] args) {

		Properties prop= new Properties();
		OutputStream os=null;
		
//		try{
//			os=new FileOutputStream("resource/Config.properties");
//			prop.setProperty("Class", "Ruet-02");
//			prop.setProperty("myName", "Tusar-02");  //prop object e save kortese
//			prop.store(os," tusii");   //file e write kortese
//		}
//		catch(Exception e){
//			System.out.println("file not found");
//		}
//		finally{
//			try {
//				if(os!=null)
//				os.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
		
		try{
			os=new FileOutputStream("mInfo/MyInfo.txt");
			prop.setProperty("University", "Ruet");
			prop.setProperty("myName", "Tusar");  //prop object e save kortese
			prop.setProperty("subject", "CSE");
			prop.store(os," tusii");
			
		}
		catch(Exception e){
			System.out.println("file not found");
		}
		finally{
			try {
				if(os!=null)
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
