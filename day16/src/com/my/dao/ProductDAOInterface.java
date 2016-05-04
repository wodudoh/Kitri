package com.my.dao;

import java.util.List;

import com.my.dto.Product;
import com.my.exception.AddException;
import com.my.exception.DeleteException;
import com.my.exception.FindException;

public interface ProductDAOInterface {
	void add(Product product) throws AddException;
	/**
	 * 전체상품검색한다. 
	 * @return
	 */
	List<Product> selectAll() throws FindException;
	List<Product> selectByName(String name)throws FindException;
	Product selectByNo(String no)throws FindException;
	Product update(Product product);
	void delete(String no)throws DeleteException;
}