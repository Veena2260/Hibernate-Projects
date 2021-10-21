package model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	int empId;
	String empName;
	String empPhoneNum;
	String experience;
	String gender;
	int salary;
	int age;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	Date dob;
	
	public Employee(){
		
	}

	public static class EmployeeFactory{
	public static Employee create(){
		return  new Employee();
	}
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
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
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPhoneNum=" + empPhoneNum + ", experience="
				+ experience + ", dob=" + dob + "]";
	}
	
	
	
}
