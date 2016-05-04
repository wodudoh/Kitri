package com.my;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class TansactionTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		String className = "oracle.jdbc.driver.OracleDriver";
		PreparedStatement pstmt =null;
		try{
			Class.forName(className);
			
			String url=   "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "hr";
			String password = "hr";
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			String sql ="INSERT INTO product(prod_no, prod_name, prod_price, category_no) VALUES('test1', 'n1', 100, 'F')";
			
			
			String sql12 ="INSERT INTO product(prod_no, prod_name, prod_price, category_no) VALUES('test111111111111', 'n1', 100, 'F')";
			
			pstmt = con.prepareStatement(sql);
			pstmt.executeQuery();
			
			pstmt = con.prepareStatement(sql12);
			pstmt.executeQuery();
			//첫번째와 두번째가 정상 처리 되야지만 commit 되고, 두문장 중에 하나라도 에러가 있으면 rollback 수행.
			con.commit();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			con.rollback();
			
		}

	}

}
