/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.Motherboard;
import datamodel.All_Listings;
import datamodel.CPU;
import datamodel.GPU;
import datamodel.Hard_Drive;

import org.hibernate.HibernateException;
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
	
	public static List<All_Listings> listAllListings() {
		List<All_Listings> resultList = new ArrayList<All_Listings>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> All_Listings = session.createQuery("FROM All_Listings").list();
			for (Iterator<?> iterator = All_Listings.iterator(); iterator.hasNext();) {
				All_Listings allListings = (All_Listings) iterator.next();
				resultList.add(allListings);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<Motherboard> listMotherboard() {
		List<Motherboard> resultList = new ArrayList<Motherboard>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Mobos = session.createQuery("FROM Motherboard").list();
			for (Iterator<?> iterator = Mobos.iterator(); iterator.hasNext();) {
				Motherboard mobo = (Motherboard) iterator.next();
				resultList.add(mobo);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<CPU> listCPU() {
		List<CPU> resultList = new ArrayList<CPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> CPU = session.createQuery("FROM CPU").list();
			for (Iterator<?> iterator = CPU.iterator(); iterator.hasNext();) {
				CPU cpu = (CPU) iterator.next();
				resultList.add(cpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	
	public static List<GPU> listGPU() {
		List<GPU> resultList = new ArrayList<GPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> GPU = session.createQuery("FROM GPU").list();
			for (Iterator<?> iterator = GPU.iterator(); iterator.hasNext();) {
				GPU gpu = (GPU) iterator.next();
				resultList.add(gpu);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static List<Hard_Drive> listHardDrive() {
		List<Hard_Drive> resultList = new ArrayList<Hard_Drive>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Hard_Drive = session.createQuery("FROM Hard_Drive").list();
			for (Iterator<?> iterator = Hard_Drive.iterator(); iterator.hasNext();) {
				Hard_Drive hardDrive = (Hard_Drive) iterator.next();
				resultList.add(hardDrive);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static void createAll_Listings(String modelNa,
								  String partTy,
								  String price) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new All_Listings(modelNa, partTy, price));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static All_Listings searchAllListings(String partType, String modelName) {
		All_Listings item = null;
		List<All_Listings> items = listAllListings();
		for(All_Listings i : items) {
			if(partType.compareTo(i.getPartType()) == 0 && modelName.compareTo(i.getModelName()) == 0) {
				item = i;
				break;
			}
		}
		return item;
	}
	
	public static void createCPUs(String manufacturer, 
								  String modelNa, 
								  String cores, 
								  String freq, 
								  String socketC, 
								  String price) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(new CPU(manufacturer, modelNa, 
	        		 			  cores, freq, socketC, price));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	   }
	
	   public static void createGPUs(String manufacturer, 
			   						 String modelNa, 
			   						 String port, 
			   						 String interf, 
			   						 String memory, 
			   						 String price) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         session.save(new GPU(manufacturer, modelNa, 
	        		 			  port, interf, memory, price));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
      }
		
		public static void createHard_Drives(String manufacturer, 
											 String modelNa, 
											 String storage, 
											 String rpm, 
											 String price) {
		    Session session = getSessionFactory().openSession();
		    Transaction tx = null;
		    try {
		       tx = session.beginTransaction();
		       session.save(new Hard_Drive(manufacturer, modelNa, 
		    		   					   storage, rpm, price));
		       tx.commit();
		    } catch (HibernateException e) {
		       if (tx != null)
		          tx.rollback();
		       e.printStackTrace();
		    } finally {
		       session.close();
		    }
	    }
		
	   public static void createMotherboards(String manufacturer, 
			   								 String modelNa, 
			   								 String socket, 
			   								 String expansion, 
			   								 String form, 
			   								 String price) {
		      Session session = getSessionFactory().openSession();
		      Transaction tx = null;
		      try {
		         tx = session.beginTransaction();
		         session.save(new Motherboard(manufacturer, modelNa, 
		        		 					  socket, expansion, form, price));
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx != null)
		            tx.rollback();
		         e.printStackTrace();
		      } finally {
		         session.close();
		      }
		   }

	   public List<Integer> findNextCPUIndex() {
			String query = "SELECT Part_id from Listing";

	        Session session = getSessionFactory().openSession();
	        Transaction tx = null;
	        
	        List<Integer> numListings = new ArrayList<Integer>();

	        try {
	        	tx = session.beginTransaction();
	        	List<?> queryResult = session.createQuery(query).list();
	        	for (int i = 0; i < queryResult.size(); i++) {
	        		numListings.add(((Long) queryResult.get(i)).intValue());

	        	    if (i == (queryResult.size() - 1)) {
	        	        // Last item...
	        	    }
	        	}
	        	
	        	tx.commit();
	        } catch (HibernateException e) {
	        	if (tx != null)
	        		tx.rollback();
	        	e.printStackTrace();
		    } finally {
		    	session.close();
		    }
	        
		    return numListings;
		}
}
