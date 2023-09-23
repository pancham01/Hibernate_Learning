package hbnLearning.Configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;


public class HibernateConfiguration {
	
    public static SessionFactory getSessionFactory() {
        try {
            // Create a StandardServiceRegistryBuilder and configure Hibernate settings
            // Specify JDBC connection properties
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            properties.put(Environment.URL, "jdbc:mysql://localhost:3306/java11");
            properties.put(Environment.USER, "root");
            properties.put(Environment.PASS, "root");
            // Specify dialect
            properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            // Echo all executed SQL to stdout (for debugging)
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.FORMAT_SQL, "true");
            // Apply properties to the registry builder
            StandardServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings
            		(properties).build();
            // Create a MetadataSources and add annotated entity classes
            MetadataSources metadataSources = new MetadataSources(registry);
            metadataSources.addAnnotatedClass(hbmLearning.Entity.Employee.class);
            // Create a SessionFactory
            SessionFactory sessionFactory = metadataSources.buildMetadata().buildSessionFactory();

            return sessionFactory;
        } catch (Exception ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}



