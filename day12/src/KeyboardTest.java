import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * IO를 하기위해 InputStream과 Reader 실습 클래스
 * 
 * @author 오재영
 *
 */
public class KeyboardTest {

	public static void main(String[] args) {
		InputStream k = System.in;
		/*
		 * try { int readValue = k.read(); System.out.println(readValue+" : "+
		 * (char)readValue); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		// 가공을 위한 InputStreamReader
		InputStreamReader isr = new InputStreamReader(k);
		try {
			int readValue = -1;
			while ((readValue = isr.read()) != -1) {
				System.out.println(readValue + " : " + (char) readValue);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// 윈도우에서 키보드로 입력하는 것을 중지한다 알려주는게 -1 윈도우는 ctr+z / unix는 ctr+c
	}

}
