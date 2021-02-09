package util2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel2.User;
import datamodel2.Followed_CPU;
import datamodel2.Followed_GPU;
import datamodel2.Followed_Hard_Drive;
import datamodel2.Followed_Motherboard;
import datamodel2.Followed_RAM;
import datamodel2.Listing;
import datamodel2.Sold_CPU;
import datamodel2.Sold_GPU;
import datamodel2.Sold_Listing;

public class AccountsUtil {
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
	
	public static Integer loginUser(String email, String password) {
		Integer userID = null;
		
	    Session session = getSessionFactory().openSession();
	    Transaction tx = null;
	   
	    try {
		    tx = session.beginTransaction();
		    List<?> result = session.createSQLQuery("SELECT id FROM user WHERE email = '" + email + "' AND password = '" + password + "'").list();
		    if (result.size() > 0) {
		    	userID = (Integer) result.get(0);
		    }
		    tx.commit();
	    } catch (HibernateException he) {
		    if (tx != null) {
		  	   tx.rollback();
		    }  
		    he.printStackTrace();
	    } finally {
	 		 session.close();
		 }
	   
	   return userID;
	}
	
	public static boolean isEmailInUse(String email) {
		boolean emailInUse = false;
		
		Session session = getSessionFactory().openSession();
	    Transaction tx = null;
	   
	    try {
		    tx = session.beginTransaction();
		    List<?> result = session.createQuery("FROM User WHERE email = '" + email + "'").list();
		    if (result.size() > 0) {
		    	emailInUse = true;
		    }
		    tx.commit();
	    } catch (HibernateException he) {
		    he.printStackTrace();
	    } finally {
	 		 session.close();
		 }
	   
	   return emailInUse;
	}
	
	public static int createUser(String name, String email, String password) {
		int newUserID = 0;
		
		Session session = getSessionFactory().openSession();
	    Transaction tx = null;
	   
	    try {
		    tx = session.beginTransaction();
		    session.save(new User(email, name, password));
		    List<?> result = session.createSQLQuery("SELECT max(id) FROM user").list();
		    newUserID = (Integer) result.get(0);
		    tx.commit();
	    } catch (HibernateException he) {
		    if (tx != null) {
		 	    tx.rollback();
		    }
		    he.printStackTrace();
	    } finally {
			 session.close();
		}
	    
	    return newUserID;
	}
	
	public static User getUser(Integer userID) {
		List<User> resultList = new ArrayList<User>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> users = session.createQuery("FROM User where id = '" + userID.toString() + "'").list();
			System.out.println("Number of Users: " + users.size());
			for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
				User user = (User) iterator.next();
				resultList.add(user);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList.get(0);
	}
	
	public static List<Listing> getCurrentListings(Integer userID) {
		List<Listing> resultList = new ArrayList<Listing>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> listings = session.createQuery("FROM Listing WHERE sellerID = '" + userID.toString() + "'").list();
			for (Iterator<?> iterator = listings.iterator(); iterator.hasNext();) {
				Listing listing = (Listing) iterator.next();
				resultList.add(listing);
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
	
	public static List<Sold_Listing> getSoldListings(Integer userID) {
		List<Sold_Listing> resultList = new ArrayList<Sold_Listing>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Sold_Listing").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Sold_Listing listing = (Sold_Listing) iterator.next();
				System.out.println("Sold Listing with seller id: " + listing.getSellerID());
				resultList.add(listing);
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
	
	public static List<Sold_Listing> getPurchases(Integer userID) {
		List<Sold_Listing> resultList = new ArrayList<Sold_Listing>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Sold_Listing WHERE sellerID = '" + userID.toString() + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Sold_Listing purchase = (Sold_Listing) iterator.next();
				resultList.add(purchase);
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
	
	public static List<Followed_GPU> getFollowedGPU(Integer userID) {
		List<Followed_GPU> resultList = new ArrayList<Followed_GPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Followed_GPU WHERE follower_id = '" + userID.toString() + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Followed_GPU following = (Followed_GPU) iterator.next();
				resultList.add(following);
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
	
	public static List<Followed_Hard_Drive> getFollowedHardDrive(Integer userID) {
		List<Followed_Hard_Drive> resultList = new ArrayList<Followed_Hard_Drive>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Followed_Hard_Drive WHERE follower_id = '" + userID.toString() + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Followed_Hard_Drive following = (Followed_Hard_Drive) iterator.next();
				resultList.add(following);
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
	
	public static List<Followed_Motherboard> getFollowedMotherboard(Integer userID) {
		List<Followed_Motherboard> resultList = new ArrayList<Followed_Motherboard>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Followed_Motherboard WHERE follower_id = '" + userID.toString() + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Followed_Motherboard following = (Followed_Motherboard) iterator.next();
				resultList.add(following);
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
	
	public static List<Followed_RAM> getFollowedRAM(Integer userID) {
		List<Followed_RAM> resultList = new ArrayList<Followed_RAM>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Followed_RAM WHERE follower_id = '" + userID.toString() + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Followed_RAM following = (Followed_RAM) iterator.next();
				resultList.add(following);
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
	
	public static List<Followed_CPU> getFollowedCPU(Integer userID) {
		List<Followed_CPU> resultList = new ArrayList<Followed_CPU>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM Followed_CPU WHERE follower_id = '" + userID.toString() + "'").list();
			for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
				Followed_CPU following = (Followed_CPU) iterator.next();
				resultList.add(following);
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
}
