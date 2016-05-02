import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class SystemTest {
	
	public static void main(String[] args) {
//		System.arraycopy(src, srcPos, dest, destPos, length);
//		System.gc(); //요구하는 요청하는 메세지
		
		InputStream is = System.in;
		try {
			//표준 입력 방식
			int readValue = is.read();
			System.out.println(readValue);
			
			//반복문 처리시간을 알아보자
			long before = System.currentTimeMillis();
			for(long i=0; i<100000000000L; i++){
				
			}
			long after = System.currentTimeMillis();
			System.out.println("반복문 처리시간: "+(after-before));
			Date aTime = new Date(after);
			Date bTime = new Date(before);
			System.out.println("처리전 시간: " + bTime);
			System.out.println("처리후 시간:" + aTime);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
