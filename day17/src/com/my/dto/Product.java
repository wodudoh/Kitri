package com.my.dto;

public class Product {
	private String prod_no;//상품번호
	private String prod_name;//상품이름
	private int prod_price;//가격
	private String prod_mf_dt;//제조일자
	private Category category;//카테고리
	public Product() {
		super();
	}
	public Product(String prod_no, String prod_name, int prod_price, String prod_mf_dt, Category category) {
		super();
		this.prod_no = prod_no;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_mf_dt = prod_mf_dt;
		this.category = category;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prod_no == null) ? 0 : prod_no.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (prod_no == null) {
			if (other.prod_no != null)
				return false;
		} else if (!prod_no.equals(other.prod_no))
			return false;
		return true;
	}
	/*	public boolean equals(Object o){
		if(o instanceof Product){
			Product p = (Product)o;
			//if(getProd_no().equals(p.getProd_no())){
			if(prod_no.equals(p.prod_no)){
				return true;
			}
		}
		return false;
	}
*/
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_mf_dt() {
		return prod_mf_dt;
	}
	public void setProd_mf_dt(String prod_mf_dt) {
		this.prod_mf_dt = prod_mf_dt;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
//		상품번호:상품명:가격:카테고리번호가 출력되어야함
		return "상품번호:" + prod_no + "상품명:" + prod_name + "가격:" + prod_price + "카테고리번호:"+ category.getCategory_no();
	}
	
	
	
	
	
}