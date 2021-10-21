package util;



import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;
	
	//factory method
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null){
			Configuration conf=new Configuration();
			//conf.configure("hibernate.cfg.xml");
			System.out.println("configuring hibernate xml");
			//create registry
			StandardServiceRegistryBuilder registryBuilder=new StandardServiceRegistryBuilder();
			registry =  registryBuilder.configure("hibernate.cfg.xml").build();
			
			//MetadataSources sources =new MetadataSources();
			//create metadata
			System.out.println("hi");
			Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
			
			sessionFactory =metadata .getSessionFactoryBuilder().build();
		}
		return sessionFactory;
			
		}
	public static void shutdown(){
		if(registry!=null){
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
