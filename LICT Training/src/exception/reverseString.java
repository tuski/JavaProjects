package exception;

import java.util.Scanner;

public class reverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a text");
		
		String Name,Rev_Name="";
		int length,j=0;
		
		Name= scan.next();
		length= Name.length();
		
		
		for(int i=length-1;i>=0;i--){
			
			Rev_Name+=Name.charAt(i);
		
		
		}
		
		if(Rev_Name.equals(Name))
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");

//		StringBuilder sb = new StringBuilder(scan.next());
//		
//		System.out.println("Reverse= "+sb.toString());
//		

	}

}
