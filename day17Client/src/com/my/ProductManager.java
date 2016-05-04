package com.my;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ProductManager {
	static private Scanner sc = new Scanner(System.in);
	Socket s;
	DataOutputStream dos;
	
	

	public ProductManager() throws UnknownHostException, IOException {
		s = new Socket("localhost", 5431);
		dos = new DataOutputStream(s.getOutputStream());
		
	}
	

	public void findAll() {
		/*System.out.println(">>상품전체 검색작업<<");
		List<Product> list;
		try {
			list = productDAO.selectAll();
			for (Product p : list) {
				System.out.println(p); // TODO 상품번호:상품명:가격:카테고리번호가 출력되어야함
			}
		} catch (FindException e) {
			System.out.println("검색 결과가 없습니다.");
			e.printStackTrace();
		}*/
	}

	public void findByNo() {
		/*System.out.println(">>상품번호로 상품 검색작업<<");
		System.out.print("상품번호:");
		String no = sc.nextLine();

		Product e;
		try {
			e = productDAO.selectByNo(no);
			System.out.println(e); // TODO 상품번호:상품명:가격:카테고리번호가 출력되어야함
		} catch (FindException e1) {
			System.out.println("검색 결과가 없습니다.");
			e1.printStackTrace();
		}*/
	}

	public void findByName() {
	/*	System.out.println(">>상품명으로 상품 검색작업<<");
		System.out.println("e.g)상품명에 '아'를 입력하면 '녹차아이스크림,아메리카노, ICE아메리카노'가 모두 출력되어야한다.");
		System.out.print("상품명:");
		String name = sc.nextLine();
		List<Product> list;
		try {
			list = productDAO.selectByName(name);
			if (list.size() == 0) {
				System.out.println("검색 결과가 없습니다.");
				return;
			}
			for (Product p : list) {
				System.out.println(p);
			}
		} catch (FindException e) {
			e.printStackTrace();
		}*/
	}

	private void register() throws IOException {
		System.out.println(">>상품 등록작업<<");
		dos.writeInt(1);;
	 try{	
		System.out.print("상품번호");
		String prod_no = sc.nextLine();
		dos.writeUTF(prod_no);

		System.out.print("상품명:");
		String prod_name = sc.nextLine();
		dos.writeUTF(prod_name);

		System.out.print("가격:");
		int prod_price;
		
		try{
			prod_price = Integer.parseInt(sc.nextLine());
		} catch(NumberFormatException e){
			prod_price = 0;
		}
		dos.writeInt(prod_price);

		System.out.print("제조일자:");
		String prod_mf_dt = sc.nextLine();
		dos.writeUTF(prod_mf_dt);

		System.out.print("카테고리번호:");
		String category_no = sc.nextLine();
		dos.writeUTF(category_no);
	}catch(Exception e){
		System.out.println(e.getMessage());
		
		}
	}

	private void modify() {
		/*System.out.println(">>상품 수정작업<<");
		System.out.print("상품번호");
		String prod_no = sc.nextLine();
		
//		기존 바꿀 상품의 객체
		Product product;
		try {
			product = productDAO.selectByNo(prod_no);
		} catch (FindException e1) {
			System.out.println(e1.getMessage());
			return;
		}
		//바꿀 상품의 객체
		Product product1 = new Product();
		product1.setProd_no(prod_no);

		System.out.print("상품명[변경하지 않으려면 엔터를 누르세요]" + product.getProd_name() + ":");
		String prod_name = sc.nextLine();
		if (!prod_name.equals("")) {
			product1.setProd_name(prod_name);
		}
		System.out.print("가격[변경하지 않으려면 엔터를 누르세요]" + product.getProd_price() + ":");
		int prod_price = 0;
		try {
			String price = sc.nextLine();
			if (!price.trim().equals("")) {
				prod_price = Integer.parseInt(price);
			}

			product1.setProd_price(prod_price);

		} catch (NumberFormatException e) {
			System.out.println("가격을 잘못입력했습니다. 0원으로 설정됩니다.");
		}
		System.out.print("제조일자[변경하지 않으려면 엔터를 누르세요]" + product.getProd_mf_dt() + ":");
		String prod_mf_dt = sc.nextLine();
		if (!prod_mf_dt.equals("")) {
			product1.setProd_mf_dt(prod_mf_dt);
		}

		System.out.print("카테고리번호[변경하지 않으려면 엔터를 누르세요]" + product.getCategory().getCategory_no() + ":");
		String category_no = sc.nextLine();
		Category c = null;
		if (!category_no.equals("")) {
			c = new Category(category_no, null);
			product1.setCategory(c);
		}
		
		System.out.println(product1.getProd_no());
		
		productDAO.update(product1);
*/
	}

	private void remove() {
/*		System.out.println(">>상품 삭제작업<<");
		System.out.print("상품번호");
		String prod_no = sc.nextLine();
		try {
			productDAO.delete(prod_no);
		} catch (DeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/	}

	public static void main(String[] args) {
		ProductManager user= null;
		try{
			user = new ProductManager();
		}catch(Exception e){
			System.out.println(e.getMessage());
			return;
		}
		
/*		ProductManager user = new ProductManager();
		System.out.println("상품 관리 프로그램");
		String job;
		do {
			System.out.println("1:상품추가, 2:상품전체 검색, 3:번호로 상품검색, 4:상품명으로 상품검색, 5:상품수정, 6:상품삭제, 9-종료");
			System.out.print("작업을 선택하시오.:");
			job = sc.nextLine();
			switch (job) {
			case "1":
				user.register();
				break;
			case "2":
				user.findAll();
				break;
			case "3":
				user.findByNo();
				break;
			case "4":
				user.findByName();
				break;
			case "5":
				user.modify();
				break;
			case "6":
				user.remove();
				break;
			}
		} while (!job.equals("9"));

	}
*/
	}
}