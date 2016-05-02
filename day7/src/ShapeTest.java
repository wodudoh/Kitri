
/**
 * 오버라이드 실습을 위한 클래스
 * @author Administrator
 *
 */

class Shape{
	double area;
	double circum;
	void makeArea(){
		System.out.println("Shape의 makeArea()");
	}
	void print(){
		System.out.println("쉐이프의 프린트이얌");
	}
	
	public String toString(){
		return "도형입니다.";
	}
	
}

class Circle extends Shape{
	
	int radius; //반지름값
	double area; // 모든 변수를 지역변수  
	
	Circle(int raidus){
		this.radius = raidus;
	}
	public void makeArea() {
		
		System.out.println(String.format("%.2f", area=Math.pow(radius, 2)*Math.PI));
		
	}
	
	public void print(){
		System.out.println("반지름이 " + radius + "인 원의 면적은 " + area);
	}
	
	public String toString(){
		return "원입니다.";
	}
	
}
class Rectangle extends Shape{
	
	int width, height;
//	int area;
//	int circum;
	
	Rectangle(int wdith, int height){
		this.width=wdith;
		this.height=height;
	}
	
	Rectangle(int w){
		this(w,w);
//		this.width=a;
//		this.height=a;
	}
	void makeArea(){
		area= width * height;
	}
	void print(){
		System.out.println("결과 : 가로"+ width + " 세로"+height+"인 사각형의 면적은 "+area+"입니다.");
		System.out.println("결과 : 가로"+ width + " 세로"+height+"인 사각형의 둘레은 "+circum+"입니다.");
	}
	void makeCircum(){
		circum =(width+height)*2;
	}
	public String toString(){
		return "사각형입니다.";
	}
}

/** 실행을 위한 main method가 포함된 ShapeTest 클래스
 * @author Administrator
 *
 */
public class ShapeTest {

	public static void main(String[] args) {
		
		Circle c1=new Circle(5); // 반지름이 5인 원객체
		c1.makeArea();// 면적을 계산
		c1.print();
		
		Shape s1 = c1; //Up Casting
		Circle c2; 
		c2 = (Circle)s1; //down Casting
		
//		if(s1 instanceof Shape){
//			System.out.println("동일한 객체입니다.");
//		}
		
//		System.out.println(s1.raidus);
		
		s1.makeArea();
		s1.print();
		
		Shape[] arr = new Shape[3];
		arr[0] = new Shape();
		arr[1] = new Circle(10); // superclass가 Shape
		arr[2] = new Rectangle(20, 30);
		
		for(Shape cnt : arr){
			cnt.makeArea();
		}
		System.out.println();
		
		test(new Shape());
		test(new Circle(100));
		test(new Rectangle(200, 300));
		System.out.println();
		
		test1(new Object());
		test1(new String("hello"));
		test1(new StringBuffer("hello"));
		test1(new Shape());
		test1(new Circle(100));
		test1(new Rectangle(200,300));
		
		
	}
		
	public static void test(Shape s){
		s.makeArea(); //동적바인딩
	}
	
	public static void test1(Object o){
		String info = o.toString();
		System.out.println(info);
	}

}
