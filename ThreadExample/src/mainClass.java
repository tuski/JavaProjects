
public class mainClass {

	public static void main(String[] args) {
//		myThread t1= new myThread("one");
//		myThread t2= new myThread("two");
		
		int i;
		for(i=0;i<100;i++)
			System.out.println("main "+" "+i);
		
	Thread	 t1= new Thread(new myRunnable("one"));
	Thread t2= new Thread(new myRunnable("two"));
		
		t1.start();
		t2.start();
		
	}

}
