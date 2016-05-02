package day9;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*class MyListener implements ActionListener{
	int cnt=0;
	
	JTextField tf;
		MyListener(JTextField tf){
			this.tf = tf;
		}
	@Override
	public void actionPerformed(ActionEvent e){
//		System.out.println("클릭되었습니다.");
		tf.setText(cnt++ +"클릭되었습니다.");
		
	}
}*/
/**
 * Nested class를 활용한 GUI 프로그램 작성법
 * 
 * GUI용 프로그램 종류 
 * 	- JAVA.awt 패키지 : OS에서 제공되는 컴포넌트를 자바에서 사용
 *  - JAVA.swing 패키지 : 자바에서 독립적으로 만든 컴포넌트를 사용
 *  
 *  두 경우의 차이점은: OS의 영향을 받는가 받지 않는가
 *  퍼포먼스는 AWT 가 더느리다. 왜냐면 OS 레벨 까지 메세지를 전달해야하기때문
 *  
 * @author 오재영
 *
 */
public class GUIEventTest {
	private JFrame frame;
	private JButton bt;
	private JTextField tf;
	
	
	//	익명 클래스	
	GUIEventTest(){
		frame = new JFrame(); // Frame 윈도우 창
		bt = new JButton("클릭"); //창위에 올라갈 Commpoenent 컨텐츠들.
		tf = new JTextField(30); // Text 입력 필드 Commpoenent
		Container c = frame.getContentPane();
		// 액자 뒤 종이에다가 어떻게 붙이냐? 액자 뒤 종이에 레이아웃을 설정함.
		c.setLayout(new FlowLayout()); //레이아웃 설정
		c.add(bt); // 컴포넌트를 붙이기
		c.add(tf);
		
		final int cnt=0;  
		
		//인자로 넣어진 감시자 객체는 감시 역할을 수행한다.
		//익명 클래스 이방법이 중첩 클래스에서 가장 많이 사용하는 방법이다. 재사용을 안하는 클래스인 경우는 이 방법을 권장함.
		bt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				tf.setText(cnt +"클릭되었습니다.");  
			}
			
		});
		
		frame.setSize(500, 200);
		frame.setVisible(true);
	}
	
	
	
	//로컬 클래스 활용법
	/*GUIEventTest(){
		frame = new JFrame(); // Frame 윈도우 창
		bt = new JButton("클릭"); //창위에 올라갈 Commpoenent 컨텐츠들.
		tf = new JTextField(30); // Text 입력 필드 Commpoenent
		Container c = frame.getContentPane();
		// 액자 뒤 종이에다가 어떻게 붙이냐? 액자 뒤 종이에 레이아웃을 설정함.
		c.setLayout(new FlowLayout()); //레이아웃 설정
		c.add(bt); // 컴포넌트를 붙이기
		c.add(tf);
		
		final int cnt=0; //생성자 안에서의 지역변수로 바꾸고 지역변수는 값을 초기화 하지 않으면 사용 불가. 
//		int cnt=0; //자바 8은 final을 생략해도 자동으로 final 화시켜준다.
		
		//로컬 클래스 재사용성이 제일 떨어진것이 로컬 클래스이다.
		class MyListener implements ActionListener{
			
			//inner class는 outer class 의 member 멤버 변수는를 에서 사용할 수 있다.
			@Override
			public void actionPerformed(ActionEvent e){
//				System.out.println("클릭되었습니다.");
				tf.setText(cnt +"클릭되었습니다."); // 메모리에서 없어진 heap영역의 변수는 메소드 종료 후 인스턴스가 사라지므로 논리적으로 오류가 있다. 
				// 때문에 만약 호출만 하기위해서는 위와같이 final 키워드로 선언하면 변수 값은 호출되나, final 연산자의 특성인 상수로 사용한다는 것이므로 연산이 불가하다.
				// 이러한 경우는 반드시 밖에 있는 class의 멤버 변수로 선언해줘야한다.
				
			}
			
			
		}
		
		//인자로 넣어진 감시자 객체는 감시 역할을 수행한다.
		bt.addActionListener(new MyListener()); // action 활성화 = 클릭 되었다.
		
		frame.setSize(500, 200);
		frame.setVisible(true);
	}*/
	
	
	
	//Nested class 활용방법
	
	//member class = inner class
	/*class MyListener implements ActionListener{
		int cnt=0;
		
		//inner class는 outer class 의 member 멤버 변수는를 에서 사용할 수 있다.
		JTextField tf;
			MyListener(JTextField tf){
				this.tf = tf;
			}
		@Override
		public void actionPerformed(ActionEvent e){
//			System.out.println("클릭되었습니다.");
			tf.setText(cnt++ +"클릭되었습니다.");
			
		}
		
		
	}*/
	
	
	
	
	/*GUIEventTest(){
		frame = new JFrame(); // Frame 윈도우 창
		bt = new JButton("클릭"); //창위에 올라갈 Commpoenent 컨텐츠들.
		tf = new JTextField(30); // Text 입력 필드 Commpoenent
		Container c = frame.getContentPane();
		// 액자 뒤 종이에다가 어떻게 붙이냐? 액자 뒤 종이에 레이아웃을 설정함.
		c.setLayout(new FlowLayout()); //레이아웃 설정
		c.add(bt); // 컴포넌트를 붙이기
		c.add(tf);
		
		//인자로 넣어진 감시자 객체는 감시 역할을 수행한다.
		bt.addActionListener(new MyListener()); // action 활성화 = 클릭 되었다.
		
		frame.setSize(500, 200);
		frame.setVisible(true);
	}*/
	
	
	// 이전 버전
	/*	GUIEventTest(){
		frame = new JFrame(); // Frame 윈도우 창
		bt = new JButton("클릭"); //창위에 올라갈 Commpoenent 컨텐츠들.
		tf = new JTextField(30); // Text 입력 필드 Commpoenent
		Container c = frame.getContentPane();
		// 액자 뒤 종이에다가 어떻게 붙이냐? 액자 뒤 종이에 레이아웃을 설정함.
		c.setLayout(new FlowLayout()); //레이아웃 설정
		c.add(bt); // 컴포넌트를 붙이기
		c.add(tf);
		
		//인자로 넣어진 감시자 객체는 감시 역할을 수행한다.
		bt.addActionListener(new MyListener(tf)); // action 활성화 = 클릭 되었다.
		
		frame.setSize(500, 200);
		frame.setVisible(true);
		
	}*/
	public static void main(String[] args) {
		new GUIEventTest();
		
//	TODO : click 할때 TextField에다가 출력을 하게 하기 위해서는....
	}
}