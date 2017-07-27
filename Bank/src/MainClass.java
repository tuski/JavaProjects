import java.util.Scanner;

import Exception.BalanceException;

public class MainClass {

	
	public static void main(String[] args) {
		
	//Account ac= Account.newInstance("Tusar", "101",50);

		int NumberOfAccount=getNumber();
		Account[] acc= new Account[NumberOfAccount];
		
		Account ac=null;
		
		
		
		
		
		
		
		try{
			ac=Account.newInstance("Tusar", "101",50);
		}
		catch(BalanceException be){
			try {
				ac=Account.newInstance("Tusar", "101",500);
			} catch (BalanceException e) {
			
				e.printStackTrace();
			}
		}
		
	if(ac!=null){
			System.out.println("Account Created"+ac.toString());
		}
		else
			System.out.println("Account cannot created");
		
		
	}
	
	
	public static int getNumber(){
		
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		return num;
		
	}
}
