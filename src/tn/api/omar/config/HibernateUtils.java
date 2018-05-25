package tn.api.omar.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

	public static final SessionFactory SESSION_FACTORY;
	public static final ThreadLocal<Session> session = new ThreadLocal<>();

	//HibernateUtil static SessionFactory initializer
	static {
		SessionFactory auxSessionFactory = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			auxSessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.err.println("Initial Session factory creation failed");
			throw new ExceptionInInitializerError(e);
		} finally {
			SESSION_FACTORY = auxSessionFactory;
			session.set(SESSION_FACTORY.openSession());
		}
	}

	//HibernateUtil SESSION_FACTORY Getter
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
