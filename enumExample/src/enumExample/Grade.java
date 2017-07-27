package enumExample;

public enum Grade {

	A(4),B(3.5),C(3),D(2),F(0);
	
final	private double gradePoint;

private Grade(double g){
	this.gradePoint=g;
}
public double getGrade(){
	return gradePoint;
	
}

	
}
