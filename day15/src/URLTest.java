import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;



public class URLTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.naver.com");
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb= new StringBuilder();
		
//		while((sb.)!= null)
//		sb.append("");
		String line = "";
		
		FileWriter fw = null;
		fw = new FileWriter("test.html");
		
		
//		while(sb.toString()!=null){
		while((line = br.readLine()) != null){
//		sb.append(br.readLine());
//			fw.write(sb.toString());
			fw.write(line);
		}

	}

}
