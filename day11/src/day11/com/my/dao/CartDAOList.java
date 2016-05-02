package day11.com.my.dao;

import java.util.HashMap;
import java.util.Map;

import day11.com.my.dto.Product;

public class CartDAOList implements CartDAOInterface {
	
	private Map<Product, Integer> cart = new HashMap<Product, Integer>();
	

	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		
		//해쉬맵은 해쉬코드로 일단 key를 찾아가도록 되어있는데
		// 그 해쉬코드가 오버라이드 되지 않으면 전혀 다른 해쉬코드로 인식함
		
		Integer value = cart.get(product);
		if(value == null){
			cart.put(product, 1);
		} else{
			//수량을 1증가해서 cart에 누적
//			cart.put(product,1+(cart.get(product)));;
			value++; // int i = value.intValue();
					// i++;
			cart.replace(product, value);
		}
		
		
	}

	@Override
	public Map<Product, Integer> selectAll() {
		// TODO Auto-generated method stub
		return cart;
	}

}
