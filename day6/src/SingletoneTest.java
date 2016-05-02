
/**
 * 싱글톤을 연습하기 위한 class입니다.
* @author Administrator
*
*/

class Single{
	
	static Single s = new Single(); // 객체를 미리 만들기 위한 것.
	
	int i;
	
	static Single getInstance(){
//		return new Single();
		return s;
		
	}
	
}
public class SingletoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Single s1,s2,s3;
		s1 = Single.getInstance();
		s2 = Single.getInstance();
		s3 = Single.getInstance();
		
		s1.i++;
		
		System.out.println(s1 == s2); // 예상되는 결과값은 new 니까 false 서로다른 객체가 생성 된다.
		System.out.println(s3 == s1); // 예상되는 결과값은 new 니까 false 서로다른 객체가 생성 된다.
		
		System.out.println(s3.i);
		
		
		

	}

}
