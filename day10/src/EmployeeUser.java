import java.util.List;
import java.util.Scanner;

import day10.com.my.Exception.AddException;
import day10.com.my.dao.EmployeeDAOInterface;
import day10.com.my.dao.EmployeeDAOList;
import day10.com.my.dto.Employee;
import day10.com.my.dto.Manager;

public class EmployeeUser {
	private EmployeeDAOInterface dao;
	static private Scanner sc = new Scanner(System.in);
	public EmployeeUser(){
		dao = new EmployeeDAOList(2);
	}
	public void register(){
		System.out.println(">>사원등록작업<<");
		String gubun;
		do{
			System.out.println("사원종류선택[1-사원, 2-관리자]:");
			gubun= sc.nextLine();
		}while(!gubun.equals("1") && !gubun.equals("2") );
		
		System.out.print("사번:");
		String no = sc.nextLine();
		
		System.out.print("이름:");
		String name = sc.nextLine();
		
		System.out.print("급여:");
		int sal = Integer.parseInt(sc.nextLine());
		 
		try{
			if(gubun.equals("1")){
				dao.add(new Employee(no, name, null, sal));
			}else{
				System.out.print("수당:");
				int comm = Integer.parseInt(sc.nextLine());
				dao.add(new Manager(no, name, null, sal, comm));				
			}
			System.out.println("사원등록 성공");	
		}catch(AddException e){
			System.out.println(e.getMessage());
		}
	}
	public void findAll(){
		System.out.println(">>사원전체 검색작업<<");
		List<Employee> list = dao.selectAll();
		if(list == null){
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for(Employee e: list){
			System.out.println(e);
		}
	}
	
	public void findByNo(){
		System.out.println(">>사번으로 사원 검색작업<<");
		System.out.print("사번:");
		String no = sc.nextLine();		
		Employee e = dao.selectByNo(no);
		if(e == null){
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		System.out.println(e); 
	}
	public void findByName() {
		System.out.println(">>이름으로 사원 검색작업<<");
		System.out.print("이름:");
		String name = sc.nextLine();		
		List<Employee> list = dao.selectByName(name);
		if(list == null){
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		for(Employee e: list){
			System.out.println(e);
		}
	}
	public void remove(){
		System.out.println(">>사원 삭제작업<<");
		System.out.print("사번:");
		String no = sc.nextLine();		
		if( dao.delete(no) ){
			System.out.println("사원 삭제 성공");
			return;
		}
		System.out.println("사원삭제 실패");
	}
	public static void main(String[] args) {
		EmployeeUser user = new EmployeeUser();
		System.out.println("사원관리프로그램");
		String job;
		do{
			System.out.println("1:사원등록, 2:전체사원검색, 3:사번으로 사원검색, 4:이름으로 검색, 5:사원삭제, 9-종료");
			System.out.print("작업을 선택하시오.:");
			job = sc.nextLine();
			switch(job){
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
				user.remove();
			}
		}while(!job.equals("9"));
		
	}

}
