
public class mathClass extends mathAbstraction implements mathInterface {

	@Override
	public double add(double x, double y) {
		
		double sum=x+y;
		return sum;
	}

	@Override
	public double subtract(double x, double y) {
		double sub;
		if(x>y)
			
		return sub=x-y;
		else
			return sub=y-x;
	}

	
	
	@Override
	public double division(double x, double y) {
		double div=x/y;
		return div;
	}

	
}
