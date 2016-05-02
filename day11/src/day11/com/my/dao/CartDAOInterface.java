package day11.com.my.dao;

import java.util.Map;

import day11.com.my.dto.Product;

public interface CartDAOInterface {

		/**
		 * 카트에 추가할 메소드
		 * @param product
		 */
		public void add(Product product);
		
		/**
		 * 카트 전부를 출력하는 메소드
		 * @return Map(Product, Integer)
		 */
		public Map<Product, Integer> selectAll();
		
	
}
