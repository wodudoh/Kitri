import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void test(Map<String, Object> m) throws Exception {
		// Auto Boxing
		m.put("1","first");
		m.put("2", 2); 
		m.put("3", 3L); 
		m.put("4", 4.0F); 
		m.put("5","first"); 
		m.put("6", true); 
		
		System.out.println("자료수: " + m.size());
		System.out.println(m); 
		
		//향상된 for문
		Set<String> keys = m.keySet();
		for(String key : keys){
			Object value = m.get(key);
			System.out.println(key+":"+value);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("========ArrayList========");
		test(new HashMap<String, Object>()); //
		System.out.println("=========Set===========");
		test(new Hashtable<String, Object>()); //
		
		
		

	}
}
