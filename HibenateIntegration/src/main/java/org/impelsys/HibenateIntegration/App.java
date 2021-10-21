package org.impelsys.HibenateIntegration;

import java.util.List;

import org.impelsys.config.HibernateXMLConf;
import org.impelsys.data.impl.HibernateEmployeeDaoImpl;
import org.impelsys.data.model.Department;
import org.impelsys.data.model.Employee;
import org.impelsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	
	@Autowired
	@Qualifier("hibernateDao")
	static HibernateEmployeeDaoImpl hibernateDao;
	@Autowired
	@Qualifier("employeeservice")
	static EmployeeService service;
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(HibernateXMLConf.class);
    	
    	List<Employee> list;
    	System.out.println("in AAP");
    	hibernateDao=(HibernateEmployeeDaoImpl) applicationContext.getBean("hibernateDao");
    	
    	Employee emp=new Employee();
    	emp.setEmpId(10);
    	emp.setEmpName("jonas");
    	emp.setEmpPhoneNum("875486556");
    	Department dept=new Department();
    	dept.setDeptId(12);
    	emp.setDepartment(dept);
    	hibernateDao.getEmployeeList();
    	
        list= hibernateDao.getEmployeeList();
    	//list=service.displayAllEmployees();
       for(Employee emp1:list){
    	   System.out.println(emp.toString());
       }
    }
}
