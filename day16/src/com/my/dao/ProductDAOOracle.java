package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.Category;
import com.my.dto.Product;
import com.my.exception.AddException;
import com.my.exception.DuplicateKeyException;
import com.my.exception.FindException;
import com.my.sql.MyConnection;

public class ProductDAOOracle implements ProductDAOInterface {

	@Override
	public void add(Product product) throws AddException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sql = null;
		System.out.println(product.getProd_no()+product.getProd_name()+product.getProd_price() + product.getCategory().getCategory_no());
		try {
			conn = MyConnection.getConnection();

			sql.append("INSERT INTO product");
			sql.append("(prod_no, prod_name, prod_price, category_no)");
			sql.append(" VALUES(?,?,?,?)");

			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, product.getProd_no());
			pstmt.setString(2, product.getProd_name());
			pstmt.setString(3, String.valueOf(product.getProd_price()));
			pstmt.setString(4, product.getCategory().getCategory_no());

			int result = pstmt.executeUpdate();

			if (result != 0) {
				throw new AddException();
			}

		} catch (Exception e) {
			if (e instanceof SQLException) {
				SQLException se = (SQLException) e;
				if (se.getErrorCode() == 1) {
					throw new DuplicateKeyException("이미 존재하는 상품입니다. 다른 상품코드를 입력하세요");
				}
			}
		} finally {
			MyConnection.closeConnection(conn, pstmt, null);

		}

	}

	@Override
	public List<Product> selectAll() throws FindException {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<Product> list = null;
		StringBuilder sql = null;
		try {
			conn = com.my.sql.MyConnection.getConnection();
			// sql 문장 송신
			sql = new StringBuilder("SELECT prod_no, prod_name, prod_price, category_no FROM product");
			list = new ArrayList<Product>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());
			// 결과 처리
			while (rs.next()) {
				Product pro = new Product();
				Category cat = new Category();
				pro.setProd_no(rs.getString(1));
				pro.setProd_name(rs.getString(2));
				pro.setProd_price(rs.getInt(3));
				pro.setProd_mf_dt(null);
				cat.setCategory_no(rs.getString(4));
				pro.setCategory(cat);
				// 객체를 리스트에 담는다.
				list.add(pro);
			}

		} catch (Exception e) {
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.closeConnection(conn, stmt, rs);
		}
		// 결과 리턴
		return list;

	}

	@Override
	public List<Product> selectByName(String name) {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<Product> list = null;
		StringBuilder sql = null;
		// sql 문장

		try {
			// Connection 얻어오기
			conn = com.my.sql.MyConnection.getConnection();
			list = new ArrayList<Product>();
			// product 이름 검색 sql
			sql = new StringBuilder(
					"SELECT prod_no, prod_name, prod_price, category_no FROM product WHERE prod_name like '%");
			sql.append(name);
			sql.append("%'");
			// 결과처리
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {
				Product pro = new Product();
				Category cat = new Category();
				pro.setProd_no(rs.getString(1));
				pro.setProd_name(rs.getString(2));
				pro.setProd_price(rs.getInt(3));
				pro.setProd_mf_dt(null);
				cat.setCategory_no(rs.getString(4));
				pro.setCategory(cat);
				// 객체를 리스트에 담는다.
				list.add(pro);
			}
		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {

		} finally {
			MyConnection.closeConnection(conn, stmt, rs);

		}

		// 결과 리턴
		return list;
	}

	@Override
	public Product selectByNo(String no) throws FindException {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		StringBuilder sql = null;

		Product pro = new Product();
		Category cat = new Category();

		try {
			conn = com.my.sql.MyConnection.getConnection();
			// product 번호 검색 sql
			sql = new StringBuilder(
					"SELECT prod_no, prod_name, prod_price, category_no FROM product WHERE prod_no=UPPER('");
			sql.append(no);
			sql.append("')");
			// 결과처리
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());

			if (rs != null) {
				rs.next();
				pro.setProd_no(rs.getString(1));
				pro.setProd_name(rs.getString(2));
				pro.setProd_price(rs.getInt(3));
				pro.setProd_mf_dt(null);
				cat.setCategory_no(rs.getString(4));
				pro.setCategory(cat);

			} else {
				throw new FindException("검색 결과가 없습니다. 강제 던진익셉션");
			}

		} catch (Exception e) {
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.closeConnection(conn, stmt, rs);
		}

		// 결과 리턴
		return pro;
	}

	@Override
	public Product update(Product product) {
		
		// SQL 문장
		// UPDATE product SET prod_name='코오오피', prod_price=30000, category_no='C' WHERE prod_no='C004'
		String updateSQL;
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		StringBuilder sql = new StringBuilder("UPDATE product SET ");
		boolean flag =false;

		Product pro = new Product();
		Category cat = new Category();

		try {
			if (product.getProd_name()!= null) {
				flag = true;
				sql.append("prod_name=");
				sql.append(product.getProd_name());
				
			}else if(product.getProd_price()!=0){
				if(flag){
					sql.append(", ");
				}
				sql.append("prod_price=");
				sql.append(product.getProd_price());
				flag=true;
				
			}else if(product.getProd_mf_dt()!=null){
				if(flag){
					sql.append(", ");
				}
				sql.append("prod_mf_dt=");
				sql.append(product.getProd_mf_dt());
			}
			conn = com.my.sql.MyConnection.getConnection();
			
			
		}catch(Exception e){
			
			System.out.println("수정시 오류가 발생 하였습니다.");
			
		}
		
		
		
		
		// TODO 구현안함
		return null;
	}

	@Override
	public boolean delete(String no) {
		// TODO 구현안함
		return false;
	}

}
