package com.my.dao;

import com.my.Exception.AddException;
import com.my.Exception.DuplicateKeyException;
import com.my.dto.Employee;

public interface EmployeeDAOInterface {
	void add(Employee e) throws AddException, DuplicateKeyException;
	Employee[] selectAll();
	Employee selectByNo(String no);
}