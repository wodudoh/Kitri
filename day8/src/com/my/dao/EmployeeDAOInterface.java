package com.my.dao;

import com.my.dto.Employee;

public interface EmployeeDAOInterface {
	
	void add(Employee e);
	Employee[] selectAll();
	Employee[] selectByName(String name);
	

}
