package model;

import java.util.Date;

import java.lang.String;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;



@Component
public class Employee {
	
	
	String empName;
	
	String Shift;
	
	String empPhoneNum;
	
	int empExperience;
	
	int age;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	Date dateOfBirth;
	
	public Employee(){
		
	}
	
	public static class EmployeeFactory {
		public static Employee create(){
		return new Employee();
	}
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getEmpExperience() {
		return empExperience;
	}
	public void setEmpExperience(int empExperience) {
		this.empExperience = empExperience;
	}
	
	

	public String getShift() {
		return Shift;
	}
	public void setShift(String shift) {
		Shift = shift;
	}
	

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhoneNum() {
		return empPhoneNum;
	}
	public void setEmpPhoneNum(String empPhoneNum) {
		this.empPhoneNum = empPhoneNum;
	}
	@Override
	public String toString() {
		return "Employee [ name=" + empName + ", Experience=" + empExperience + ",Age=" + age + "]";
	}
	
	
}
