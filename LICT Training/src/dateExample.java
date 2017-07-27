import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class dateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Date d= new Date();
		
		//d.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss");
		
			
				//System.out.println(sdf.format(d));
			
		Calendar c= Calendar.getInstance();
		
	System.out.println("month= "+(c.get(Calendar.MONTH)+1)+" day= "+c.DAY_OF_MONTH+" year= "+c.getWeekYear());	
				
				Calendar c2= (Calendar) c.clone();
				
				SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy, hh:mm:ss");
						sdf.format(c2.getTime());
				System.out.println("\ntime= "+c2.getTime());
				
	
				
	GregorianCalendar gCalender= new GregorianCalendar();
				
				
				
	}

}
