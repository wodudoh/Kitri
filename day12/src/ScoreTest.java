import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.SliderUI;


/**
 * scores.txt파일의 사원들 사내교육평가 점수를 구하시오. 각학생의 이름과 평균을 출력하시오. 단 시험미응시인경우 0점으로 변환하여
 * 계산한다. e.g)구엘지:87::66 ==> 평균은 51.0이다
 */

class ScoreDTO{
	
	String name;
	int dbScore;
	int javaScore;
	int webScore;
	double avg;
	
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	int sum;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDbScore() {
		return dbScore;
	}
	public void setDbScore(int dbScore) {
		this.dbScore = dbScore;
	}
	public int getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	public int getWebScore() {
		return webScore;
	}
	public void setWebScore(int webScore) {
		this.webScore = webScore;
	}
	
}


public class ScoreTest {

	public static void main(String[] args) throws FileNotFoundException {

		FileReader fr = new FileReader("scores.txt"); // File을 문자하나씩 얻기위한 객체
		BufferedReader br = new BufferedReader(fr); // BufferedReader로 한줄 한줄 얻기위한 객체
		ScoreDTO sDto = null;
		List<ScoreDTO> sList = new ArrayList<ScoreDTO>();
		
		try {
			String str = br.readLine(); 
			while ((str = br.readLine()) != null) {
				String[] splitedData = str.split("\\:"); // 구분자로 뽑은 split 성적

				//List 에 담을 객체 생성
				sDto=new ScoreDTO();
				
				// TODO:arrayList에 insert 배열 최대 공간 4
				for (int i = 0; i < splitedData.length; i++) { 
					
					
					//TODO:공백 처리
					if(splitedData[i].equals("")){
						splitedData[i]="0";
					}
					
					//TDOO: ScoreDTO 객체에 insert
					switch(i)
					{
					case 0: 
						sDto.setName(splitedData[i]);
						break;
					case 1:
						sDto.setDbScore(Integer.parseInt(splitedData[i]));
						break;
					case 2:
						sDto.setJavaScore(Integer.parseInt(splitedData[i]));
						break;
					case 3:
						sDto.setWebScore(Integer.parseInt(splitedData[i]));
						break;
					}
					
				}
				//TODO 합계 계산
				sDto.setSum(sDto.getDbScore()+sDto.javaScore+sDto.webScore);
				
				//TODO 평균 계산
				sDto.setAvg(Double.parseDouble(String.format("%.1f", sDto.sum/3.0)));
				
				//TODO ArrayList Insert
				sList.add(sDto);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close(); // BufferReader 닫아 줘야함 순서는 오픈과 다르게 역순
				fr.close();// 파일은 반드시 오픈후 닫아 줘야한다. 그렇지 않으면 메모리 누수가 발생함.
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//TODO:출력
		
		System.out.println("========= <정렬이전 data>=========");
		for(int j=0;j<sList.size();j++){
			//StringBuilder 사용하자
			StringBuilder sb = new StringBuilder();
			sb.append(sList.get(j).getName()+":");
			sb.append(sList.get(j).getDbScore()+":");
			sb.append(sList.get(j).getJavaScore()+":");
			sb.append(sList.get(j).getWebScore()+":");
			sb.append(sList.get(j).getSum()+":");
			sb.append(sList.get(j).getAvg());
			System.out.println(sb);
		}
		
		System.out.println("========= <정렬 이후 data>=========");
		
		//정렬
		//TODO : AVG 불러오기
		//iterator 사용해보자
		
		while(){
			StringBuilder sb=null;
			
			System.out.println(sb);
		}
		
		//TODO : SWAP
		
		//TODO : 정렬 완료 출력
		
		
		
	}

}
