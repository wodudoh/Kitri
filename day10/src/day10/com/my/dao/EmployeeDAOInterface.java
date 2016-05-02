package day10.com.my.dao;

import java.util.List;

import day10.com.my.Exception.AddException;
import day10.com.my.dto.Employee;

public interface EmployeeDAOInterface {
	/**
	 * 인자로 전달된 사원객체를 저장소에 저장한다.
	 * 총사원수를 1증가한다
	 * 인자로 전달된 사원객체의 사번과 이미저장되어있는 사원들의 사번이 중복되는 경우
	 * "이미존재하는 사번입니다"상세메시지를 갖는 DuplicateKeyException을 발생시킨다. 
	 * @param e 저장소에 저장할 사원객체
	 */
	void add(Employee e) throws AddException;
	/**
	 * 총사원을 반환한다.
	 * @return 저장소에 저장되어있는 사원객체들을 반환한다.
	 * 저장되어있는 사원이 없을 경우 null값을 반환한다
	 */
	List<Employee> selectAll();
	/**
	 * 사번으로 저장소의 사원을 검색하여 반환한다.
	 * @param no 사번
	 * @return 사원객체. 사번에 해당하는 사원이 없으면 null을 반환한다
	 */
	Employee selectByNo(String no);
	
	/**
	 * 이름에 해당하는 사원을 모두 검색한다.
	 * 해당사원이 없으면 null을 반환한다.
	 * @param name
	 * @return
	 */
	List<Employee> selectByName(String name);
	/**
	 * 사번에 해당하는 사원을 저장소에서 삭제한다.
	 * 사번에 해당 사원이 없으면 false값을 반환한다.
	 * @param no
	 * @return 삭제성공이면 true값을 반환한다.
	 */
	boolean delete(String no);
}