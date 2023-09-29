
package hbmLearing;

import java.util.ArrayList;
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
//		fetchAllEmployees(session1);

		Employee em =  session1.get(Employee.class, 1);
		System.out.println("employee:  "+em);
		em.getAddress().forEach(a -> {
			System.out.println("address:  "+a);
		});
//		Address add = (Address) session1.get(Address.class, 1);
//		System.out.println("addd..."+add);
//		System.out.println("add_emp"+add.getEmployee());
//		fetchAllAddress(session1);
		System.out.println("<<<<<<<<<<<");
	}



	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Address a1 = new Address("h-430", "Sector 62");
		Address a2 = new Address("h-43", "Sector 63");
		Address a3 = new Address("h-4", "Sector 64");
		Address a4 = new Address("h-40", "Sector 65");
		Address a5 = new Address("h-410", "Sector 66");
		List<Address> ad = new ArrayList<>();
		ad.add(a1);
		ad.add(a2);
		ad.add(a3);
		ad.add(a4);
		ad.add(a5);
		Employee e1 = new Employee();

		e1.setName("Beenu");
		e1.setGender("male");
		e1.setAddress(ad);
		session.persist(e1);
		transaction.commit();
	}

}
