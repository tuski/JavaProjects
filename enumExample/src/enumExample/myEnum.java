package enumExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class myEnum {

	

	public static void main(String[] args) {

//	MedicineTime time= MedicineTime.EVE;
//	
//   for(MedicineTime a:MedicineTime.values())
//	System.out.println(a.values()+" "+a.getTimeCode());
//		
//	
//	
		
		System.out.println("Please Enter Student Info\n");
		
	
	 String name,department = null;
	 int id;
	 double hci;
	 double dbms;
	 double ai;
	 String avgGrade;
	 double avgGP;	
   
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   
   System.out.println("Department:");
	try {
		department=br.readLine();
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
	
	
	while(true){

   try {
	   
	   System.out.println("Name:");
	name=br.readLine();
	 System.out.println("id:");
		id=Integer.parseInt(br.readLine()) ;
		
		 System.out.println("enter marks of three subjects seperated by space\n:");
			String[] marks=br.readLine().split(" ");
			
		hci=Double.parseDouble(marks[0]);
		dbms=Double.parseDouble(marks[1]);
		ai=Double.parseDouble(marks[2]);
		
		Student s1=new Student(name,id,department,hci,dbms,ai);
		//System.out.println(s1.toString());
		
		System.out.printf("Name: %s  Avg GP: %.2f  \n",s1.getName(),s1.getAvgGP());
		
		System.out.println("Do you want to continue?\n Press N to exit. ");
		   //String ans;
		// String  ans = br.readLine();
		
			// if(ans.equals("n") || ans.equals("N"))
		
				 if(br.readLine().equalsIgnoreCase("n"))
				   break;
				 
		   
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   
   
 
   
	} 
	
   
   
		
	}

	
}
