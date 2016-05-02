package day4;

import java.util.Scanner;

public class KeyboardTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in) ; //reference type local variable
		
		
		String	inputValue;

//		do{
//			inputValue = sc.nextLine();
//			System.out.println('\t'+inputValue+"를 입력했습니다.");
//			
//		} while(!inputValue.equals("quit"));
//		
		
		
		
		
		while(!(inputValue = sc.nextLine()).equals("quit")){
			
			System.out.println('\t'+inputValue+"를 입력했습니다.");
			
		}
		
		System.out.println("프로그램을 종료 합니다.");
		
	}

}
