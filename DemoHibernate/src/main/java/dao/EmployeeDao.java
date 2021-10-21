package dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import model.Employee;

@Repository
public class EmployeeDao {

	boolean flag=false;
	public boolean addEmployee(Employee emp){
		
	System.out.println("Adding emplpyee(in dao/data)");
	boolean flag=true;
	System.out.println(emp.getEmpName()+emp.getEmpPhoneNum());
	
	return flag;
	}
	
}
