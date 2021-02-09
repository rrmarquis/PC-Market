package util2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel2.Followed_CPU;
import datamodel2.Followed_GPU;
import datamodel2.Followed_Hard_Drive;
import datamodel2.Followed_Motherboard;
import datamodel2.Followed_RAM;

public class FollowUtil {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public static void followCPU( 
			  String cores, 
			  String freq, 
			  String socketC, 
			  String price, 
			  Integer followerID) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(new Followed_CPU(freq, cores, socketC, price, followerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void followGPU(  
			  String clockSpeed, 
			  String interf, 
			  String memory, 
			  String price,
			  Integer followerID) {		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(new Followed_GPU(clockSpeed, interf, memory, price, followerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void followHardDrive( 
			  String storage, 
			  String rpm, 
			  String price,
			  Integer followerID) {		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(new Followed_Hard_Drive(storage, rpm, price, followerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void followMotherboard(  
			  String expansion, 
			  String socket, 
			  String price,
			  Integer followerID) {		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			System.out.println(expansion + " " + socket);
			session.save(new Followed_Motherboard(expansion, socket, price, followerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void followRAM(
			  String type, 
			  String capacity, 
			  String speed, 
			  String price, 
			  Integer followerID) {		
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(new Followed_RAM(type, capacity, speed, price, followerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
