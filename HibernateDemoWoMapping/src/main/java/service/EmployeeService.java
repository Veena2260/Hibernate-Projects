package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import data.EmployeeDao;
import data.impl.HibernateEmployeeDaoImpl;
import model.Employee;

@Service
public class EmployeeService {
	@Autowired
	@Qualifier("hibernateDao")
	EmployeeDao employeeDao;
	@PostConstruct
	public void setup(){
	
	}
	public List<Employee> displayEmployee(int empId){
		return employeeDao.getEmployee(empId);
	}
	
	public List<Employee> displayAllEmployees(){
		return employeeDao.getAllEmployees();
	}
	public List<Integer> displayAllDistinctSalary(){
		List<Integer> list = new ArrayList<Integer>();
		list = employeeDao.getAllDistinctSalary();
		return list;
		
	}
	public int addEmployeeDetails(Employee emp){
		int empId;
		System.out.println("Adding employee (in service)");
		
		empId = employeeDao.addEmployee(emp);
		return empId;
	}
	
	public Long getEmployeesCount(){
		return employeeDao.getEmployeesCount();
	}
	public int updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		int status=employeeDao.update(emp);
		return status;
	}
	public List<Employee> displayAllEmployees(int rowFrom, int numOfRecords) {
		// TODO Auto-generated method stub
		return null;
	}
}

/*HibernateEmployeeDaoImpl dao;
public int addEmployeeDetails(Employee emp){
	System.out.println("Adding employee (in service)");
	//perform business logic here
	boolean flag=false;
		flag=dao.addEmployee(emp);
	return 0;*/