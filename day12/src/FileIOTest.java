import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 파일 입출력을 위한 클래스
 * 
 * @author 오재영
 *
 */
public class FileIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "C:\\a.txt"; 
		// Eclipse가 실행할때 console창에서의 java -cp bin FileIOTest
		// 와 동일하다 그러므로 패키지의 유무상관없이 반드시  
		FileInputStream fis;

		try {
			fis = new FileInputStream(fileName);
			int readValue = -1;
			/*int readValue = -1;
			while ((readValue = fis.read()) != -1) {
				System.out.print(readValue + ":" + (char)readValue + " ");
			}*/
			byte[] arr = new byte[1024]; // 한번에 1KB씩 읽어라.
			int readCnt = fis.read(arr);
			for(int i=0; i<readCnt ; i++){
				readValue = arr[i];
			System.out.print(readValue + " : " + (char)readValue + " ");
			}
		} catch (FileNotFoundException e) { // 부모 익셉션 catch는 먼저, 자식 익셉션은 나중에 해야함.
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
