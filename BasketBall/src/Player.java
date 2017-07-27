import Exception.AgeException;
import Exception.FeesException;

public class Player {
	
	private String name;
	private double fees;
	private int age;
	
	public Player(String name, double fees, int age) {
		super();
		this.name = name;
		this.fees = fees;
		this.age = age;
	}
	
	public static Player CheckCondition(String name, double fees, int age) throws AgeException,FeesException{
	
		if(age<18 || age > 40)
			throw new AgeException("Age Limit not matched!");	
		else if(fees<5000)
			throw new FeesException("Fees is not sufficient!");
		 
//		else if(age<18 || age > 40 && fees<5000){
//			throw new FeesException("Fees is not sufficient!");
//			throw new AgeException("Age Limit not matched!");
//			
//		}
		
		else 
			return new Player( name,  fees,  age);
		
		
	}
	
	public void PrintData(){
		
		System.out.println("Name: "+this.name);
		System.out.println("Age: "+this.age);
		System.out.println("Fees: "+this.fees);
		
	}

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
