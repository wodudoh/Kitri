import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 스코어 처리하는 클래스
 * @author 오재영
 *
 */
class ScoreDAO{
	
	FileReader fr1;
	BufferedReader br2;
	int sum;
	double avg;
	
	ScoreDAO(){
		try {
			OpenFile();
			CloseFile();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void OpenFile() throws FileNotFoundException {
		// TODO Auto-generated method stub
		fr1 = new FileReader("scores.txt"); // File을 문자하나씩 얻기위한 객체
		br2 = new BufferedReader(fr1); // BufferedReader로 한줄 한줄
		
	}

	
	private void CloseFile() throws IOException {
		// TODO Auto-generated method stub
		br2.close();
		fr1.close();
		
	}
	
}
/**
 * 스코어의 DTO 객체
 * @author 오재영
 *
 */
//class ScoreDTO{
//	private String name;
//	private int dbScore;
//	private int javaScore;
//	private int webScore;
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getDbScore() {
//		return dbScore;
//	}
//	public void setDbScore(int dbScore) {
//		this.dbScore = dbScore;
//	}
//	public int getJavaScore() {
//		return javaScore;
//	}
//	public void setJavaScore(int javaScore) {
//		this.javaScore = javaScore;
//	}
//	public int getWebScore() {
//		return webScore;
//	}
//	public void setWebScore(int webScore) {
//		this.webScore = webScore;
//	}
//	
//	
//}

public class Score2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
