package util2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel2.CPU;
import datamodel2.Followed_Motherboard;
import datamodel2.GPU;
import datamodel2.Hard_Drive;
import datamodel2.Motherboard;
import datamodel2.RAM;
import datamodel2.Sold_CPU;
import datamodel2.Sold_GPU;
import datamodel2.Sold_Hard_Drive;
import datamodel2.Sold_Listing;
import datamodel2.Sold_Motherboard;
import datamodel2.Sold_RAM;

public class BuyUtil {
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
	
	public static void purchaseListing(Integer userID, String partType, String partID, String price) {
		   Session session1 = getSessionFactory().openSession();
		   Transaction tx1 = null;

			try {
				tx1 = session1.beginTransaction();
				SQLQuery query = session1.createSQLQuery("DELETE FROM listing WHERE id = '" + partID + "'");
				query.executeUpdate();
				tx1.commit();
			} catch (HibernateException e) {
				if (tx1 != null)
					tx1.rollback();
				e.printStackTrace();
			} finally {
				session1.close();
			}
			
		   if (partType.equals("CPU")) {
			   Session session2 = getSessionFactory().openSession();
			   Transaction tx2 = null;

				try {
					tx2 = session2.beginTransaction();
					List<?> Listing = session2.createQuery("FROM CPU WHERE id = " + partID).list();
					CPU soldCPU = (CPU) Listing.get(0);
					session2.save(new Sold_Listing(soldCPU.getId(), "CPU", soldCPU.getModelName(), soldCPU.getPrice(), getDate() ,soldCPU.getSellerID(), userID));
					session2.save(new Sold_CPU(soldCPU.getFreq(), soldCPU.getNumOfCores(), soldCPU.getSocketCompatibility(), soldCPU.getPrice(), getDate(), userID, soldCPU.getSellerID()));
					SQLQuery query1 = session2.createSQLQuery("DELETE FROM cpu WHERE id = '" + partID + "'");
					query1.executeUpdate();
					SQLQuery query2 = session2.createSQLQuery("DELETE FROM followed_cpu WHERE listing_id = '" + partID + "'");
					query2.executeUpdate();
					tx2.commit();
				} catch (HibernateException e) {
					if (tx2 != null)
						tx2.rollback();
					e.printStackTrace();
				} finally {
					session2.close();
				}
		   } else if (partType.equals("GPU")) {
			   Session session2 = getSessionFactory().openSession();
			   Transaction tx2 = null;

				try {
					tx2 = session2.beginTransaction();
					List<?> Listing = session2.createQuery("FROM GPU WHERE id = " + partID).list();
					GPU soldGPU = (GPU) Listing.get(0);
					session2.save(new Sold_Listing(soldGPU.getId(), "GPU", soldGPU.getModelName(), soldGPU.getPrice(), getDate() ,soldGPU.getSellerID(), userID));
					session2.save(new Sold_GPU(soldGPU.getClockSpeed(), soldGPU.getInterfaceType(), soldGPU.getMemorySize(), soldGPU.getPrice(), getDate(), soldGPU.getSellerID(), userID));
					SQLQuery query1 = session2.createSQLQuery("DELETE FROM gpu WHERE id = '" + partID + "'");
					query1.executeUpdate();
					System.out.println("deleting followed motherboard with listing id = " + partID);
					SQLQuery query2 = session2.createSQLQuery("DELETE FROM followed_gpu WHERE listing_id = '" + partID + "'");
					query2.executeUpdate();
					List<?> followedMotherboards = session2.createQuery("FROM Followed_Motherboard").list();
					for (Iterator<?> iterator = followedMotherboards.iterator(); iterator.hasNext();) {
						Followed_Motherboard motherboard = (Followed_Motherboard) iterator.next();
						System.out.println("listingid = " + motherboard.getListingID());
					}
					tx2.commit();
				} catch (HibernateException e) {
					if (tx2 != null)
						tx2.rollback();
					e.printStackTrace();
				} finally {
					session2.close();
				}
		   } else if (partType.equals("Hard Drive")) {
			   Session session2 = getSessionFactory().openSession();
			   Transaction tx2 = null;

				try {
					tx2 = session2.beginTransaction();
					List<?> Listing = session2.createQuery("FROM Hard_Drive WHERE id = " + partID).list();
					Hard_Drive soldHardDrive= (Hard_Drive) Listing.get(0);
					session2.save(new Sold_Listing(soldHardDrive.getId(), "Hard Drive", soldHardDrive.getModelName(), soldHardDrive.getPrice(), getDate() ,soldHardDrive.getSellerID(), userID));
					session2.save(new Sold_Hard_Drive(soldHardDrive.getRotationsPerMinute(),soldHardDrive.getStorageSpace(), soldHardDrive.getPrice(), getDate(), soldHardDrive.getSellerID(), userID));
					SQLQuery query1 = session2.createSQLQuery("DELETE FROM hard_drive WHERE id = '" + partID + "'");
					query1.executeUpdate();
					SQLQuery query2 = session2.createSQLQuery("DELETE FROM followed_hard_drive WHERE listing_id = '" + partID + "'");
					query2.executeUpdate();
					tx2.commit();
				} catch (HibernateException e) {
					if (tx2 != null)
						tx2.rollback();
					e.printStackTrace();
				} finally {
					session2.close();
				}
		   } else if (partType.equals("Motherboard")) {
			   Session session2 = getSessionFactory().openSession();
			   Transaction tx2 = null;

				try {
					tx2 = session2.beginTransaction();
					List<?> Listing = session2.createQuery("FROM Motherboard WHERE id = " + partID).list();
					Motherboard soldMotherboard = (Motherboard) Listing.get(0);
					session2.save(new Sold_Listing(soldMotherboard.getId(), "Motherboard", soldMotherboard.getModelName(), soldMotherboard.getPrice(), getDate() ,soldMotherboard.getSellerID(), userID));
					session2.save(new Sold_Motherboard(soldMotherboard.getExpansionSlots(), soldMotherboard.getSocket(), soldMotherboard.getPrice(), getDate(), soldMotherboard.getSellerID(), userID));
					SQLQuery query1 = session2.createSQLQuery("DELETE FROM motherboard WHERE id = '" + partID + "'");
					query1.executeUpdate();
					SQLQuery query2 = session2.createSQLQuery("DELETE FROM followed_motherboard WHERE listing_id = '" + partID + "'");
					query2.executeUpdate();
					tx2.commit();
				} catch (HibernateException e) {
					if (tx2 != null)
						tx2.rollback();
					e.printStackTrace();
				} finally {
					session2.close();
				}
		   } else {
			   Session session2 = getSessionFactory().openSession();
			   Transaction tx2 = null;

				try {
					tx2 = session2.beginTransaction();
					List<?> Listing = session2.createQuery("FROM RAM WHERE id = " + partID).list();
					RAM soldRAM = (RAM) Listing.get(0);
					session2.save(new Sold_Listing(soldRAM.getId(), "RAM", soldRAM.getModelName(), soldRAM.getPrice(), getDate() ,soldRAM.getSellerID(), userID));
					session2.save(new Sold_RAM(soldRAM.getType(), soldRAM.getCapacity(), soldRAM.getSpeed(), soldRAM.getPrice(), getDate(), soldRAM.getSellerID(), userID));
					SQLQuery query1 = session2.createSQLQuery("DELETE FROM ram WHERE id = '" + partID + "'");
					query1.executeUpdate();
					SQLQuery query2 = session2.createSQLQuery("DELETE FROM followed_ram WHERE listing_id = '" + partID + "'");
					query2.executeUpdate();
					tx2.commit();
				} catch (HibernateException e) {
					if (tx2 != null)
						tx2.rollback();
					e.printStackTrace();
				} finally {
					session2.close();
				}
		   }
	}
	
	public static Integer easyBuyCPU(String cores, String freq, String socketC) {
		   List<CPU> result = new ArrayList<CPU>();

			Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM CPU WHERE price = (SELECT MIN(price) FROM CPU WHERE cores = '" + cores + "' AND frequency = '" + freq + "' AND socket = '" + socketC + "') AND cores = '" + cores + "' AND frequency = '" + freq + "' AND socket = '" + socketC + "'").list();
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
			return result.get(0).getId();
	   }
	
	public static Integer easyBuyGPU(String clockSpeed, String interf, String memory) {
		   List<GPU> result = new ArrayList<GPU>();

			Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM GPU WHERE price = (SELECT MIN(price) FROM GPU WHERE clock_speed = '" + clockSpeed + "' AND interf = '" + interf + "' AND memory = '" + memory + "') AND clock_speed = '" + clockSpeed + "' AND interf = '" + interf + "' AND memory = '" + memory + "'").list();
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
			return result.get(0).getId();
	   }
	
	public static Integer easyBuyHardDrive(String storage, String rpm) {
		   List<Hard_Drive> result = new ArrayList<Hard_Drive>();

			Session session = getSessionFactory().openSession();
			Transaction tx = null;

			System.out.println("hello: " + storage + " " + rpm);
			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM Hard_Drive WHERE price = (SELECT MIN(price) FROM Hard_Drive WHERE storage = '" + storage + "' AND rpm = '" + rpm + "') AND storage = '" + storage + "' AND rpm = '" + rpm + "'").list();
				for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
					Hard_Drive hardDrive = (Hard_Drive) iterator.next();
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
			return result.get(0).getId();
	   }
	
	public static Integer easyBuyMotherboard(String socket, String expansionSlots) {
		   List<Motherboard> result = new ArrayList<Motherboard>();

			Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM Motherboard WHERE price = (SELECT MIN(price) FROM Motherboard WHERE socket = '" + socket + "' AND expansion_slots = '" + expansionSlots + "'").list();
				for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
					Motherboard motherboard = (Motherboard) iterator.next();
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
			return result.get(0).getId();
	   }
	
	public static Integer easyBuyRAM(String type, String capacity, String speed) {
		List<RAM> result = new ArrayList<RAM>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> Listing = session.createQuery("FROM RAM WHERE price = (SELECT MIN(price) FROM Motherboard WHERE type = '" + type + "' AND capacity = '" + capacity + " AND speed = '" + speed + "'").list();
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
		return result.get(0).getId();
	}
	
	private static String getDate() {
		   String calendarString = Calendar.getInstance().getTime().toString();
		   String year = calendarString.substring(calendarString.length() - 5, calendarString.length());
		   String day = calendarString.substring(8, 10);
		   String month = calendarString.substring(4, 7);
		   if (month == "Jan") {
			   month = "01";
		   } else if (month.equals("Feb")) {
			   month = "02";
		   } else if (month.equals("Mar")) {
			   month = "03";
		   } else if (month.equals("Apr")) {
			   month = "04";
		   } else if (month.equals("May")) {
			   month = "05";
		   } else if (month.equals("Jun")) {
			   month = "06";
		   } else if (month.equals("Jul")) {
			   month = "07";
		   } else if (month.equals("Aug")) {
			   month = "08";
		   } else if (month.equals("Sep")) {
			   month = "09";
		   } else if (month.equals("Oct")) {
			   month = "10";
		   } else if (month.equals("Nov")) {
			   month = "11";
		   } else {
			   month = "12";
		   }
		   return year + "-" + month + "-" + day;
	   }
}
