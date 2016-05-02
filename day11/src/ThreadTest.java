import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import day11.com.my.dto.Product;

class Second extends Product implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 현재 시간 출력하기

		String pattern = "hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String nowStr = sdf.format(new Date());
		
		for(int i=1; i<=10; i++){
			System.out.println(nowStr);
			try{
				Thread.sleep(1000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}

	}

}

class First extends Thread {
	public void run() {

		Thread t = Thread.currentThread();
		for (int i = 0; i < 100; i++) {
			System.out.println(t.getName() + ":" + i);
		}
	}

}

/**
 * 1부터 100까지 출력하자
 * 
 * @author 오재영
 *
 */
class Normal {
	public void run() {

		Thread t = Thread.currentThread();
		for (int i = 0; i < 100; i++) {
			System.out.println(t.getName() + ":" + i);
		}
	}
}

/**
 * Thread를 테스트할 목적으로 만든 클래스입니다.
 * 
 * @author 오재영
 * 
 *
 */
public class ThreadTest {

	public void test() {

		Thread t = Thread.currentThread();
		System.out.println(t.getName()); // 메인 메소드를 호출 해주는 Thread가 누구인지 알아본것.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Thread t = Thread.currentThread(); System.out.println(t.getName());
		 * // 메인 메소드를 호출 해주는 Thread가 누구인지 알아본것.
		 */
		ThreadTest test = new ThreadTest();
		test.test();

		// main 쓰레드가 한다.
		Normal normal = new Normal();
		normal.run();

		// first 쓰레드가 동작하는 것을 예상할수있음
		First first = new First();
		// first.run();
		first.start();

		First one = new First();
		First two = new First();

		one.start();
		two.start();

		Second s = new Second();
		Thread three = new Thread(s);
		three.start();

		System.out.println("END OF MAIN!");

	}

}
