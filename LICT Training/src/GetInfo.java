import java.util.Scanner;

public class GetInfo {

	 Scanner scan = new Scanner(System.in);
private String name;
private String dept;
		private	int roll;
void askInfo()
{
	System.out.println("Enter Name:\n");
	 name = scan.nextLine();
	System.out.println("Enter Roll:\n");
	 roll = scan.nextInt();
	System.out.println("Enter Department:\n");
	 dept = scan.next();
}

void showInfo()
{
	System.out.println("Name: "+name+"\n");
	
	System.out.println(" Roll:"+roll+ "\n");
	 
	System.out.println("Department:"+dept+ "\n");
	
}
}
