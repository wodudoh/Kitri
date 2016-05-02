package day14;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	ServerSocket ss;
	Socket s;
	InputStream is;
	DataInputStream dis; // 필터 스트림 이것저것 가공해서 사용
	int port = 5432;

	// TODO 생성자에서 반드시 소켓을 생성해야함.
	TCPServer() {
		try {
			// 포트 열기
			ss = new ServerSocket(port);

			while (true) {
				// 클라이언트접속 기다리기
				s = ss.accept();
				// 접속한 클라이언트 ip값
				String client; 
				InetAddress clientInfo=s.getInetAddress();
				client = clientInfo.getHostName();
				System.out.println(client+" 접속했습니다.");

				is = s.getInputStream();
				dis = new DataInputStream(is);
				try {
					do {
						int readI = dis.readInt();
						String reads = dis.readUTF();
						if (reads.equals("quit")) {
							break;
						}
						System.out.println(client+"보내준 자료 : " + readI + "," + reads);
					} while (true);

				} catch (Exception e) {
					//소켓 익셉션 , EOF 익센션 전부를 무시하기위해 exception을 캐시 
				}

				s.close();
				System.out.println("클라이언트가 접속해제했습니다.");

				// try catch는 반복문 에서 해야할지 밖에서 해야할지 고민을 해야한다..
			}
		} catch (IOException e) {
			e.printStackTrace();

		} // 0~65535 가능 0~1023는 예약포트;

	}

	public static void main(String[] args) {
		new TCPServer();
	}

}
