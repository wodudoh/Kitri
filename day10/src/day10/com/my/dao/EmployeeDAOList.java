package day10.com.my.dao;

import java.util.ArrayList;
import java.util.List;

import day10.com.my.Exception.AddException;
import day10.com.my.Exception.DuplicateKeyException;
import day10.com.my.dto.Employee;
public class EmployeeDAOList implements EmployeeDAOInterface{	
	private List<Employee> employees;//사원저장소
	private int totalCnt; //총사원수
	public EmployeeDAOList(){
		this(5);
	}
	public EmployeeDAOList(int size){
		employees = new ArrayList<Employee>(size); //가변적으로 증가되는 방이지만, 초기 방의 갯수를 사이즈 만큼 넣어둔다.
	}
	
	//TODO add 구현
	public void add(Employee e) throws AddException{
		
		
			for(int i=0;i<employees.size();i++){
			
				if(e.getNo().equals(employees.get(i).getNo())){
					throw new DuplicateKeyException("입력하신 사원번호는 이미 등록된 사번입니다. 입력하신 사원번호:"+e.getNo());
				}
				
			}
		
			employees.add(totalCnt, e);
			totalCnt=employees.size();
	}

	public List<Employee> selectAll(){		
		if(employees.size() == 0){
			return null;
		}
		return employees;		
	}

	//TODO selectByNo 구현
	public Employee selectByNo(String no){
		
		for (int i = 0; i < employees.size(); i++) {
			
			if(employees.get(i).getNo().equals(no)){
				return employees.get(i);
			}
			
		}		
		return null;
	}
	//TODO selectByName 구현
	public List<Employee> selectByName(String name){
		
		List<Employee> selectedList = new ArrayList<Employee>();
		for(int i = 0; i < employees.size(); i++){
			
			if(employees.get(i).getName().equals(name)){
				selectedList.add(employees.get(i));
			}
		}
		
		if(selectedList.isEmpty())
		return null;
		else return selectedList;
	}
	//TODO delete 구현
	public boolean delete(String no){
	
		for(int i = 0;i < employees.size();i++){
			
			if(employees.get(i).getNo().equals(no)){
				employees.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
