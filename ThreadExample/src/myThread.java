
public class myThread extends Thread {

//	public static void main(String[] args)  {
//		// TODO Auto-generated method stub
//
//	}

	public  myThread(String name){
		this.setName(name);
		
	}
	
	
	@Override
synchronized public void run(){
		
		for(int i=0;i<1000;i++){
			try {
				Thread.sleep(2000);
				System.out.println(this.getName()+" "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
}
