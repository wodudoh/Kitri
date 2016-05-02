package com.my.dao;
	
import com.my.dto.Employee;


public class EmployeeDAO {
	
	
	static private Employee[]employees; //사원 저장소
	private int totalCnt; // 총사원수
	
	public EmployeeDAO(){
		//employees = new Employee[5];
		this(5);
		
	}
	
	
	public EmployeeDAO(int size){
		employees = new Employee[size];
	}
	/**
	 * 
	 * 인자로 전달된 사원객체를 저장소에 저장한다.
	 * 총사원수를 1증가한다.
	 * @param e 저장소에 저장할 사원 객체 
	 * @return 
	 */
	public void add(Employee e){
		
		employees[totalCnt]=e; //인자로 전달된 사원객체를 저장소에 저장한다.
		totalCnt++; // 총사원수를 1 증가
		
		return;
	}
	/**
	 * 총사원을 반환한다.
	 * @return 저장소에 저장되어있는 사원객체를 반환한다.
	 * 저장되어있는 사원이 없을 경우 null값을 반환한다.
	 */
	public Employee[] selectAll(){
		if(totalCnt <= 0){
			return null;
		}
		else {
			Employee[] list = new Employee[totalCnt];
			/*for(int i=0;i <list.length; i++){
				list[i] = employees[i];
			}*/ //이코드를 한줄로 바꿀 수 있다.
			System.arraycopy(employees, 0, list, 0, totalCnt);
			return list;
		}
	}
	
	/**
	 * 사번으로 저장소의 사원을 검색하여 반환한다.
	 * @param no 사번
	 * @return 사원객체, 사번에 해당하는 사원이 없으면 null을 반환한다.
	 */
	public Employee selectByNo(String no){
		
		for(int cnt=0;employees[cnt+1]!=null;cnt++){
			
			if(employees[cnt].getNo().equals(no)){
				return employees[cnt];
			}
		}
		return null;
		
	}
	public Employee[] selectByName(String name){
		
		Employee[] list;
		for(int cnt=0;cnt<employees.length;cnt++){
			
			if(employees[cnt].getName().equals(name)){
			}
		}
		return null;
		
	}
	public void delete(String no){
		
	}

}
