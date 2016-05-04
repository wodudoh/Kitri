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
import com.my.exception.DeleteException;
import com.my.exception.DuplicateKeyException;
import com.my.exception.FindException;
import com.my.sql.MyConnection;

public class ProductDAOOracle implements ProductDAOInterface {
	public static void main(String[] args) {
		ProductDAOOracle daoOracle = new ProductDAOOracle();
		Category c = new Category("F", null);
		Product product = new Product("p1", "n1", 100, "160131", c);
		try {
			daoOracle.add(product);
		} catch (AddException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void add(Product product) throws AddException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MyConnection.getConnection();
			String insertSQL = "INSERT INTO product(prod_no, prod_name, prod_price, prod_mf_dt, category_no) "
					+ " VALUES (?, ?, ? ,? ,? )";
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, product.getProd_no());
			pstmt.setString(2, product.getProd_name());
			pstmt.setInt(3, product.getProd_price());
			pstmt.setString(4, product.getProd_mf_dt());
			pstmt.setString(5, product.getCategory().getCategory_no());
			pstmt.executeUpdate();
		} catch (Exception e) {
			if (e instanceof SQLException) {
				SQLException se = (SQLException) e;
				if (se.getErrorCode() == 1) {
					throw new DuplicateKeyException("이미 존재하는 상품입니다.");
				}
			}
			throw new AddException(e.getMessage());
		} finally {
			MyConnection.closeConnection(con, pstmt, null);
		}
	}

	@Override
	public List<Product> selectAll() throws FindException {
		ArrayList<Product> list = new ArrayList<Product>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = com.my.sql.MyConnection.getConnection();
			// 4)SQL문장 송신
			String sql = "SELECT * FROM product";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // 5)결과 수신
			while (rs.next()) {
				Category c = new Category(rs.getString("category_no"), null);
				Product p = new Product(rs.getString("prod_no"), rs.getString("prod_name"), rs.getInt("prod_price"),
						rs.getString("prod_mf_dt"), c);
				list.add(p);
			}
			if (list.size() == 0) {
				throw new FindException("검색 결과가 없습니다.");
			}
		} catch (Exception e) {
			throw new FindException(e.getMessage());
		} finally {
			// 7)DB와 연결닫기
			MyConnection.closeConnection(con, stmt, rs);
		}
		return list;
	}

	@Override
	public List<Product> selectByName(String name) throws FindException {
		ArrayList<Product> list = new ArrayList<Product>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			// 4)SQL문장 송신
			String sql = "SELECT * FROM product WHERE prod_name LIKE '%" + name + "%'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // 5)결과 수신

			while (rs.next()) {
				Category c = new Category(rs.getString("category_no"), null);
				Product p = new Product(rs.getString("prod_no"), rs.getString("prod_name"), rs.getInt("prod_price"),
						rs.getString("prod_mf_dt"), c);
				list.add(p);
			}
		} catch (Exception e) {
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.closeConnection(con, stmt, rs);
		}
		return list;
	}

	@Override
	public Product selectByNo(String no) throws FindException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();
			// 4)SQL문장 송신
			String sql = "SELECT * FROM product WHERE prod_no='" + no + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql); // 5)결과 수신
			if (rs.next()) {
				Category c = new Category(rs.getString("category_no"), null);
				Product p = new Product(rs.getString("prod_no"), rs.getString("prod_name"), rs.getInt("prod_price"),
						rs.getString("prod_mf_dt"), c);
				return p;
			} else {
				throw new FindException("검색 결과가 없습니다.");
			}
		} catch (Exception e) {
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.closeConnection(con, stmt, rs);
		}
	}

	@Override
	public Product update(Product product) {
		String updateSQL = "UPDATE product SET ";
		boolean flag = false;
		if (product.getProd_name() != null) {
			flag = true;
			updateSQL += "prod_name='" + product.getProd_name() + "' ";
		}
		if (product.getProd_price() != 0) {
			if (flag) {
				updateSQL += ", ";
			}
			flag = true;
			updateSQL += "prod_price=" + product.getProd_price();
		}
		if (product.getProd_mf_dt() != null) {
			if (flag) {
				updateSQL += ", ";
			}
			flag = true;
			updateSQL += "prod_mf_dt='" + product.getProd_mf_dt() + "' ";
		}

		if (product.getCategory() != null) {
			if (flag) {
				updateSQL += ", ";
			}
			flag = true;
			updateSQL += "category_no='" + product.getCategory().getCategory_no() + "'";
		}
		if (!flag) {
			return product;
		}
		updateSQL += " WHERE prod_no=?";
		System.out.println(updateSQL);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(updateSQL);
			pstmt.setString(1, product.getProd_no());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyConnection.closeConnection(con, pstmt, null);
		}
		return product;
	}

	@Override
	public void delete(String no) throws DeleteException {
		Connection con=null;
		PreparedStatement pstmt = null;
		try {
			con = MyConnection.getConnection();
			String deleteSQL = "DELETE FROM product WHERE prod_no=?";
			pstmt = con.prepareStatement(deleteSQL);
			pstmt.setString(1, no);
			int rowcnt = pstmt.executeUpdate();
			
			// 예외가 발생 했을 때 예외 떠넘기기가 먼저수행
			if(rowcnt != 1){
				throw new DeleteException("삭제 실패");
			}
		}catch(Exception e){
			throw new DeleteException(e.getMessage());
			
		}finally {
			MyConnection.closeConnection(con, pstmt, null);
		}
	}

}
