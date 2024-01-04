
package hbmLearing;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hbmLearning.Entity.Address;
import hbmLearning.Entity.Employee;

public class App {
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>");
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		System.out.println(">>1>>>>>>>>>>>>>>>");

		save(session1);
//		Employee em =  session1.get(Employee.class, 1);
//		System.out.println(em);
//		System.out.println(em.address);
//		Address add = (Address) session1.get(Address.class, 2);
//		System.out.println(add);
//		System.out.println(add.employee);

//		fetchAllEmployees(session1);
//		fetchAllAddress(session1);

		System.out.println("..............Close Session .............");
		session1.close();
//		session2.close();
		System.out.println("<<<<<<<<<<<");
	}

	@SuppressWarnings("deprecation")
	private static void fetchAllEmployees(Session session) {
		System.out.println("...............Employees Fetching...........");
		List<Employee> resultList = session.createQuery("From Employee", Employee.class).getResultList();
		resultList.forEach(e -> {
			System.out.println(e);
		});
//		System.out.println(resultList.get(1).getAddress());
		System.out.println("...............Employees end...........");
	}

	@SuppressWarnings("deprecation")
	private static void fetchAllAddress(Session session) {
		System.out.println("...............Address Fetching..........");
		List<Address> resultList = session.createQuery("From Address", Address.class).getResultList();
		resultList.forEach(add -> {
			System.out.println(add);
		});
//		System.out.println(resultList.get(1).employee);
		System.out.println("...............Address end...........");
	}

	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee e = new Employee();
		e.setFirstName("Rudraa");
		e.setLastName("Rishii");
		Address address = new Address("sahadaraaa", "Delhi");
//		address.employee = e;
		e.setAddress(address);

//		session.persist(address);
		session.persist(e);
//		Employee e1 = new Employee();
//		e1.setFirstName("Mihir");
//		e1.setLastName("binoli");
//		Address address1 = new Address("lucknow", "Kanpur");
//		address1.employee = e1;
//		e1.setAddress(address1);;

//		session.persist(address1);
//		session.persist(e1);
		transaction.commit();
	}

}


