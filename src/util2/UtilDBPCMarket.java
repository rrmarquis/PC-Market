/**
 */
package util2;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import datamodel2.*;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDBPCMarket {
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
	
	public static List<Listing> listListings() {
		List<Listing> resultList = new ArrayList<Listing>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Listing").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Listing allListings = (Listing) iterator.next();
				resultList.add(allListings);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				try {
					tx.rollback();
				} catch (Exception re) {
					System.out.println("Error while attempting to rollback");
					re.printStackTrace();
				}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
   
   public static void clearDB() {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
		
	   try {
		   tx = session.beginTransaction();
		   
		   SQLQuery query13 = session.createSQLQuery("TRUNCATE TABLE user");
		   query13.executeUpdate();
		   SQLQuery query1 = session.createSQLQuery("TRUNCATE TABLE listing");
		   query1.executeUpdate();
		   SQLQuery query12 = session.createSQLQuery("TRUNCATE TABLE sold_listing");
		   query12.executeUpdate();
		   SQLQuery query2 = session.createSQLQuery("TRUNCATE TABLE cpu");
		   query2.executeUpdate();
		   SQLQuery query3 = session.createSQLQuery("TRUNCATE TABLE gpu");
		   query3.executeUpdate();
		   SQLQuery query4 = session.createSQLQuery("TRUNCATE TABLE hard_drive");
		   query4.executeUpdate();
		   SQLQuery query5 = session.createSQLQuery("TRUNCATE TABLE motherboard");
		   query5.executeUpdate();
		   SQLQuery query11 = session.createSQLQuery("TRUNCATE TABLE ram");
		   query11.executeUpdate();
		   SQLQuery query6 = session.createSQLQuery("TRUNCATE TABLE sold_cpu");
		   query6.executeUpdate();
		   SQLQuery query7 = session.createSQLQuery("TRUNCATE TABLE sold_gpu");
		   query7.executeUpdate();
		   SQLQuery query8 = session.createSQLQuery("TRUNCATE TABLE sold_hard_drive");
		   query8.executeUpdate();
		   SQLQuery query9 = session.createSQLQuery("TRUNCATE TABLE sold_motherboard");
		   query9.executeUpdate();
		   SQLQuery query10 = session.createSQLQuery("TRUNCATE TABLE sold_ram");
		   query10.executeUpdate();
		   SQLQuery query14 = session.createSQLQuery("TRUNCATE TABLE followed_cpu");
		   query14.executeUpdate();
		   SQLQuery query15 = session.createSQLQuery("TRUNCATE TABLE followed_gpu");
		   query15.executeUpdate();
		   SQLQuery query16 = session.createSQLQuery("TRUNCATE TABLE followed_hard_drive");
		   query16.executeUpdate();
		   SQLQuery query17 = session.createSQLQuery("TRUNCATE TABLE followed_motherboard");
		   query17.executeUpdate();
		   SQLQuery query18 = session.createSQLQuery("TRUNCATE TABLE followed_ram");
		   query18.executeUpdate();
		   tx.commit();
	   } catch (HibernateException e) {
		   if (tx != null)
			   tx.rollback();
		   e.printStackTrace();
	   } finally {
		   session.close();
	   }
	   
	   AccountsUtil.createUser("pcmarketuser1", "pcmarketuser1@gmail.com", "pcmarket");
       AccountsUtil.createUser("pcmarketuser2", "pcmarketuser2@gmail.com", "pcmarket");
   }
   
   public static CPU getCPU(Integer partID) {
	   List<CPU> result = new ArrayList<CPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM CPU WHERE id = " + partID.toString()).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				CPU cpu = (CPU) iterator.next();
				result.add(cpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
   
   public static GPU getGPU(Integer partID) {
	   List<GPU> result = new ArrayList<GPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM GPU WHERE id = " + partID.toString()).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				GPU gpu = (GPU) iterator.next();
				result.add(gpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
   
   public static Hard_Drive getHardDrive(Integer partID) {
	   List<Hard_Drive> result = new ArrayList<Hard_Drive>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Hard_Drive WHERE id = " + partID.toString()).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Hard_Drive hardDrive= (Hard_Drive) iterator.next();
				result.add(hardDrive);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
   
   public static Motherboard getMotherboard(Integer partID) {
	   List<Motherboard> result = new ArrayList<Motherboard>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Motherboard WHERE id = " + partID.toString()).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Motherboard motherboard= (Motherboard) iterator.next();
				result.add(motherboard);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
   
   public static RAM getRAM(Integer partID) {
	   List<RAM> result = new ArrayList<RAM>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM RAM WHERE id = " + partID.toString()).list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				RAM ram = (RAM) iterator.next();
				result.add(ram);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result.get(0);
   }
}
