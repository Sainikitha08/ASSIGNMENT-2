package com.dxc.util1;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



public class HibernateUtil1 {
	
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			
		}catch(Exception ex) {
			System.err.println("Session factory could not be created."+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}