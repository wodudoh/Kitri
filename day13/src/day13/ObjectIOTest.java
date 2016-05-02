package day13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.util.Date;
import java.util.Scanner;

import day11.com.my.dto.Employee;
import day11.com.my.dto.Manager;

public class ObjectIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("작업을 선택하시오 : 1-쓰기, 2-읽기, 3-종료");
		
		try {
			String line = br.readLine();
			String fileName = "o.ser";
			if(line.equals("1"))
			{
				write(fileName);
				
			}else if (line.equals("2")) {
				read(fileName);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void read(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
		// 파일에 저장된 객체 타입의 데이터를 역직렬화 해서 읽어오기
		ObjectInputStream ois = new ObjectInputStream( new FileInputStream(fileName));
		
		while(true){
			Object obj = ois.readObject();
			System.out.println(obj);
		}
		
	}

	public static void write(String fileName) {
		// 파일 목적지에 byte 단위의 쓰기
		FileOutputStream fos = null;

		// 객체 단위로 쓰기
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Date());
			oos.writeObject(new Employee("E1", "name1", "010", 1000));
			oos.writeObject(new Manager("M1", "manager1", "010", 2000, 20));

			
		} catch (ObjectStreamException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO: handle exception
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					// TODO: handle exception
				}

		}

	}

}
