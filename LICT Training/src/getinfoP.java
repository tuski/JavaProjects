import java.util.Scanner;

public class getinfoP {


	private String name,dept;
	private int salary;
	public int a;
	
	Scanner scan = new Scanner(System.in);


	void askinfo(){
		
		
		System.out.println("Enter name:");
		setName(scan.next());
		//this.setName(name);
		
		
		System.out.println("Enter dept:");
		setDept(scan.next());
		//this.dept;
		System.out.println("Enter salary:");
		int alary=scan.nextInt();
		this.setSalary(alary);
		
		
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
}
