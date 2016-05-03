import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.my.dao.ProductDAOInterface;
import com.my.dao.ProductDAOOracleBefore;
import com.my.dto.Product;
import com.my.exception.FindException;

public class ProductUser {
	private ProductDAOInterface dao;
	static private Scanner sc = new Scanner(System.in);
	public ProductUser(){
		dao = new ProductDAOOracleBefore();
	}
	public void findAll(){
		System.out.println(">>상품전체 검색작업<<");
		List<Product> list;
		try {
			list = dao.selectAll();
			for(Product p: list){
				System.out.println(p); //TODO 상품번호:상품명:가격:카테고리번호가 출력되어야함
			}
		} catch (FindException e) {
			System.out.println("검색 결과가 없습니다.");
			e.printStackTrace();
		}
	}
	public void findByNo(){
		System.out.println(">>상품번호로 상품 검색작업<<");
		System.out.print("상품번호:");
		String no = sc.nextLine();	
		Product p;
		try {
			p = dao.selectByNo(no);	
			System.out.println(p);
			//TODO 상품번호:상품명:가격:카테고리번호가 출력되어야함
			
		} catch (FindException|SQLException e1) {
			System.out.println(e1);
			System.out.println("검색 결과가 없습니다.");
			
		}
	}
	public void findByName() {
		System.out.println(">>상품명으로 상품 검색작업<<");
		System.out.println("e.g)상품명에 '아'를 입력하면 '녹차아이스크림,아메리카노, ICE아메리카노'가 모두 출력되어야한다.");
		System.out.print("상품명:");
		String name = sc.nextLine();		
		List<Product> list;
		try {
			list = dao.selectByName(name);
			if(list.size()==0){
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			for(Product p: list){
				System.out.println(p);
			}
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ProductUser user = new ProductUser();
		System.out.println("상품프로그램");
		String job;
		do{
			System.out.println("2:전체상품검색, 3:번호로 상품검색, 4:상품명으로 상품검색, 9-종료");
			System.out.print("작업을 선택하시오.:");
			job = sc.nextLine();
			switch(job){
			case "2":
				user.findAll();
				break;
			case "3":
				user.findByNo();
				break;
			case "4":
				user.findByName();
				break;
			}
		}while(!job.equals("9"));
		
	}

}
