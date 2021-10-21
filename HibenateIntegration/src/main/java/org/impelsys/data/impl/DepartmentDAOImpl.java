package org.impelsys.data.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import org.impelsys.data.DepartmentDAO;
import org.impelsys.data.model.Department;
import org.impelsys.data.model.Employee;

@Component
public class DepartmentDAOImpl  implements DepartmentDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int add(Department dept)
	{
		Session session = sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Employee e1=new  Employee("yashwanth","12345","M");
		Employee e2=new  Employee("yashwanth","67890","M");
		Set<Employee> empSet = new HashSet<Employee>();
		empSet.add(e1);
		empSet.add(e2);
		dept.setEmployees(empSet);
		int rowsAdded =(int)session.save(dept);
		tx.commit();
		return rowsAdded;
	}

	@Override
	public boolean delete(){
		return false;
	}
	@Override
	public List<Department> getAllDepartments() {
		Session session = sessionFactory.getCurrentSession();
		if(!session.getTransaction().isActive())
			session.beginTransaction();
		Query<Department> query = session.createQuery("from department", Department.class);
		List<Department> deptList = query.list();
		for(Department dept : deptList){
			System.out.println("Employees working in dept: " +dept.getDeptName());
			for(Employee emp : dept.getEmployees())
				System.out.println(emp.getEmpName());
		}
		return query.list();
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}
}