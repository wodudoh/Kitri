package day14;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

class ServerThread extends Thread {
	InputStream is;
	DataInputStream dis; // 필터 스트림 이것저것 가공해서 사용
	// //서버쪽에서 서버로 출력해주기 위함.
	DataOutputStream dos;
	Socket s;
	String client; // 접속한 클라이언트 IP 어드레스
	Vector<ServerThread> list;

	public ServerThread(Socket s, Vector<ServerThread> list) throws IOException {
		this.s = s;
		this.list = list;
		InetAddress clientInfo = s.getInetAddress();
		client = clientInfo.getHostName();
		is = s.getInputStream();
		dis = new DataInputStream(is);
		dos = new DataOutputStream(s.getOutputStream());
		broadCast(client + "접속했습니다.");

	}

	public void broadCast(int sendData) {
		for (int i = 0; i < list.size(); i++) {
			ServerThread t = list.get(i);
			try {
				t.dos.writeInt(sendData);
			} catch (IOException e) {
				// 소켓상에서 한번 문제가 생긴 패킷은 복구가 불가능 하므로 지워버림.
				list.remove(i);
			}

		}

	}

	public void broadCast(String sendData) {
		for (int i = 0; i < list.size(); i++) {
			ServerThread t = list.get(i);
			try {
				t.dos.writeUTF(sendData);
			} catch (IOException e) {
				list.remove(i);
			}

		}
	}

	@Override
	public void run() {

		try {
			while (true) {
				// int readI = dis.readInt();
				String readS = dis.readUTF();
				if (readS.equals("quit")) {
					break;
				}
				broadCast(readS);
			}
		} catch (IOException e) {

		} finally {

			if (s != null) {
				try {
					s.close();
					System.out.println("클라이언트가 접속해제했습니다.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

public class TCPServerMultiThread {
	ServerSocket ss;
	Socket s;

	// 새로운 쓰레드가 할일

	int port = 5432;
	Vector<ServerThread> list = new Vector<ServerThread>();

	// TODO 생성자에서 반드시 소켓을 생성해야함.
	TCPServerMultiThread() {
		try {
			// 포트 열기
			ss = new ServerSocket(port);

			while (true) {
				// 클라이언트접속 기다리기
				s = ss.accept();
				// 접속한 클라이언트 ip값
				ServerThread t = new ServerThread(s, list);
				list.add(t);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();

		} // 0~65535 가능 0~1023는 예약포트;

	}

	public static void main(String[] args) {
		new TCPServerMultiThread();
	}

}
