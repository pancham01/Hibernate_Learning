package hbmLearning.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hbmLearning.Entity.Employee;
import hbmLearning.config.HibernateConfig;

public class App {
	public static void main(String[] args) {

		SessionFactory sf = HibernateConfig.getSessionFactory();
		Session session1 = sf.openSession();
		Transaction tx = session1.beginTransaction();
		Employee e = new Employee();
//		e.setName("Kunal");
//		e.setGender("M");
//		session.persist(e);
//		tx.commit();

		System.out.println("Staart...");

		Employee employee = session1.get(Employee.class, 1);
		System.out.println(employee);
		session1.close();
//
		Session session2 = sf.openSession();
		Employee employee2 = session2.get(Employee.class, 1);
		System.out.println(employee2);
		session2.close();

		sf.close();
	}

}
