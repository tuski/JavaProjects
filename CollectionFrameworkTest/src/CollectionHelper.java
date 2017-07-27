import java.util.*;
import java.util.Map.Entry;

public class CollectionHelper {

	public static void main(String[] args) {

		List<String> lst = new ArrayList<String>();

		List<String> lst2 = new LinkedList<String>();

		List<String> UserDetail = new ArrayList();
		// ls1.add("one");
		// ls1.add("tusar");
		//
		// lst.add("one");
		// lst.add("two");
		// lst.addAll(ls1);

		// UserDetail.add("Name: Tusar");
		// UserDetail.add("Subject: CSE");
		//
		//
		// //lst.retainAll(ls1);
		//
		// Iterator<String> itr = UserDetail.iterator();
		// while (itr.hasNext()) {
		// System.out.println(itr.next());
		// }
		//

		Set<String> st = new HashSet<String>();
		
		st.add("tus");
		st.add("tus3");
		st.add("tus2");
		
		Iterator itr=st.iterator();
		
		st.forEach((final String name)   -> System.out.println(name)) ; 
		//st.forEach(action);
		while(itr.hasNext()){
			
		//	System.out.println(itr.next());
			
		}
		
		Map<String,String> myMap= new  HashMap();
		
		myMap.put("Name", "tuski");
		myMap.put("baps", "bappy");
		
        
		//myMap.entrySet();
		//Map.Entry<K, V>
		Set<Map.Entry<String,String>> entryset=myMap.entrySet();
		
		Iterator<Entry<String,String>>  itr2=entryset.iterator();
		while(itr.hasNext())
		{
			Entry<String,String> e =itr2.next();
			System.out.println(e.getValue());
		}
//	System.out.println();	
		
		
		//System.out.println(myMap.get("tus"));
		

	}

}
