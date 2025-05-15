package hbmLearing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hbmLearning.Entity.Employee;

public class App {

	public static void main(String[] args) {
		SessionFactory sf = new MetadataSources(
				new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build()).getMetadataBuilder()
				.build().getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println("Staart...");
		Employee e1 = new Employee();
//			 e1.setId(1);
		e1.setName("Lokesh");
		e1.setGender("male");
		session.persist(e1);
		tx.commit();

//		Employee employee = session.get(Employee.class, 1);
//		System.out.println(employee);
//		session.close();
//
//		Session session2 = sf.openSession();
//		Employee employee2 = session.get(Employee.class, 1);
//		System.out.println(employee2);
		session.close();

		sf.close();

	}

}
