import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;



public class CollectionTest {
	
	public static void test(Collection c) throws Exception {
		// Auto Boxing
		c.add("first");
		c.add(2); // 컴파일러에 의해 c.add(new Integer(2));로 바뀜
		c.add(2); 
		c.add(3L); // // c.add(new Long(3));
		c.add(4.0F); // c.add(new Float(3));
		c.add("first"); 
		c.add(true);// c.add(new Boolean(true));
		
		System.out.println("자료수: " + c.size());
		System.out.println(c); //c.toString이 자동 호출임됨.
		//반복문을 이용해서 저장되어있는 자료들을 출력
//		for(int i=0 ; i<c.size(); i++){
////			Object obj = c.get(i); // List의 상위 클래스인 Collection에는 get 메소드가 없어서 불가능. 
//			
//		}
		
		//향상된 for문
		
		for(Object ojb : c){
			System.out.println(ojb);
		}
		
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("========ArrayList========");
		test(new ArrayList()); // 중복 허용, 순차 저장
		System.out.println("=========Set===========");
		test(new HashSet()); //중복 허용 안함, 순차 저장 안됨.
		

	}

}
