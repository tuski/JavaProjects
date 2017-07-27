import Exception.AgeException;
import Exception.FeesException;

public class MainClass {

	public static void main(String[] args) {
		
		
		Player player= null;
		
		try{
			player=Player.CheckCondition("Tusar", 500, 30);
		}
		catch(AgeException ae){
			System.out.println(ae.getMessage());
		}
		catch(FeesException fe){
			System.out.println(fe.getMessage());
		}

		
		
		player.PrintData();
		
		
		
		
	}

}
