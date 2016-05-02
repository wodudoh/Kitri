interface A{
	void a(); //public astract void a();와 동일함.
}

interface B{
	void b();
	
}

interface C extends A{
	void c();
}

class D implements A{

	@Override
	public void a() { // 반드시 public 선언 해줘야한다.
		System.out.println("D의 a()");
	}
	
}

class E implements A, B{

	@Override
	public void b() {
		// TODO Auto-generated method stub
		System.out.println("E의 a()");
		
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		System.out.println("E의 b()");
		
	}
	
}

class F implements C{ // A를 상속 받은 C 메소드

	@Override
	public void a() {
	System.out.println("F의 a()");
		
	}

	@Override
	public void c() {
		System.out.println("F의 c()");
	}
	
}

public interface InterfaceTest {
	public static void main(String[] args) {
		A a;
		a = new D(); // 상위 interface로 upcasting가능
		a.a(); // a.a()는 d의 a()메소드가 호출된다.
//		a.b();
		
		a = new E(); //e의 a()메소드가 호출됨.
		
		
		a = new F();
		a.a();
//		a.c();
	}
}
