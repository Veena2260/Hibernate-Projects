package org.impelsys.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.impelsys.data.DepartmentDAO;
import org.impelsys.data.model.Department;

@Component
//@Service
public class DepartmentService {
	
	@Autowired
	//@Qualifier("hibernateDao")
	DepartmentDAO departmentDao;
	
	@PostConstruct
	public void setup(){
	
	}
	public int addDepartment(Department dept)
	{
		int deptId;
		System.out.println("Added departmnet");
		deptId =departmentDao.add(dept);
		return deptId;
	}
	
	public List<Department> getAllDepartments() {
		List<Department> deptList = departmentDao.getAllDepartments();
		return null;
	}
//	public void assignEmployeeProjects() {
//		// TODO Auto-generated method stub
//		departmentDao.assignEmployeeProjects();
//	}
//	
	
}

/*HibernateEmployeeDaoImpl dao;
public int addEmployeeDetails(Employee emp){
	System.out.println("Adding employee (in service)");
	//perform business logic here
	boolean flag=false;
		flag=dao.addEmployee(emp);
	return 0;*/