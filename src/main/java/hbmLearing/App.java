package hbmLearing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.MutationQuery;

public class App {

	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = meta.getSessionFactoryBuilder().build();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Staart...");
		
//		Example of HQL to get all the records
//		Query query1=session.createQuery("from Employee");
//		List list=query1.list();  
//		System.out.println(list);
//		
//		HQL to get records with pagination
//		query1.setFirstResult(2);
//		query1.setMaxResults(5);
//		System.out.println(query1.list());
		
		
		
		
//		Query q=session.createQuery("select max(name) from Employee",Employee.class);  
//		List<Integer> list1=q.list();  
//		System.out.println(list1);  
		
		
//		HQL update query Using Named Parameters
//		Query q=session.createQuery("update Employee set name=:n where id=:i");  
//		q.setParameter("n","Pankaj");  
//		q.setParameter("i",1);  
//		System.out.println("status: "+q.executeUpdate());  

//		HQL delete query
		MutationQuery query=session.createMutationQuery("delete from Employee where id = 2");  
		query.executeUpdate();  
		
//		Query query1=session.createQuery("from Employee");
//		List list=query1.list();  
//		System.out.println(list);

		tx.commit();
		session.close();
		sf.close();

	}

}
