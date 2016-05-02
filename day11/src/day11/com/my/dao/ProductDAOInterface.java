package day11.com.my.dao;

import java.util.List;

import day11.com.my.Exception.AddException;
import day11.com.my.dto.Product;

public interface ProductDAOInterface {
	
	/**
	 * 상품을 추가하는 메소드
	 * @param product
	 * @throws AddException
	 */
	void add(Product product) throws AddException;
	/**
	 * 모든 상품 정보를 검색해주는 메소드
	 * @return List<%Product>
	 */
	List<Product> selectAll();
	
	/**
	 * 해당 상품의 이름을 검색하는 메소드
	 * @param name
	 * @return List<%Product>
	 */
	List<Product> selectByName(String name);
	
	/**
	 * 해당 상품의 상품번호를 검색하는 메소드
	 * @param no
	 * @return Product 
	 */
	Product selectByNo(String no);
	
	/**
	 * 상품 정보를 수정하는 메소드
	 * @param product
	 * @return Product
	 */
	Product update(Product product);
	/**
	 * 상품 정보를 삭제하는 메소드
	 * @param no
	 * @return boolean
	 */
	boolean delete(String no);
}