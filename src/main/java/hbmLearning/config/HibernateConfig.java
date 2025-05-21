package hbmLearning.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConfig {

	public static SessionFactory getSessionFactory() {
		return new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate1.cfg.xml").build())
				.getMetadataBuilder().build().buildSessionFactory();
	}

}
