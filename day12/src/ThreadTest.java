

class Sound extends Thread{
	public void run(){
		while(true){
			System.out.println("소리");
		}
	}
}
class Caption extends Thread{
	public void run(){
		while(true){
			System.out.println("자막");
		}
	}
}
class Video extends Thread{
	public void run(){
		while(true){
			System.out.println("동영상");
		}
	}
}
/**
 * Thread 연습을 위한 테스트 클래스
 * 1. 마치 각각의 쓰레드가 동시에 돌아가는 것처럼 바꿔라>> extends 키워드로 Thread를 상속받으면 된다.
 * 2. Runnable 방식으로 하는 거.
 * @author 오재영
 *
 */
public class ThreadTest {
	public static void main(String[] args) {
		Video v = new Video();
//		v.run();
		Caption c = new Caption();
		Sound s = new Sound();
//		s.run();
		v.start();
		s.start();
		c.start();
	}
}
