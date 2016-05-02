import java.util.StringTokenizer;

public class StringTest {
/**
 * String API 객체 에서 제공해주는 메소드
 * @param args
 */
public static void main(String[] args) {
	String s1,s2, s3, s4;
	s1 = new String("HELLO");
	s2 = new String("HELLO");
	s3 = "HELLO";
	s4 = "HELLO";
	
	//객체는 몇개를 만드는가? 3개다
	
	System.out.println(s1==s2);
	System.out.println(s1==s3);
	System.out.println(s3==s4);
	
	
	System.out.println(s1 + "JAVA");
	System.out.println(s1);
	System.out.println(s1.toLowerCase()); // 새로운 "hell java" 객체를 생성후 출력
	System.out.println(s1); // 객체는 생성된 불변.
	
	//Object equlas와 String equals 차이
	s1= new String ("HELLO");
	System.out.println(s1.equals(s2));//true
	System.out.println(s1.equals(s3));//true
	System.out.println(s1.equals(s4));//true
				//012345678901234567890
	String str = "HELLO JAVA JDBC WEB SPRING ANDROID";
	System.out.println(str.indexOf("SPRING"));
	int index = str.indexOf("C++");
	System.out.println(index);
	
	//특정 부분 문자열만 가져오기
	System.out.println(str.substring(6, 9+1)); // 9-1 번 메소드 까지 endIndex - 1 까지
	
	//문자열의 길이를 반환
	int size = str.length();
	System.out.println(size); // 0~34개의 인데스 니까.. 글자 하나에 2byte인 한글이라 하더라도 length는 글자 갯수만 반환해준다.
	
	//특정 위치의 문자 하나만 출력.
	char c = str.charAt(16);
	System.out.println(c); 
	
	//문자열 자르기 : split(delimeter, 자를 최대 갯수)
	String [] ar = str.split(" ",6);
	for(String a : ar){
		System.out.println(a);
	}
	
	System.out.println("--------------------");
	
	//stringTokenizer Token:문법적으로 더 이상 나눌 수 없는 기본적인 언어요소
	/**
	 * "HELLO JAVA"
	 * "HELL
	 * JAVA";
	 */
	StringTokenizer st = new StringTokenizer(str, " ");
	
	while(st.hasMoreTokens())
	System.out.println(st.nextToken());
	
	//split과 StringTokenizer 차이점
	str = "100:90::70:50"; // JAVA점수 : JDBC점수:WEB:SPRING:ADROID 현재 구분 가능 한 token은 4개다.
	//아무값도 없으면 Token이라고 볼 수 없다. 빈문자열을 구분을 못한다.
	
	st = new StringTokenizer(str, ":");
	while(st.hasMoreTokens()){
		System.out.println("="+st.nextToken());
	}
	
	//위 내용을 빈문자열을 포함 시키고 싶으면 split으로 변경해야한다.
	
	ar = str.split("\\:",6); // 특수 기호는 레귤러 익스프레젼으로 해야함.
	for(String a : ar){
		System.out.println(a);
	}
	
	//펠린드롬(palindrome) : 앞 뒤 로 읽어도 같은 문자.
	//TODO: 펠림드롬이면 true 아니면 false를 반환하는 프로그램을 만드시오.
	
	
	System.out.println("--------------------");
	str = "기러기";
	
	boolean flag = isPalindrome(str);
	if(flag){
		System.out.println(str + "은 Palidrome문자열입니다.");
	}else
	System.out.println(str + "은 Palidrome문자열이 아닙니다.");
	
	//문자열 객체 내용 불면
	
	//객체 내용 수정 가능 한것은 String Buffer 객체 내용을 바꿀 수 있고, 메모리를 효율적으로 사용 가능함.
	StringBuffer sb = new StringBuffer("HELLO");
	sb.append("JAVA");
	
	
	
	}//main 종료


	static boolean isPalindrome(String str){
		
//		char firstChar = str.charAt(0); 
//		char LastChar = (char) str.charAt(str.length()-1);
//		if (firstChar == LastChar||){
//			return true;
//			
//		}else return false;
//		
		
		//절반 까지만 반복 수행해서 하는방법 
		int size = str.length();
		for(int i=0;i < size/2; i++){
			
			if(str.charAt(i) != str.charAt(size-1-i)){
				
				return false;
			}
		}
		return true;
		
		
		
		
		
	}

}
