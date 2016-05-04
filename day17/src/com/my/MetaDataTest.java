package com.my;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MetaDataTest {
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
			DatabaseMetaData dbMeta = con.getMetaData();
			System.out.println(dbMeta.getDatabaseProductName());
			stmt = con.createStatement();
			boolean isQuery = stmt.execute(sql);
			if(isQuery){
				ResultSet rs = stmt.getResultSet();
				ResultSetMetaData rsMeta = rs.getMetaData();
				System.out.println("검색컬럼수:" + rsMeta.getColumnCount());
				//메타데이터를 통해서얻어오는 컬렴명은 무조건 대문자이다.
				System.out.println("검색컬럼명:" + rsMeta.getColumnName(1));				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
