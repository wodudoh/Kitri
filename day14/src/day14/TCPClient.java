package day14;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

class TCPClient {

	Socket s;
	OutputStream os;
	DataOutputStream dos;
//	String host = "127.0.0.1";
	String host = "192.168.14.27"; // 강사님서버쪽 테스트
//	String host = "192.168.14.12"; // 아롬형서버쪽 테스트
	int port = 5432;

	TCPClient() {
		try {
			s = new Socket(host, port); // 서버에 접속하기
			// TODO : 클라이언트 OutputStream 얻기
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			// //스트림에 출력
			// os.write(49); //문자1 값
			dos.writeInt(1);// 숫자 1을 출력해주는.....
			dos.writeUTF("오재영. HELLO");
			/*for(int i=1; i<=10;i++){
				dos.writeInt(i);
				dos.writeUTF("HELLO");
			}*/
			//TODO 키보드 자원으로부터 입력을 받기 - "quit"입력시 종료
			Scanner keyboard = new Scanner(System.in);
			String keyboardValue="";
			int i = 1;
			
			do{
				keyboardValue=keyboard.nextLine();
				dos.writeInt(i);
				dos.writeUTF(keyboardValue);
				i++;
			}
			while(!keyboardValue.equals("quit"));
				
			
			// set no delay, set timeOut

		}		
		catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (ConnectException e) {
			System.out.println("서버와 연결할 수 없습니다. ㅋ");
		//서버가 강제 종료 되었을 때 익셉션이 발생 할 수 있다.
		}catch(SocketException e){
			System.out.println("서버가 응답하지 않아 연결을 종료합니다.");
		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			// 클라이언트에서도 close()메소드 선언 하지 않을시에 socket exception을 발생 시킨다.
			if (s != null) {

				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {

		new TCPClient();

	}

}
