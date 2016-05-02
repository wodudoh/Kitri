
class Join extends Thread{

	int sum;
	int to;
	int from;

	public Join(int from, int to) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = from; i <=to; i++){
			sum += i;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}


public class JoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Join j1 = new Join(1, 10);
		Join j2 = new Join(1, 100);
		
		j1.start();
		j2.start();
		try {
			j1.join(); // Waits for this thread to die.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try { 
			j2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1~10까지의 합 : " + j1.sum);
		System.out.println("11~22까지의 합 : " + j2.sum);

	}

}
