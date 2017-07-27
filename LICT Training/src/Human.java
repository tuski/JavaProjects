
public class Human implements HumanInterface{

	@Override
	public void talk() {
		System.out.println("I can Speak");
		
	}

	@Override
	public void walk(double dist) {
		// TODO Auto-generated method stub
		
		System.out.println("I can walk "+dist+" km");
		
	}

	@Override
	public boolean listen() {
		System.out.println("I can listen ");
		return true;
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void run(int kms) {
		// TODO Auto-generated method stub
		System.out.println("I can run "+kms+" km");
	}

	@Override
	public void study(boolean read) {
		if(read==true)
		System.out.println("Studying ");
		else
			System.out.println("not studying");
			
	
		
	}

	
	
	
	
}
