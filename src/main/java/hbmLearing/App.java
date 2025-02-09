package hbmLearing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
<<<<<<< Updated upstream
import org.hibernate.query.Query;
=======
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
>>>>>>> Stashed changes

import hbnLearning.Configuration.HibernateConfiguration;
import hbmLearning.Entity.Employee;

public class App {

	public static void main(String[] args) {
<<<<<<< Updated upstream
		SessionFactory sf = HibernateConfiguration.getSessionFactory();
=======

		Configuration cfg = new Configuration().configure("hibernate.cfgg.xml");

		// Create typesafe ServiceRegistry object
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.getSessionFactoryBuilder().build();
>>>>>>> Stashed changes
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("start...........");
		Employee e = new Employee();

//		Employee e = session.load(Employee.class, 2);
//		System.out.println(e);
		e.setName("Mukul");
		e.setGender("male");
		e.setAddress("Noida");
		e.setCity("GZB");
		session.persist(e);
		tx.commit();
		Query q = session.createQuery("from Employee");
		List l = q.list();
		System.out.println(l);
		
		session.close();
		sf.close();
	}

}