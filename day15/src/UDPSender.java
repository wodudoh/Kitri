import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * udp 보내는 Server역할 수행한다.
 * 
 * @author 오재영
 */
public class UDPSender {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		for (int i = 1; i <= 3; i++) {
			String data = "메시지";
			DatagramPacket packet = new DatagramPacket(data.getBytes(),
					data.length(),
					new InetSocketAddress("localhost", 5001));
			socket.send(packet);
		}
		if(socket != null)
		socket.close();
		
	}

}
