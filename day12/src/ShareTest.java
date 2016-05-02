
/**
 * 쉐어 객체
 * 
 * @author 오재영
 *
 */
class Share {
	int data;

	void push() {
		for (int i = 0; i < 1000; i++) {
			synchronized (this) { // 공유 객체가 현재 객체이므로 this를 사용
				notify();
				System.out.print("before push : " + data);
				data++; // 1)값1증가, 2)변수에 대입
				System.out.println(" After push : " + data);
			}
			
		}
	}

	void pop() {
		for (int i = 0; i < 1000; i++) {
			synchronized (this) {

				System.out.print("before pop : " + data);
				if (data == 0) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				data--;
				System.out.println(" After pop : " + data);
			}
		}
	}

}

/**
 * 스택에 하나씩 더할 수 있음.
 * 
 * @author 오재영
 *
 */
class Push extends Thread {
	Share share;

	public Push(Share share) {
		this.share = share;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		share.push();

	}

}

/**
 * pop 스택에서 하나 빼내기
 * 
 * @author Administrator
 *
 */
class Pop extends Thread {
	Share share;

	public Pop(Share share) {
		this.share = share;
	}

	@Override
	public void run() {
		try {
			share.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

/**
 * Thread를 이용한 Stack 구조 구현
 * 
 * @author 오재영
 *
 */
public class ShareTest {

	public static void main(String[] args) {

		Share s = new Share();
		Push push = new Push(s);
		Pop pop = new Pop(s);

		push.start();
		pop.start();

	}

}
