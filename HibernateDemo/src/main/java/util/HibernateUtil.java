package util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

import model.BankAccount;
import model.Department;
import model.Employee;
import model.Project;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	private static Map<String,String> getSessionFactoryMap()
	{
		Map<String,String> map = new HashMap();
		map.put("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
		map.put("hibernate.connection.url","jdbc:mysql://localhost:3306/test456");
		map.put("hibernate.connection.username","root");
		map.put("hibernate.connection.password","root");
		map.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		map.put("hibernate.show_sql","true");
		map.put("hibernate.format_sql","true");
		map.put("hibernate.hbm2ddl.auto","update");
		map.put("hibernate.current_session_context_class","thread");
		
		return map;
		
	}
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null)
		{
			Map<String,String> map = getSessionFactoryMap();
			System.out.println("in getSessionFactory");
			
		//	Configuration config=new Configuration();
		//	config.configure("hibernate.cfg.xml");
		//	config.addResource(resourceName)
			/*System.out.println("at Config");
			StandardServiceRegistryBuilder registryBuilder=new StandardServiceRegistryBuilder();
			registry=registryBuilder.configure("hibernate.cfg.xml").build();
			System.out.println("at Registry");
			
			Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();*/
			//registry=new StandardServiceRegistryBuilder().configure().build();
			//MetadataSources sources=new MetadataSources();
			//Metadata metadata = sources.getMetadataBuilder().build();
			//System.out.println("at Metadata");
			//sessionFactory=metadata.getSessionFactoryBuilder().build();
			StandardServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(map).build();
			MetadataSources metadataSource = new MetadataSources(registry);
//			metadataSource.addResource("employee.hbm.xml");
			metadataSource.addAnnotatedClass(Employee.class);
			metadataSource.addAnnotatedClass(Department.class);
			metadataSource.addAnnotatedClass(BankAccount.class);
			metadataSource.addAnnotatedClass(Project.class);
			System.out.println("in metadataSource");
			Metadata metadata = metadataSource.getMetadataBuilder().build();
			System.out.println("at metadata sessionfactory");
			sessionFactory= metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
	}
	
	public static void shutdown(){
		if(registry!=null)
		{
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("at null registry");
		}
	}

}
