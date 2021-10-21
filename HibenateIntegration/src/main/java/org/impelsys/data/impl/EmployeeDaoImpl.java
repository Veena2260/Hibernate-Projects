package org.impelsys.data.impl;

import org.impelsys.data.model.Employee;
import org.springframework.stereotype.Component;

//@Component
public class EmployeeDaoImpl {
	public boolean addEmployee(Employee emp){
		System.out.println("in dao");
		boolean flag=true;
		System.out.println(emp.getEmpName()+emp.getEmpPhoneNum());
		return flag;
	}

}
