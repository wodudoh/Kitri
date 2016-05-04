package com.my;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**일괄 처리 연습 객체
 * @author 오재영
 *
 */
public class BatchTest {
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		String className = "oracle.jdbc.driver.OracleDriver";
		Statement stmt =null;
		try{
			Class.forName(className);
			
			String url=   "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "hr";
			String password = "hr";
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			for(int i=1; i<=10; i++){
				String sql = "INSERT INTO product(prod_no, prod_name, category_no) VALUES ('no"+i+"', 'nm"+i+"', 'F')";
//						stmt.executeUpdate(sql);
						stmt.addBatch(sql);
			}
			//한번에 추가하는것.
			stmt.executeBatch();
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			con.rollback();
			
		}
	}

}
