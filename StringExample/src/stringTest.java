
public class stringTest {


	public static void main(String[] args) {
	
//	StringBuffer strBuffer= new StringBuffer("String ");	
//	
//	strBuffer.append("Buffer is nice");
//	System.out.println(strBuffer);
//	
//	
//StringBuilder strBuilder= new StringBuilder("String ");	
//	
//strBuilder.append("Builder is nice");
//	System.out.println(strBuilder);
//	
//	
//	strBuffer.replace(3, 5, "tus");
//	
//	System.out.println(strBuffer);
		
		long curTimeBF= System.currentTimeMillis(); 
		StringBuffer strBuffer= new StringBuffer();
		int i;
		
		for( i=0;i<1000;i++){
			strBuffer.append(" "+i);
		}
		
		long curTimeBF2 =System.currentTimeMillis(); 
		System.out.println("StrBf: "+(curTimeBF2-curTimeBF)+" i=: "+i);
		
	
String st;
	
	long curTimeBD4= System.currentTimeMillis(); 
	StringBuilder strBuild= new StringBuilder();
	
	//int i;
	
	for( i=0;i<1000;i++){
		strBuild.append(" "+i);
	}
	
	long curTimeBD5 =System.currentTimeMillis(); 
	System.out.println("StrBuilder: "+(curTimeBD5-curTimeBD4)+" i=: "+i);
	
}
}
