import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * java Data Base Connectivity : 자바 프로그램을 통해 DB연결을 도와주는 라이브러리 
 * 1) JDBC 드라이버 설치
 * 2) JDBC 드라이버 클래스 로딩
 * 3) DB서버 연결
 * 4) SQL문을 송신
 * 5) 결과 수신
 * 6) 결과 처리
 * 7) DB와 연결닫기
 * 여기까지 네트워크 처리
 * C:\oraclexe\app\oracle\product\10.2.0\server\jdbc\lib 여기서 오라클 ojdbc.jar 파일 있는지 확인.
 * (ojdbc14_g.jar 개발용도로 디버깅용 메시지가 들어가있기 때문에 용량이 더 크다.)
 * OracleDriver.class 를 로드하면 DB 접속및 DB 사용값이 모두 static으로 초기화 될것임.
 * [방화벽 설정]
 * 우측 경로의 프로그램 허용하고, %SystemDrive%\oraclexe\app\oracle\product\10.2.0\server\BIN\oracle.exe
 * 포트번호 1521 열어줘야함.
 * 
 * @author 오재영
 *
 */
public class JDBCTest {

	public static void main(String[] args) {
		
		String className = "oracle.jdbc.driver.OracleDriver";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//2) JDBC드라이버 클래스 로딩
			Class.forName(className);
			/**
			 * jdbc:oracle:thin:@아이피주소:포트번호:서비스아이디
			 */
			String url ="jdbc:oracle:thin:@127.0.0.1:1521:XE";
//			String url ="jdbc:oracle:thin:@192.168.14.12:1521:XE";
			String user="hr";
			String password="hr";
			// 3)DB 서버 연결
			conn = DriverManager.getConnection(url, user, password);
			// 4)sql 문장 송신
			StringBuilder sql = new StringBuilder("SELECT employee_id, first_name, hire_date, salary FROM employees");
			stmt =conn.createStatement();
			//5) 결과수신
			rs = stmt.executeQuery(sql.toString());
			//6) 결과 처리
			while(rs.next()){
				int emp_id = rs.getInt("employee_id");
				String fName = rs.getString("first_name");
				java.sql.Date hire = rs.getDate("hire_date");
				int salary = rs.getInt(4);
				System.out.println(emp_id+":" + fName + ":" + hire+":" + salary);
			}
			sql = new StringBuilder("SELECT SUM(salary) From employees");
			rs = stmt.executeQuery(sql.toString());
			
			rs.next();
			int sum = rs.getInt(1);
			System.out.println(sum);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			7) DB와 연결닫기
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(stmt!=null){
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
				if(conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
		}
		
	}

}
