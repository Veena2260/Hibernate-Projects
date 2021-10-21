package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import model.Employee;
import model.Employee.EmployeeFactory;
import service.EmployeeService;

//@RequestMapping("/employee") //localhost:8800/HibernateDemo/employee/ v u create ....
@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	public String page(@PathVariable String pageNum,Model model){
		//fetching employees from table with start row count based on pagr no
		int pageNo=Integer.parseInt(pageNum);
		int numOfRecords=10;
		int rowFrom=1;
		rowFrom=((pageNo-1)*numOfRecords)+1;
		List<Employee> listEmp=service.displayAllEmployees(rowFrom,numOfRecords);
		model.addAttribute("empList",listEmp);
		return "home";
		
		
	}
	@RequestMapping("/")
	public String home(Model model){
		System.out.println("In home controller");
		Long empCount=service.getEmployeesCount();
		model.addAttribute("empCount", empCount);
		/*Employee emp = new Employee();
		emp.setEmpName("patrick");
		emp.setEmpPhoneNum("965264536");
		emp.setExperience("3");
		emp.setGender("M");
		emp.setAge(28);
		emp.setSalary(35000);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date dob = sdf.parse("22/09/1995");
			emp.setDob(dob);
		}
		catch (ParseException e1){
			e1.printStackTrace();
		}
		int empId = service.addEmployeeDetails(emp);
		*/
		
		/* List<Employee> list = service.displayAllEmployees();
		 for(Employee e: list)
			 System.out.println(e);*/
	//	service.addEmployeeDetails(emp);
		 //model.addAttribute("empList",list);
		//model.addAttribute("employee",EmployeeFactory.create());
		return "home";
	}
		 
		/* List<Integer> list1 = service.displayAllDistinctSalary();
		 for(Integer e: list1)
			 System.out.println(e);
		 model.addAttribute("empList1",list1);
		return "home";
	}*/
	@RequestMapping("/")
	
	
	
	
	
	
	@ModelAttribute
	public void commStuff(Model model){
		model.addAttribute("HeaderStatus", "Welcome to Impelsys!");
		model.addAttribute("emp", new Employee());
	}
	@RequestMapping("/index")
	public String addemp(){
		return "add";
	}
	@RequestMapping("/tryAgain")
	public String tryAgain(){
		return "add";
	}
	@RequestMapping("showLogin")
	public String showLogin(){
		return "login";
	}
	
	@ModelAttribute
	public void commonStuff(Model model){
		model.addAttribute("HeaderStatus","Enter Employee details");
		model.addAttribute("emp",EmployeeFactory.create());
	}

	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute("emp") Employee emp){
		System.out.println("Adding employee (in controller)");
		 int flag = 1;
		
		 flag=service.addEmployeeDetails(emp);
		 if(flag>0)
			 return "success";
		 return "error";
		
	}
	@RequestMapping("/create/{count}")
	public void createEmployeeBulk(@PathVariable int count){
		for(int i=0; i<count;i++){
			Employee e =new Employee();
			e.setEmpName("emp: "+i);
			e.setEmpPhoneNum("687387613");
			//populate all fields
			service.addEmployeeDetails(e);
		}
		System.out.println("Processing complete");
	}
	//path variables
	@RequestMapping("/update/{eName}/{ePhoneNum}/{eId}")//localhost:8800/HibernateDemo/employee/yash/89516/bangalore
	public String update(@PathVariable String eName,@PathVariable String ePhoneNum,@PathVariable int eId,Model model){
		Employee e = new Employee();
		e.setEmpName(eName);
		e.setEmpPhoneNum(ePhoneNum);
		e.setEmpId(eId);
		//update operation
		int count = service.updateEmployee(e);
		if(count>=1){
			model.addAttribute("empAttribute",e);
			return "update";
		}
		else
		{
			return "error";
		}
			
	}
	
	
}
