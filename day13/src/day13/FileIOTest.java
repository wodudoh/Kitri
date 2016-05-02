package day13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//	파일에 쓰기
		String fileName = "b.txt"; //1. 목적지 Destination
		FileOutputStream fos = null; // 노드스트림선택:byte단위
		
		try {
			fos = new FileOutputStream(fileName);
			fos.write(65); // 숫자 1값이 파이에 저장되도록 완성
			
			//가 라는 단어를 출력하기위해 3byte 가 필요하다
			fos.write(234);
			fos.write(176);
			fos.write(128);
			
			//한번에 여러단어를 넣기위해서 byte 배열에 String.getBytes를 이용할 수 있다.
			byte [] bs = "나다라마".getBytes();
			fos.write(bs);
			 
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 문자 단위로 파일저장을 처리하기 위한 fw변수
		FileWriter fw = null;
		try {
			
			fw = new FileWriter("c.txt", true);
			// write는 버퍼에 우선적으로 채우기만 한다.
			fw.write('1');// 숫자 1값이 저장
			fw.write('가');// 숫자 1값이 저장
			fw.write("나다라마");// 숫자 1값이 저장
			
			//flush(즉각흘려보내라) 버퍼의 내용을 목적지에 흘려보내라 하는것. 버퍼가 꽉채워지면 자동flush되기도함.
			fw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw !=null) //객체가 null이 아닐경우
			try {
				fw.close(); // 자원이나 목적지와 연결해제. 이때 먼저 flush메서드 자동 호출됨.
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(NullPointerException e){ //null이면 익셉션처리
				e.printStackTrace();
			}
		}
		
		
	}

}
