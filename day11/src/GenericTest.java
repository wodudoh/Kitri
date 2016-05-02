import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class GenericTest {
	public static void test(Collection<Integer> c) throws Exception {
	
		c.add(1);
//		c.add("fkfk");
		//향상된 for문
		for(Object ojb : c){
			System.out.println(ojb);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("========ArrayList========");
		test(new ArrayList<Integer>()); // 중복 허용, 순차 저장
		System.out.println("=========Set===========");
		test(new HashSet<Integer>()); //중복 허용 안함, 순차 저장 안됨.
		

	}

}
