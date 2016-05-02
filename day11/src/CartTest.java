import java.util.Map;
import java.util.Set;

import day11.com.my.dao.CartDAOInterface;
import day11.com.my.dao.CartDAOList;
import day11.com.my.dto.Product;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			CartDAOInterface dao = new CartDAOList();
			
			dao.add(new Product("p1","n1", 100, null, null));
			dao.add(new Product("p2","n2", 100, null, null));
			dao.add(new Product("p1","n1", 100, null, null));
			dao.add(new Product("p4","n4", 100, null, null));
			Map<Product, Integer> list =dao.selectAll();
			Set<Product> keys =list.keySet();
			
			for(Product p: keys)
			{
				
				Integer qunatity = list.get(p);
				System.out.println(p.getProd_no() + ":" + qunatity);
			}

			
	}

}
