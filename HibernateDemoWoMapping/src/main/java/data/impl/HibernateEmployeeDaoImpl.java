package data.impl;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data.EmployeeDao;
import model.Employee;
import util.HibernateUtil;

@Repository("hibernateDao")
public class HibernateEmployeeDaoImpl implements EmployeeDao{
	
	private static final List<Employee> ArrayList = null;


	@Autowired
	SessionFactory sessionFactory;
	
	
	Transaction tx=null;
	public int addEmployee(Employee emp){
	
		System.out.println("Adding employee (in HibernateDao)");
		Session session=null;
		Integer id;
		try{
			
		//SessionFactory sf=HibernateUtil.getSessionFactory();
			
		session =sessionFactory.openSession();
		tx=session.beginTransaction();
		id = (Integer)session.save(emp);  //insert an employee record in db
		//session.save(emp);
		tx.commit(); //only the changes are persisted to database
		return id;
	}catch (Exception e){
		tx.rollback();
		return 0;
	}
		finally{
			if(session!=null)
			session.close();//emp is detached
			// change to detachable state to persistent state
		
		/*  session = sessionFactory.openSession();
			session.beginTransaction();
			emp.setEmpName("yash");//emp is in detached state
			session.update(emp);//emp is back to persistent state
			session.getTransaction().commit();
			session.close();
			*/
			//emp is in detached state
		}
		
	}
	
	@Override
	public boolean delete(Employee e) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.delete(e);
		tx.commit();
		session.close();
		return false;
	}
	
	@Override
	public int update(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery("update Employee set empName:n , phone:p where empId=i");
		query.setParameter("n", "yash");
		query.setParameter("p", "895164");
		query.setParameter("i", 1);
		int status = query.executeUpdate();
		session.getTransaction().commit();
		return status;
	}
	
//------------------------To Fetch Details-----------make changes-----------//
	@Override
	public List<Employee> getEmployee(int empId) {
		
		// TODO Auto-generated method stub
		List <Employee> empList = new ArrayList();
		
		Session session = sessionFactory.openSession(); //Session is not thread safe
	
		Employee emp = session.get(Employee.class,new Integer(empId));
		empList.add(emp);
		
		session.close();
		
		return empList;
	}
 
	

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		//return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		
		Session session = sessionFactory.getCurrentSession();
		//Criteria API
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		
		//total salary expense
		//criteria.setProjection(Projections.sum("salary"));
		//Projections
		
		//List totalSal = criteria.list();
		//System.out.println("Total salary expenses:" +totalSal.get(0));
		
		/*//fetch all employees earning equal to 30000
		criteria.add(Restrictions.eq("salary", 30000));
		
		//fetch all employees earning more than 30000
		criteria.add(Restrictions.gt("salary", 30000));
		
		//fetch all employees earning less than 30000
		criteria.add(Restrictions.lt("salary", 30000));
		
		//fetch all employees earning is null
		criteria.add(Restrictions.isNull("salary"));
		
		//fetch all employees earning is Not null
		criteria.add(Restrictions.isNotNull("salary"));
		
		//fetch all employees earning is not empty
		criteria.add(Restrictions.isNotEmpty("salary"));
	*/
		//fetch all employees earning between 20000 to 30000
		//criteria.add(Restrictions.between("salary",20000,30000)); //21000, 24000, 25000
		//criteria.setProjection(Projections.distinct(Projections.property("salary")));
	/*	
		//fetch all employees with name starting with A
		criteria.add(Restrictions.like("empName", "%Yash%"));
		
		//fetch all employees with name starting with A -> Case sensitive
		criteria.add(Restrictions.ilike("empName", "%yash%"));
	*/
	
		//fetch all employees above age 25 earning more than 50000
		
		Criterion age = Restrictions.gt("age", 25);
		Criterion salary1 = Restrictions.gt("salary", 15000);
		//Criterion salary2 = Restrictions.lt("salary", 60000);
		LogicalExpression andExp = Restrictions.and(age, salary1);
		
		criteria.add(andExp);
		criteria.addOrder(Order.asc("age")); //sorting order ascending(asc)
		//sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
		
		//projection
		//total row count
		
		//criteria.setProjection(Projections.rowCount());
	//	session.getTransaction().commit();
		return criteria.list();
		
		
	}
	@Override
	public Long getEmployeesCount() {
	
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String totalCountQuery="Select count(e.empId) from Employee e";
		Query qry = session.createQuery(totalCountQuery);
		List <Employee> empList=qry.list();
		Long resultCount=(Long) qry.uniqueResult();
		return resultCount;
	}
	
	
	
	
	
	
	@Override
	public List<Employee> getEmployeesList() {
		//return EmployeeDao.super.getEmployeeList();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		int from = 0;
		query.setFirstResult(from);
		int noOfRows = 0;
		query.setMaxResults(noOfRows);
		System.out.println("feyching ");
		// table name
		//query.setFirstResult(5);//start from the 5th row of the table
		//query.setMaxResults(5);//results from the 5th row and other 5 rows result
		
		
		//String totalCountQuery = "Select count(e.empId) from Employee e";//Not the table name and the col name
		//Query qry = session.createQuery(totalCountQuery);
		List<Employee> empList = query.list();
		//int resultCount = (int) qry.uniqueResult();
		
		return empList;
	}

	@Override
	public List<Integer> getAllDistinctSalary() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		//Criteria API
		Criteria criteria = session.createCriteria(Employee.class);
		
		criteria.add(Restrictions.gt("salary", 15000));
		//List totalSal = criteria.list();
		
		
		//criteria.add(Restrictions.between("salary",20000,30000)); //21000, 24000, 25000
		criteria.setProjection(Projections.distinct(Projections.property("salary")));
		//criteria.setProjection(Projections.sum("salary"));
		return criteria.list();
	}

	
}
