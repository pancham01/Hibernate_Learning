package hbmLearing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hbmLearning.Entity.Employee;

public class App {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		// Create typesafe ServiceRegistry object
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Staart...");
		Employee e1 = new Employee();
//			 e1.setId(1);
			e1.setName("Lokesh");e1.setGender("male");
			session.save(e1);


		tx.commit();
		session.close();
		sf.close();

	}

}
