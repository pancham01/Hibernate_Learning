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
//			 e1.setId(1);
			e1.setName("puneet");e1.setGender("female01");
			session.save(e1);
//			Employee e2 = new Employee();
//			 e2.setId(2);
//			e2.setName("naman");e2.setGender("female01");
//			session.save(e2);
//			System.out.println(session.save(e1));
//			e1= session.get(Employee.class, 2);
//			System.out.println(e1);
//		TypedQuery<Employee> query = session.createNamedQuery("findEmployeeByName",Employee.class);
//		query.setParameter("name", "naman");
//		List<Employee> employees = query.getResultList();
//		for (Employee employee : employees) {
//			System.out.println("Emp: "+employee);
//		}
		tx.commit();
		session.close();
		sf.close();

	}

}
