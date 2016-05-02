
public class ObjectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//hashCod
		//객체의 정보값.
		
		Object o1, o2;
		o1=new Object();
		o2=new Object();
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		System.out.println(o1.equals(o2));
		
		//toString
		String h1Str = o1.toString();
		String h2Str = o2.toString();
		System.out.println(h1Str);
		System.out.println(h2Str);
		//equals
		
		
		

	}

}
