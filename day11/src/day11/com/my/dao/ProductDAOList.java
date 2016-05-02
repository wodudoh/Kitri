package day11.com.my.dao;

import java.util.ArrayList;
import java.util.List;

import day11.com.my.Exception.AddException;
import day11.com.my.Exception.DuplicateKeyException;
import day11.com.my.dto.Product;

public class ProductDAOList implements ProductDAOInterface {

	List<Product> productList = new ArrayList<Product>();
	
	@Override
	public void add(Product product) throws AddException {
		// TODO Auto-generated method stub 
		
		if(productList.contains(product)){
			throw new DuplicateKeyException();
		}
		productList.add(product);
	}
	
	public ProductDAOList() {
		this.productList = new ArrayList<Product>(5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		
		if(!productList.isEmpty()){
			return productList;
		}
		return null;
	}
	
	@Override
	public List<Product> selectByName(String name) {
		// TODO Auto-generated method stub
		
		
				
		
		return null;
	}

	@Override
	public Product selectByNo(String no) {
		// TODO Auto-generated method stub
		
		Product p = new Product();
		p.setProd_no(no);
		int index = productList.indexOf(no);
		if(index != -1){
			return productList.get(index);
		}		
		return null;
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String no) {
		// TODO Auto-generated method stub
		return false;
	}

}
