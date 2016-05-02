package com.my.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.Category;
import com.my.dto.Product;
import com.my.exception.AddException;

public class ProductDAOOracle implements ProductDAOInterface {

	String className = "oracle.jdbc.driver.OracleDriver";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	@Override
	public void add(Product product) throws AddException {
		// TODO 구현안함
	}

	@Override
	public List<Product> selectAll() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		List <Product> list=null;
		//sql 문장
		StringBuilder sql = null;
		
		try {
			//클래스 로드
			Class.forName(className);
			//DB 접속
			conn = DriverManager.getConnection(url, user, password);
			//sql 문장 송신
			sql = new StringBuilder("SELECT prod_no, prod_name, prod_price, category_no FROM product");
			list =new ArrayList<Product>();
			//결과 처리
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			while(rs.next()){
				Product pro = new Product();
				Category cat =new Category();
				pro.setProd_no(rs.getString(1));
				pro.setProd_name(rs.getString(2));
				pro.setProd_price(rs.getInt(3));
				pro.setProd_mf_dt(null);
				cat.setCategory_no(rs.getString(4));
				pro.setCategory(cat);
				//객체를 리스트에 담는다.
				list.add(pro);
			}
			
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connClose();
		}
		//결과 리턴
		return list;

	}

	@Override
	public List<Product> selectByName(String name) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		List <Product> list = null;
		//sql 문장
		StringBuilder sql = null;
		
		try {
			//클래스 로드
			Class.forName(className);
			//DB 접속
			conn = DriverManager.getConnection(url, user, password);
			list =new ArrayList<Product>();
			//product 이름 검색 sql
			sql = new StringBuilder("SELECT prod_no, prod_name, prod_price, category_no FROM product WHERE prod_name like '%");
			sql.append(name);
			sql.append("%'");
			System.out.println(sql.toString());
			//결과처리
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql.toString());
			
			while(rs.next()){
				Product pro = new Product();
				Category cat =new Category();
				pro.setProd_no(rs.getString(1));
				pro.setProd_name(rs.getString(2));
				pro.setProd_price(rs.getInt(3));
				pro.setProd_mf_dt(null);
				cat.setCategory_no(rs.getString(4));
				pro.setCategory(cat);
				//객체를 리스트에 담는다.
				list.add(pro);
			}
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connClose();
		}
			
		//결과 리턴
		return list;
	}

	@Override
	public Product selectByNo(String no) {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		//sql 문장
		StringBuilder sql = null;
		Product pro = new Product();
		Category cat =new Category();
		
		try {
			//클래스 로드
			Class.forName(className);
			//DB 접속
			conn = DriverManager.getConnection(url, user, password);
			//product 번호 검색 sql
			sql = new StringBuilder("SELECT prod_no, prod_name, prod_price, category_no FROM product WHERE prod_no='");
			sql.append(no);
			sql.append("'");
			//결과처리
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql.toString());
			
			rs.next();
			pro.setProd_no(rs.getString(1));
			pro.setProd_name(rs.getString(2));
			pro.setProd_price(rs.getInt(3));
			pro.setProd_mf_dt(null);
			cat.setCategory_no(rs.getString(4));
			pro.setCategory(cat);
			
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connClose();
		}
			
		//결과 리턴
		return pro;
	}

	@Override
	public Product update(Product product) {
		// TODO 구현안함
		return null;
	}

	@Override
	public boolean delete(String no) {
		// TODO 구현안함
		return false;
	}
	
	//close 메소드
	public void connClose(){
		
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
