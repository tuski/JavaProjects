
public class HumanImpel extends absHuman implements HumanInterface{

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("I can Speak");
	}

	@Override
	public void walk(double dist) {
		// TODO Auto-generated method stub

		System.out.println("I can walk "+dist+" km");
		
		
	}

	@Override
	public boolean listen() {
		// TODO Auto-generated method stub
		System.out.println("I can listen ");
		return true;
	}

	@Override
	public void run(int kms) {
		// TODO Auto-generated method stub
		System.out.println("I can run "+kms+" km");
	}

	@Override
	public void study(boolean read) {
		// TODO Auto-generated method stub
		if(read==true)
			System.out.println("Studying ");
			else
				System.out.println("not studying");
				
	}

	
	
	
}
