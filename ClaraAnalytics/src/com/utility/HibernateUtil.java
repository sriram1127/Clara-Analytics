package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hib.entities.Country;
import com.hib.entities.Details;
import com.hib.entities.State;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			conf.addAnnotatedClass(Country.class);
			conf.addAnnotatedClass(Details.class);
			conf.addAnnotatedClass(State.class);

			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

			return conf.buildSessionFactory(sr);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}