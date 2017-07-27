import java.util.Scanner;

public class Calculator extends mathClass{

	public Calculator(){
		System.out.println("Enter Choice:\n1.Sum\n2.Subtract\n3.Multiplication\n4.Division\n0.Exit\n");
		
	}

	
 void choice(){
	int  Choice;
	Scanner scan = new Scanner(System.in);
    Choice=scan.nextInt();
	
	while(Choice!=0){
		
		System.out.println("Enter Number:\n");
		double a,b;
		a=scan.nextInt();
		b=scan.nextInt();
		
		if(Choice==1)
	        System.out.println("Sum is: "+add(a,b)+"\n");	
		else  if(Choice==2)
			System.out.println("Subtraction is: "+subtract(a,b)+"\n");			
		else if(Choice==3)
			System.out.println("Multiplication is: "+multiplication(a, b)+"\n");
		else if(Choice==4)
			System.out.println("Division is: "+division(a, b)+"\n");
		else if(Choice==0)
			break;
		
		System.out.println("Enter Choice:\n1.Sum\n2.Subtract\n3.Multiplication\n4.Division\n0.Exit\n");
		Choice=scan.nextInt();
	
	}
	
	System.out.println("Thank You For Using OOP Calculator!");
	
}

	
	
}
