
package hbmLearing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hbmLearning.Entity.Address;
import hbmLearning.Entity.Employee;

public class App {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session1 =sf.openSession();
		System.out.println(">>1>>>>>>>>>>>>>>>");

		save(session1);
		Employee em =  session1.get(Employee.class, 1);
		System.out.println(em);
//		System.out.println(em.getAddress());
//		Address add = (Address) session1.get(Address.class, 1);
//		System.out.println(add);
//		System.out.println(add.employee);

//		fetchAllEmployees(session1);
//		fetchAllAddress(session1);

		System.out.println("..............Close Session .............");
		session1.close();
		sf.close();
		System.out.println("<<<<<<<<<<<");
	}

	@SuppressWarnings("deprecation")
	private static void fetchAllEmployees(Session session) {
		System.out.println("...............Employees Fetching...........");
		List<Employee> resultList = session.createQuery("From Employee", Employee.class).getResultList();
		for (Employee employee : resultList) {
			System.out.println(employee);
		}
//		System.out.println(resultList.get(1).getAddress());
		System.out.println("...............Employees end...........");
	}

	@SuppressWarnings("deprecation")
	private static void fetchAllAddress(Session session) {
		System.out.println("...............Address Fetching..........");
		List<Address> resultList = session.createQuery("From Address", Address.class).getResultList();
//		for (Address add : resultList) {
//			System.out.print(add+"     "+add.getEmployee());
//		}
//		System.out.println(resultList.get(1).employee);
		System.out.println("...............Address end...........");
	}

	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee e = new Employee();
		e.setFirstName("Kunal");
		e.setLastName("sharma");
		Address address = new Address("GZB", "UP");
		e.setAddress(address);
		session.persist(address);
		session.persist(e);
		transaction.commit();
	}

}


