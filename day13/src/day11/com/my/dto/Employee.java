package day11.com.my.dto;
import java.io.Serializable;
import java.util.Date;

/**
 * 사원 객체 모델링
 * 1) 객체의 속성, 기능을 나열
 * 2) 클래스화
 * 3) 클래스를 이용하여 객체를 생성 및 사용
 * 
 * @author Administrator
 * 
 * 1) 사원의 속성, 기능 나열
 *  사번, 이름, 입사일, 급여, 연락처, 주소
 *  
 *  2) 업무를 수행한다(Work), 회의한다, 회식한다,출장한다, 휴가한다.(vacation) , 급여를 받는다.
 *
 */
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String No; // 사번
	private String name ; // 사원의 이름
	private Date hire;  // 입사일자
	private int salary; // 급여
	private String phone; // 연락처 010 앞에 0이 들어가게 하기위해서.
	
	public String getNo() {
		return No;
	}

	public void setNo(String No) {
		this.No = No;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHire() {
		return hire;
	}

	public void setHire(Date hire) {
		this.hire = hire;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employee(){
		
	}
	
	public Employee(String empNo, String name, String phone, int salary) {
		// TODO Auto-generated constructor stub
		this.No = empNo;
		this.name = name;
		this.phone = phone;
		this.salary = salary;
		
		
	}

	public void work(){
		System.out.print(this.No+"사원인 " + this.name+"가(이)"); // 현재 사용중인 객체의 변수를 찾는다.
		System.out.println("일한다.");
	}
	
	public void meeting(){
		System.out.print(No + "사원이 "+ this.name+"가(이)");
		System.out.println("회의한다.");
	}
	
	public void pay(){
		System.out.print(No + "사원이 "+ this.name+"가(이)");
		System.out.println("급여를 "+ salary +"만큼 받는다.");
	}

	
	public String toString() {
		return "일반사원 : " + No + ":" + name + ":" + salary;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if(obj instanceof Employee){
			Employee e = (Employee)obj;
			if(this.No.equals(e.No)){
				return true;
				}
		}	return false;
		
	}	

}
