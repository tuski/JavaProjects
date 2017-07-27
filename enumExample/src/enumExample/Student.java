package enumExample;

public class Student {

	private String name,department;
	private int id;
	private double hci;
	private double dbms;
	
	private Grade gHci;
	private Grade gdbms;
	private Grade gai;
	
	public String getAvgGrade() {
		return "";
		
	}
	
	public double getAvgGP() {
		
		
		return (gHci.getGrade()+gdbms.getGrade()+gai.getGrade())/3;
	}
	
	public Student(String name, int id, String department, double hci, double dbms, double ai) {
		super();
		this.name = name;
		this.department = department;
		this.id = id;
		this.hci = hci;
		this.dbms = dbms;
		this.ai = ai;
		
		setGrades(hci,dbms,ai);
	}
	private void setGrades(double hci2, double dbms2, double ai2) {
	gHci= getGradeFromMark(hci2);
	gdbms= getGradeFromMark(dbms2);
	gai= getGradeFromMark(ai2);	
	}
	private Grade getGradeFromMark(double mark) {
		Grade g=Grade.F;
		if(mark>=90 && mark<=100)
			g=Grade.A;
		else if(mark>=80 && mark<=89)
		g=Grade.B;
		else if(mark>=70 && mark<=80)
			g=Grade.C;
		else if(mark>=60 && mark<=70)
			g=Grade.D;
		else if(mark>=80 && mark<=89)
			g=Grade.B;
			
		return g;
	}
	private double ai;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getHci() {
		return hci;
	}
	public void setHci(double hci) {
		this.hci = hci;
	}
	public double getDbms() {
		return dbms;
	}
	public void setDbms(double dbms) {
		this.dbms = dbms;
	}
	public double getAi() {
		return ai;
	}
	public void setAi(double ai) {
		this.ai = ai;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", department=" + department + ", id=" + id + ", hci=" + hci + ", dbms=" + dbms
				+ ", ai=" + ai + "]";
	}
	
	
	
	
	}
