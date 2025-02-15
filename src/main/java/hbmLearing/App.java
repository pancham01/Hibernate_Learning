package hbmLearing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import hbmLearning.Entity.Employee;

public class App {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Query<Employee> query = session.createNamedQuery("Employee.findEmployeeById", Employee.class);
		query.setParameter("id", "1");
		List<Employee> employees = query.getResultList();
		System.out.println(employees);

		System.out.println();

		Query<Employee> q = session.createNamedQuery("Employee.findByGender", Employee.class);
		q.setParameter("gender", "male");
		List<Employee> employees2 = q.list();
		System.out.println(employees2);
		tx.commit();
		session.close();
		sf.close();

	}

}
