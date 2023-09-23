package hbmLearing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hbmLearning.Entity.Employee;
import jakarta.persistence.TypedQuery;

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
		List<Employee> employees= session.createNamedQuery("Employee.findEmployeeById",Employee.class)
				.setParameter("id", 5)
				.getResultList();
		for (Employee employee : employees) {
			System.out.println("Emp: "+employee);
		}
		System.out.println("---------------------------------------------------");
		
//		List<Employee> emp= session.createNamedQuery("Employee.findByGender",Employee.class)
//				.setParameter("gender", "male").getResultList();
//
//		for (Employee employee : emp) {
//			System.out.println("Emp: "+employee);
//		}
		tx.commit();
		session.close();
		sf.close();

	}

}
