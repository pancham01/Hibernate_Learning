
package hbmLearing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hbmLearning.Entity.Address;
import hbmLearning.Entity.Employee;

public class App {
	public static void main(String[] args) {
		// Create configuration and build session factory
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();

        // Create session
        Session session = factory.openSession();
        session.beginTransaction();

        // Create addresses
        Address address1 = new Address("New York");
        Address address2 = new Address("San Francisco");

        // Create employees
        Employee emp1 = new Employee("John Doe");
        Employee emp2 = new Employee("Jane Smith");

        // Establish many-to-many relationships
        emp1.addAddress(address1);
        emp1.addAddress(address2);

        emp2.addAddress(address1);  // shared address

        // Save employees (cascades addresses)
        session.persist(emp1);
        session.persist(emp2);

        session.getTransaction().commit();
        session.close();

        factory.close();
	}

}
