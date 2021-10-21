package controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import model.Employee;
import model.Employee.EmployeeFactory;
import service.EmployeeService;


@Controller
public class EmployeeController {
	
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/")
	public String home(Model model){
		//Employee employee = Employee.EmployeeFactory.create();
		System.out.println(" In Home");
		Employee emp=new Employee();
		emp.setEmpName("Abc");
		emp.setAge(20);
		emp.setEmpExperience(5);
		//model.addAttribute("employee",EmployeeFactory.create());
		//String empId=
		return "index";
	}
	
	@RequestMapping("/index")
	public String addEmployee(){
		System.out.println(" In Add Emp");
		return "add";
	}
	
	@ModelAttribute
	public void commonStuff(Model model){
		model.addAttribute("HeaderStatus","Enter Employee details");
		model.addAttribute("emp",EmployeeFactory.create());
		//model.addAttribute("emp",new Employee());
	}
	@RequestMapping("/create")
	public String create(){
		return "add";
	}
	
//	public String addEmployee(@RequestParam String ename,@RequestParam String salary,@RequestParam String desig )
//	{
	@RequestMapping("/add")
	public String addEmployee( @ModelAttribute("emp") Employee emp )
	{
		System.out.println("In add employee controller....");
//		System.out.println("In Create employee");
//		String empName=request.getParameter("ename");
//		String salary=request.getParameter("salary");
//		String designation=request.getParameter("desig");
//		String flag="success";
		
//		System.out.println(empName);
//		System.out.println(salary);
//		System.out.println(designation);
		
//		Employee emp=new Employee();
//		emp.setName(ename);
		boolean flag=true;
		
		//System.out.println("Emplooyee:"+employee);
		//emp.setSalary(salary);
		//emp.setId(id);
		//bindingResult will store validation result errors
		
		
		/*boolean flag=employeeService.addEmployee(employee);
	
		if(flag)
			return "add";
		else*/
			//return "index";

		 flag=employeeService.addEmployeeDetails(emp);
		 if(flag)
			 return "success";
		 return "error";	
}
	
	
}