package day11.com.my.dto;

public class Category {
	
	private String category_no; // 카테고리 번호
	private String name; // 카테고리 이름
	
	
	
	public Category(String category_no, String name) {
		super();
		this.category_no = category_no;
		this.name = name;
	}



	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getCategory_no() {
		return category_no;
	}



	public void setCategory_no(String category_no) {
		this.category_no = category_no;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

}
