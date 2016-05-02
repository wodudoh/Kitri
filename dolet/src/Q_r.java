
/**
 * 두 자연수를 입력으로 받아 첫 번째 수를 두 번째 수로 나눈 몫과 나머지를 구하는 프로그램
 * @author Administrator
 *
 */
import java.util.Scanner;
public class Q_r {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a/b +" "+ a%b);
	}

}
