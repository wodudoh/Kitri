class A{
	int i;
	static int si;
	void m(){
		System.out.println("in m: i=" + i+", si=" + si);
	}
	static void sm(){
//		System.out.println("in sm: i=" + i+", si=" + si); // static 메소드에서는 instance 변수를 사용하면 안된다.
	}
}
public class StaticTest {
	public static void main(String[] args) {
		System.out.println(A.si);
//		System.out.println(A.i); //객체가 생성되기전에 인스턴스 변수를 호출 하지 못해서
		A a1 = new A();
		A a2 = new A();
		a1.i++;
		a1.si++; //static 변수를 증가시키는 것은 권장 하지 않는다.
		
		a2.i++;
		a2.si++;
		
		System.out.println(A.si);
		System.out.println(a1.si);
		
		System.out.println(a1.i);
		System.out.println(a2.i);
		
		A.sm();
//		A.m(); //객체를 생성하지 않고 instance method는 바로 사용 하지 못한다.
		
		a1.sm();
		a1.m();
	}
}
