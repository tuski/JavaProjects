
public class Car implements carInterface {

	
	private String CarName;
	
	public Car(String carname){
		
		this.CarName=carname;
	}
	
	
	@Override
	public void DriveCar(int kms) {
		// TODO Auto-generated method stub
		System.out.println("U have driven "+kms+" KM");
	}

	@Override
	public String getCarName() {
		// TODO Auto-generated method stub 
		return CarName;
	}

	
	
}
