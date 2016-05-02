package day13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 파일 목적지에 byte 단위로 쓰기

		String fileName = "d.dat";
		write(fileName);
		read(fileName);

	}

	public static void read(String fileName) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			int i = dis.readInt();
			long l = dis.readLong();
			double d = dis.readDouble();
			String str = dis.readUTF();
			System.out.println(i + ":" + l + ":" + d +":"+str);

		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dis != null)
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void write(String fileName) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream(fileName);
			dos = new DataOutputStream(fos);

			dos.writeInt(10);
			dos.writeLong(10L);
			dos.writeDouble(12.3);
			dos.writeUTF("HELLO");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (dos != null)
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			if (fos != null)
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
		}

	}

}
