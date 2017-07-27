package enumExample;

public enum MedicineTime {

	MORN(1),NOON(2),EVE(3)
	;
	
	
final	private int  TIME_CODE;

private MedicineTime(int tCode) {
	TIME_CODE=tCode;
}


	public int getTimeCode(){
		return TIME_CODE;
		
	}
	
	
}
