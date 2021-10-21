package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import dao.EmployeeDao;
import model.Employee;

@Service
public class EmployeeService {
	@Autowired
	@Qualifier("hibernateDao")
	EmployeeDao employeeDao;
	
	//@PostConstruct
	public void setup(){
		
	}
	public boolean addEmployeeDetails(Employee emp){
		boolean flag=false;
		System.out.println("Adding employee (in service)");
		
		//System.out.println("Adding employee (in service)");
		//perform bussiness logic here
		//EmployeeDao dao=new EmployeeDao();
		//if(emp!=null && emp.getName()!=null && emp.getDesignation()!=null)
		//{
		if(emp.getEmpName().equals("")|| emp.getEmpPhoneNum().equals("")){
			flag=false;
		}
		//}
		else
			flag=employeeDao.addEmployee(emp);
		return flag;
	}

}