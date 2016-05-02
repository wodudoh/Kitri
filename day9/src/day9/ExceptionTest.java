package day9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	public static void test(int i){
		try {
			
			int result = 99 / i;
			System.out.println("99/"+i+"="+ result);
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("0보다 큰 정수를 입력하세요.");
		}
	}
	public static void main(String[] args) throws Exception {
		int i = 0;
		Scanner sc= new Scanner(System.in);
		
		try {
			
			System.out.print("입력하세요.");
			i = sc.nextInt();		
			test(i);
			
		} catch(InputMismatchException e){
			System.out.println("숫자를 입력하지 않았으므로, 숫자를 1로 대신 입력하겠습니다.");
			i=1;
		}
	}
}
