
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

		save(session1);

		Employee em = session1.get(Employee.class, 1);
		System.out.println("employee:  " + em);
		em.getAddress().forEach(a -> {
			System.out.println("address:  " + a);
		});

		Address add = (Address) session1.get(Address.class, 2);
		System.out.println("addd..." + add);
		System.out.println("add_emp" + add.getEmployee());
		session1.close();
		System.out.println("<<<<<<<<<<<");
	}

	private static void save(Session session) {
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Employee e1 = new Employee();

		e1.setName("Beenu");
		e1.setGender("male");
		Address a1 = new Address("h-430", "Sector 62");
		Address a2 = new Address("h-43", "Sector 63");
		Address a3 = new Address("h-4", "Sector 64");
		Address a4 = new Address("h-40", "Sector 65");
		Address a5 = new Address("h-410", "Sector 66");
		a1.setEmployee(e1);
		a2.setEmployee(e1);
		a3.setEmployee(e1);
		a4.setEmployee(e1);
		a5.setEmployee(e1);
		session.persist(a1);
		session.persist(a2);
		session.persist(a3);
		session.persist(a4);
		session.persist(a5);
		List<Address> ad = new ArrayList<>();
		ad.add(a1);
		ad.add(a2);
		ad.add(a3);
		ad.add(a4);
		ad.add(a5);

		e1.setAddress(ad);

		session.persist(e1);
		transaction.commit();
	}

}
