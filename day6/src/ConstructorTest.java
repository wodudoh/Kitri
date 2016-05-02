/**
 * 이 프로그램은 Constructor(생성자) 연습을 위한 클래스입니다.
 * @author Administrator
 *
 *	속성-가로, 세로, 면적, 둘레
 *	기능- 면적을 계산한다.
 *		 둘레를 계산한다.
 *	
 *
 */

class Rectangle{
	
	int width,height;
	int area;
	int circum;
	
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
}

public class ConstructorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle r1 = new Rectangle(3,4); //가로 3, 세로4인 직사각형 객체
		r1.makeArea(); //사각형객체의 면적을 계산한다.
		r1.makeCircum(); // 둘레 계산한다.
		r1.print(); //사각형의 정보를 출력한다. 결과 : 가로3, 세로4인 사각형의 면적은 12입니다.
		
		Rectangle r2 = new Rectangle(5);
		r2.makeArea();//사각형객체의 면적을 계산한다.
		r2.makeCircum();// 둘레 계산한다.
		r2.print();
		
		

	}

}
