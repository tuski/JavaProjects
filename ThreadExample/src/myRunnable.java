
public class myRunnable implements Runnable{

	private String name;
	
	 public myRunnable(String name) {
		this.name=name;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<1000;i++){
			try {
				Thread.sleep(200);
				System.out.println(this.name+" "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

	

}
