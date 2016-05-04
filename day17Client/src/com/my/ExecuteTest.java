package com.my;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExecuteTest {
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		System.out.print("SQL구문을 입력하세요:");
		String sql = sc.nextLine();
		Connection con=null;
		Statement stmt = null;
		String className = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(className);
		
			//3)DB서버에 연결
			String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user="hr";
			String password="hr";			
			con = DriverManager.getConnection(url,user,password);
			stmt = con.createStatement();
			boolean isQuery = stmt.execute(sql);
			if(isQuery){
				ResultSet rs = stmt.getResultSet();
				System.out.println("검색결과");
				while(rs.next()){
					System.out.println(rs.getString(1));
				}				
			}else{
				int rowcnt = stmt.getUpdateCount();
				System.out.println("처리건수:" + rowcnt);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
