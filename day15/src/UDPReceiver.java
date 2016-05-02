import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {
	public static void main(String[] args) throws IOException {
		
		
		DatagramSocket socket = new DatagramSocket(5001);
		for(int i = 0;i<3;i++){
			
		byte[] buf =new byte[100];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);
		System.out.println(new String(buf));
		}
		socket.close();
	}

}
