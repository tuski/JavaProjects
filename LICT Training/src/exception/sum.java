package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class sum {

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		int a,b;
		
		
	while(true){	
		try{
			System.out.println("Enter a a value");
			a=scan.nextInt();
			System.out.println("Enter a another value");
			b=scan.nextInt();
			System.out.println("Addition value is "+(a+b));
			System.out.println("Addition value is "+(a/b));		
			break;
		}
		catch(ArithmeticException e)
		{
		System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		catch(InputMismatchException in){
			System.out.println("Enter valid input");
			
			
			System.out.println(scan.next());
			
		}
		finally{
			System.out.println("finally");
		}
	}
	
	
	}

}
