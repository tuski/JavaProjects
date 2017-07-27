package junitTest;

import com.main.mathHelper;

public class MainClass {

	public static void main(String[] args) {

		mathHelper math=new mathHelper();
		
		
	System.out.println("Add: "+math.add(1,3,4,5)+"\n");
	System.out.println("sub: "+math.sub(5, 2)+"\n");
	System.out.println("mul: "+math.mul(1,3,4,5)+"\n");
	System.out.println("div: "+math.div(6,3)+"\n");
		
	}

}
