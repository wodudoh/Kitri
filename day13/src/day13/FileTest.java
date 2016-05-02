package day13;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
	public static void main(String[] args) {
		
		
			try {
				printSubDirectory("",0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
	}
	/**
	 * 하위 디렉토리 파일 출력하기 sub변수는 현재 디렉토리의 절대위치값, 
	 * @param String
	 * @throws IOException
	 */
	public static void printSubDirectory(String sub, int level) throws IOException{
		File dir;
		dir = new File(".");
		//처음 디렉토리 경로
		String firstDirectoryPath= dir.getCanonicalPath();
		
//		System.out.println("=============받은값==========");
//		System.out.println(sub);
//		System.out.println("=============받은값==========");
		
		//인자의 값이 빈값이 아닌 경우
		if(!sub.equals("")){
			dir= new File(sub);
			
		}
		
		
		if(dir.isDirectory()){
			File [] subName = dir.listFiles();
			
			for(File a:subName){
				if(a.isDirectory()){
					for(int i=0 ; i<level;i++){
						System.out.print("\t");
					}
					level++;
					System.out.print("<DIR>"+a.getName());
					System.out.println();
				
					printSubDirectory(a.getCanonicalPath(), level);
				}else{
					for(int i=0 ; i<level;i++){
						System.out.print("\t");
					}

					System.out.print(a.getName());
					System.out.println();
					continue;
				}
				
				level--;
			}
			
			
		}
		
//		fileTest();
	}
	public static void fileTest() throws IOException{
		File dir;
		dir = new File("c:\\");
		dir = new File("."); // 현재 실행되는 경로 day13경로
		// System.out.println(dir.isDirectory()); //현재 만들어진 파일 타입 객체가 정보를 담고있는
		// 객체인가 묻는것
		if (dir.isDirectory()) {
			// 이름만 반환 해주는 메소드가 list메소드이다.
			String[] subName = dir.list();

			// for(String name : subName){
			// System.out.println(name);
			// }
			// 파일 유형, 크기, 등을 반환해줌.
			File[] lisf = dir.listFiles();
			SimpleDateFormat sDF = new SimpleDateFormat("yyyy-MM-dd a hh:mm");

			for (File a : lisf) {
				Date dt = new Date(a.lastModified());
				System.out.printf("%tY-%tm-%td %tp %tH:%tM:%tS", dt,dt,dt,dt,dt,dt,dt);
//				System.out.print(sDF.format(new Date(a.lastModified())));
				
				if (a.isDirectory()) {
					System.out.print("\t<DIR>\t");
				} else {
					System.out.print("\t\t");
				}

				System.out.print(a.length());
				System.out.print("\t" + a.getName());

				System.out.println();
				// System.out.println(a.length()+a.getName());

			}

		}
		

	}

}
