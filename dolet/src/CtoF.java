
/**
 * 화씨 온도 구하기 = 9 / 5 * 섭씨온도 + 32
 *
 * @author Administrator
 *
 */

import java.util.Scanner;
public class CtoF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		System.out.println(String.format("%.1f", (a*9.0/5.0)+32.0));
	}

}
