
public class humanMainClass {
	
	

public static void main(String [] args){


	Human hum = new Human();
	
	
	hum.talk();
	hum.listen();
	hum.walk(30);
	hum.run(50);
	hum.study(false);
	
	System.out.println("\n");
	
	HumanImpel h= new HumanImpel();
	
	h.talk();
	h.listen();
	h.walk(30);
	h.run(50);
	h.study(true);
	
	
	
}

}
