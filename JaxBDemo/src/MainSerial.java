import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainSerial {

	public static void main(String[] args) throws IOException, ClassNotFoundException  {
		
		Customer c=new Customer();
		c.setAge(30);
		c.setId(123);
		c.setName("Tuski");
		Customer c2=new Customer();
		c2.setAge(30);
		c2.setId(987);
		c2.setName("aifhif");
		
		String fileName="Customer.ser";
		
				
			
				
				FileOutputStream fs=new FileOutputStream(fileName);
				ObjectOutputStream os=new ObjectOutputStream(fs);
				os.writeObject(c);
				os.writeObject(c2);
				os.flush();
				os.close();

				FileInputStream fis=new FileInputStream(new File(fileName));
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				 Customer	c1 = (Customer) ois.readObject();
				 Customer	c3 = (Customer) ois.readObject();
				ois.close();
				System.out.println(c1.toString());
				System.out.println(c3.toString());
			
		
	
	}
}
