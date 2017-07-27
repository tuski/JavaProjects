import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.role.Doctor;

public class MainClass {

	public static void main(String[] args) throws Exception{
		
	
		List<Doctor> nuroSergeon = new ArrayList<>();
		nuroSergeon.add(new Doctor(102, "Azizul Haque", "nuro", 9, 12));
		nuroSergeon.add(new Doctor(103, "Neamul Haque", "nuro", 9, 12));
		nuroSergeon.add(new Doctor(100, "Shovon Mollick", "nuro", 10, 15));
		nuroSergeon.add(new Doctor(101, "Sumon", "nuro", 14, 20 ));
		nuroSergeon.add(new Doctor(104, "Hadi", "nuro", 9, 12));
		nuroSergeon.add(new Doctor(105, "Tusar", "nuro", 10, 15));
		
		List<Doctor> medicin = new ArrayList<>();
		medicin.add(new Doctor(111, "Azizul Haque", "medicine", 9, 12));
		medicin.add(new Doctor(112, "Inzamamul Haque", "medicine", 12, 16));
		
		Map<String,List<Doctor>> map = new HashMap<String,List <Doctor>>();
		map.put("nuro", nuroSergeon);
 		map.put("medicine", medicin);
		
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter patient details: ");
		System.out.println("Disease: ");
		String disease=br.readLine();
		
		System.out.println("Arrival Time: ");
		String s= br.readLine();
		int pArrival=Integer.parseInt(s);  
		
		List<Doctor> desiredList = map.get(disease);
		Iterator<Doctor> iter = desiredList.iterator();
		
		while(iter.hasNext()) {
			Doctor d = iter.next();
			if(d.getVisiting_start() <= pArrival &&  pArrival<= d.getVisiting_end() ) {
				System.out.println("Doctor Name: "+d.getDoc_Name()+"\nVisiting Hour: "+d.getVisiting_start()+" to "+d.getVisiting_end());
			}
			
		}
	}

}
