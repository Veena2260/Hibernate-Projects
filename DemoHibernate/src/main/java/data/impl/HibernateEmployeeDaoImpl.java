package data.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import data.impl.EmployeeDao1;
import model.Employee;
import util.HibernateUtil;

@Repository("hibernateDao")
public class HibernateEmployeeDaoImpl implements EmployeeDao1 {
	@Autowired
	SessionFactory sessionFactory;
	
	Transaction tx=null;
	public boolean add(Employee emp){
		
		//factory pattern --> design pattern
		Session session=null;
		try{
			SessionFactory sf= HibernateUtil.getSessionFactory();
			session =sessionFactory.openSession();
			tx=session.beginTransaction();
			session.save(emp);
			tx.commit();
			return true;
		}catch(Exception ex){
			tx.rollback();
			return false;
		}
		finally{
			if(session!=null)
				session.close();
		}
	}

}
