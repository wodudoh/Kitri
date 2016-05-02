package com.my.dto;

public class Manager extends Employee {
	
	private int comm;

	public Manager(String empNo, String name, String phone, int salary, int comm) {
		// TODO Auto-generated constructor stub
//		super.setEmpNo(empNo);
//		super.setName(name);
//		super.setPhone(phone);
//		super.setSalary(salary);
		super(empNo, name, phone, salary);
		this.comm = comm;
		
	}
	public Manager(){
//		super();
	}

	@Override
	public void pay() {
		System.out.print(getNo() + "사원이 "+ getName()+"가(이)");
		System.out.println("급여를 "+ (getSalary()+(getSalary()*comm/100)) +"만큼 받는다.");
		
	}
	
	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "관리자:"+super.getNo()+":"+super.getName()+":"+super.getSalary()+":"+this.comm;
	}
	
	
	

}
