package hbmLearing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import hbnLearning.Configuration.HibernateConfiguration;
import hbmLearning.Entity.Employee;

public class App {

	public static void main(String[] args) {
		SessionFactory sf = HibernateConfiguration.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("start...........");
		Employee e = new Employee();

//		Employee e = session.load(Employee.class, 2);
//		System.out.println(e);
		e.setName("Mukul");
		e.setGender("male");
		e.setAddress("Noida");
		session.persist(e);
		tx.commit();
		Query q = session.createQuery("from Employee");
		List l = q.list();
		System.out.println(l);
		
		session.close();
		sf.close();
	}

}