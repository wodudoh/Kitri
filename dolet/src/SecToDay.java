
/**
 * 
 * 초(second)가 입력으로 주어진다.
 * 
 * 이 를 몇 날 몇 시간 몇 분 몇 초 인지를 변경하는 프로그램을 작성하시오.
 * 
 * @author Administrator
 *
 */

import java.util.Scanner;
public class SecToDay {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		final long input = sc.nextLong();
		
		int sec=0, min=0, time=0, day=0; 
		
		if(0 < input && input < 60){
			sec=(int)input;
		}
		else if(input < 3600){
			min = (int)(input/60);
			sec = (int)(input%60);
		} // 분까지 처리완료
		else if(input < 86400){
			time = (int)(input/3600);
			min = (int)(input/60)%60;
			sec = (int)(input%60);
		}
		else
		{
			day = (int)(input/86400);
			time = (int)((input/3600)%24);
			min = (int)((input/60)%60);
			sec = (int)(input%60);
		}
		
		System.out.println(day +" " + time+ " "+ min+" "+sec);
	}

}
