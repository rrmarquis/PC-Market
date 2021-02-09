package util2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;

import datamodel2.CPU;
import datamodel2.Followed_CPU;
import datamodel2.Followed_GPU;
import datamodel2.Followed_Hard_Drive;
import datamodel2.Followed_Motherboard;
import datamodel2.Followed_RAM;
import datamodel2.GPU;
import datamodel2.Hard_Drive;
import datamodel2.Listing;
import datamodel2.Motherboard;
import datamodel2.RAM;
import datamodel2.Sold_CPU;
import datamodel2.Sold_GPU;
import datamodel2.Sold_Hard_Drive;
import datamodel2.Sold_Motherboard;
import datamodel2.Sold_RAM;
import datamodel2.User;

public class SellUtil {
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
	
	public static void listCPU(Integer sellerID,  
			  String modelNa, 
			  String cores, 
			  String freq, 
			  String socketC, 
			  String price) {
		listPart(sellerID, modelNa, "CPU", price);
		int id = findID();
		
		org.hibernate.Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			session.save(new CPU(id, modelNa, 
				  cores, freq, socketC, price, sellerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		executeCPUFollowings(id, cores, freq, socketC, price);
	}
	
	public static void listGPU(Integer sellerID,  
			  String modelNa, 
			  String clockSpeed, 
			  String interf, 
			  String memory, 
			  String price) {
		listPart(sellerID, modelNa, "GPU", price);
		int id = findID();
		
		org.hibernate.Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(new GPU(id, modelNa, 
				  clockSpeed, interf, memory, price, sellerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		executeGPUFollowings(id, clockSpeed, interf, memory, price);
	}
	
	public static void listHardDrive(Integer sellerID, 
			  String modelNa, 
			  String storage, 
			  String rpm, 
			  String price) {
		listPart(sellerID, modelNa, "Hard Drive", price);
		int id = findID();
		
		org.hibernate.Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			System.out.println(modelNa + " " + storage + " " + rpm);
			session.save(new Hard_Drive(id, modelNa, 
					storage, rpm, price, sellerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		executeHardDriveFollowings(id, storage, rpm, price);
	}
	
	public static void listMotherboard(Integer sellerID,  
			  String modelNa, 
			  String expansion, 
			  String socket, 
			  String price) {
		listPart(sellerID, modelNa, "Motherboard", price);
		int id = findID();
		
		org.hibernate.Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			session.save(new Motherboard(id, modelNa, 
				  expansion, socket, price, sellerID));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		executeMotherboardFollowings(id, expansion, socket, price);
	}
	
	public static void listRAM(Integer sellerID,
			  String modelNa, 
			  String type, 
			  String capacity, 
			  String speed, 
			  String price) {
		listPart(sellerID, modelNa, "RAM", price);
		int id = findID();
		
		org.hibernate.Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			System.out.println("Listing RAM");
			session.save(new RAM(id, modelNa, 
				  type, capacity, speed, price, sellerID));
			System.out.println("Completed listing RAM");
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		executeRAMFollowings(id, type, capacity, speed, price);
	}
	
	public static void listPart(Integer sellerID, String modelNa, String modelType, String price) {
		org.hibernate.Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		     
		   session.save(new Listing(modelNa, modelType, price, sellerID));
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
	
	public static Integer findID() {
		Integer id = null;
		
		org.hibernate.Session session = getSessionFactory().openSession();
	    Transaction tx = null;
	   
	    try {
		    tx = session.beginTransaction();
		    List<?> result = session.createSQLQuery("SELECT max(id) FROM listing").list();
		    id = (Integer) result.get(0);
		    tx.commit();
	    } catch (HibernateException he) {
		    if (tx != null) {
		 	    tx.rollback();
		    }
		    he.printStackTrace();
	    } finally {
			 session.close();
		}
	    
	    return id;
	}
	
	public static List<Sold_CPU> getSoldCPUs(String freq, String cores, String socketC) {
		   List<Sold_CPU> resultList = new ArrayList<Sold_CPU>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM Sold_CPU WHERE cores = '" + cores + "' AND frequency = '" + freq + "' AND socket = '" + socketC + "'").list();
				for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
					Sold_CPU cpu= (Sold_CPU) iterator.next();
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
	
	public static List<Sold_GPU> getSoldGPUs(String clockSpeed, String interf, String memory) {
		   List<Sold_GPU> resultList = new ArrayList<Sold_GPU>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM Sold_GPU WHERE clockSpeed = '" + clockSpeed + "' AND interf = '" + interf + "' AND memory = '" + memory + "'").list();
				System.out.println(Listing.size());
				for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
					Sold_GPU GPU= (Sold_GPU) iterator.next();
					resultList.add(GPU);
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
	
	public static List<Sold_Hard_Drive> getSoldHardDrives(String rpm, String storage) {
		   List<Sold_Hard_Drive> resultList = new ArrayList<Sold_Hard_Drive>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM Sold_Hard_Drive WHERE rpm = '" + rpm + "' AND storage = '" + storage + "'").list();
				for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
					Sold_Hard_Drive Hard_Drive= (Sold_Hard_Drive) iterator.next();
					resultList.add(Hard_Drive);
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
	
	public static List<Sold_Motherboard> getSoldMotherboards(String expansionSlots, String socket) {
		   List<Sold_Motherboard> resultList = new ArrayList<Sold_Motherboard>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM Sold_Motherboard WHERE expansion_slots = '" + expansionSlots + "' AND socket = '" + socket + "'").list();
				for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
					Sold_Motherboard motherboard= (Sold_Motherboard) iterator.next();
					resultList.add(motherboard);
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
	
	public static List<Sold_RAM> getSoldRAM(String type, String capacity, String speed) {
		   List<Sold_RAM> resultList = new ArrayList<Sold_RAM>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				List<?> Listing = session.createQuery("FROM Sold_RAM WHERE type = '" + type + "' AND capacity = '" + capacity + "' AND speed = '" + speed + "'").list();
				for (Iterator<?> iterator = Listing.iterator(); iterator.hasNext();) {
					Sold_RAM ram = (Sold_RAM) iterator.next();
					resultList.add(ram);
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
	
	public static String getCPUsSoldJSON(String frequency, String cores, String socket) {
		   List<Sold_CPU> cpus = getSoldCPUs(frequency, cores, socket);
		   Map<Object,Object> map = null;
		   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

		   for (Sold_CPU cpu : cpus) {
		   	map = new HashMap<Object, Object>();
		   	map.put("label", cpu.getDateSold());
		   	map.put("y", Integer.parseInt(cpu.getPrice()));
		   	list.add(map);
		   }
		   	
		   Gson gsonObj = new Gson();
		   String dataPoints = gsonObj.toJson(list);
		   return dataPoints;
	   }
	   
	   public static String getGPUsSoldJSON(String clockSpeed, String interf, String memory) {
		   List<Sold_GPU> gpus = getSoldGPUs(clockSpeed, interf, memory);
		   Map<Object,Object> map = null;
		   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
	
		   for (Sold_GPU gpu : gpus) {
		   	map = new HashMap<Object, Object>();
		   	map.put("label", gpu.getDateSold());
		   	map.put("y", Integer.parseInt(gpu.getPrice()));
		   	list.add(map);
		   }
		   	
		   Gson gsonObj = new Gson();
		   String dataPoints = gsonObj.toJson(list);
		   return dataPoints;
	   }
	   
	   public static String getHardDrivesSoldJSON(String rpm, String storage) {
		   List<Sold_Hard_Drive> HardDrives = getSoldHardDrives(rpm, storage);
		   Map<Object,Object> map = null;
		   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

		   for (Sold_Hard_Drive HardDrive : HardDrives) {
		   	map = new HashMap<Object, Object>();
		   	map.put("label", HardDrive.getDateSold());
		   	map.put("y", Integer.parseInt(HardDrive.getPrice()));
		   	list.add(map);
		   }
		   	
		   Gson gsonObj = new Gson();
		   String dataPoints = gsonObj.toJson(list);
		   return dataPoints;
	   }
	   
	   public static String getMotherboardsSoldJSON(String expansionSlots, String socket) {
		   List<Sold_Motherboard> Motherboards = getSoldMotherboards(expansionSlots, socket);
		   Map<Object,Object> map = null;
		   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

		   for (Sold_Motherboard Motherboard : Motherboards) {
		   	map = new HashMap<Object, Object>();
		   	map.put("label", Motherboard.getDateSold());
		   	map.put("y", Integer.parseInt(Motherboard.getPrice()));
		   	list.add(map);
		   }
		   	
		   Gson gsonObj = new Gson();
		   String dataPoints = gsonObj.toJson(list);
		   return dataPoints;
	   }
	   
	   public static String getRAMsSoldJSON(String type, String capacity, String speed) {
		   List<Sold_RAM> RAMs = getSoldRAM(type, capacity, speed);
		   Map<Object,Object> map = null;
		   List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

		   for (Sold_RAM RAM : RAMs ) {
		   	map = new HashMap<Object, Object>();
		   	map.put("label", RAM.getDateSold());
		   	map.put("y", Integer.parseInt(RAM.getPrice()));
		   	list.add(map);
		   }
		   	
		   Gson gsonObj = new Gson();
		   String dataPoints = gsonObj.toJson(list);
		   return dataPoints;
	   }
	   
	   public static void executeCPUFollowings(Integer listingID, String cores, String frequency, String socket, String price) {
		   List<String> userEmails = new ArrayList<String>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				Query query = session.createQuery("UPDATE Followed_CPU SET listing_id = " + listingID.toString() + " WHERE frequency = '" + frequency + "' AND cores = '" + cores + "' AND socket = '" + socket + "' AND price >= '" + price + "'");
				query.executeUpdate();
				List<?> followings = session.createQuery("FROM Followed_CPU WHERE frequency = '" + frequency + "' AND cores = '" + cores + "' AND socket = '" + socket + "' AND price >= '" + price + "'").list();
				List<Integer> followerIDs = new ArrayList<Integer>();
				for (Iterator<?> iterator = followings.iterator(); iterator.hasNext();) {
					Followed_CPU cpu = (Followed_CPU) iterator.next();
					followerIDs.add(cpu.getFollowerID());
				}
				for (Integer followerID : followerIDs) {
					List<?> users = session.createQuery("FROM User WHERE id = '" + followerID + "'").list();
					for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
						User user = (User) iterator.next();
						userEmails.add(user.getEmail());
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
			
			for (String email : userEmails) {
				System.out.println("Sending email to :" + email);
				sendFollowNotification(email);
			}
	   }
	   
	   public static void executeGPUFollowings(Integer id, String clockSpeed, String interf, String memory, String price) {
		   List<String> userEmails = new ArrayList<String>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				Query query = session.createQuery("UPDATE Followed_GPU SET listing_id = " + id.toString() + " WHERE interf = '" + interf + "' AND memory = '" + memory + "' AND clockSpeed = '" + clockSpeed + "' AND price >= '" + price + "'");
				query.executeUpdate();
				List<?> followings = session.createQuery("FROM Followed_GPU WHERE interf = '" + interf + "' AND memory = '" + memory + "' AND clockSpeed = '" + clockSpeed + "' AND price >= '" + price + "'").list();
				List<Integer> followerIDs = new ArrayList<Integer>();
				for (Iterator<?> iterator = followings.iterator(); iterator.hasNext();) {
					Followed_GPU gpu = (Followed_GPU) iterator.next();
					followerIDs.add(gpu.getFollowerID());
				}
				for (Integer followerID : followerIDs) {
					List<?> users = session.createQuery("FROM User WHERE id = '" + followerID + "'").list();
					for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
						User user = (User) iterator.next();
						userEmails.add(user.getEmail());
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
			
			for (String email : userEmails) {
				System.out.println("Sending email to :" + email);
				sendFollowNotification(email);
			}
	   }
	   
	   public static void executeHardDriveFollowings(Integer id, String rpm, String storage, String price) {
		   List<String> userEmails = new ArrayList<String>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				Query query = session.createQuery("UPDATE Followed_Hard_Drive SET listing_id = " + id.toString() + " WHERE rpm = '" + rpm + "' AND storage = '" + storage + "' AND price >= '" + price + "'");
				query.executeUpdate();
				List<?> followings = session.createQuery("FROM Followed_Hard_Drive WHERE rpm = '" + rpm + "' AND storage = '" + storage + "' AND price >= '" + price + "'").list();
				List<Integer> followerIDs = new ArrayList<Integer>();
				for (Iterator<?> iterator = followings.iterator(); iterator.hasNext();) {
					Followed_Hard_Drive hardDrive = (Followed_Hard_Drive) iterator.next();
					followerIDs.add(hardDrive.getFollowerID());
				}
				for (Integer followerID : followerIDs) {
					List<?> users = session.createQuery("FROM User WHERE id = '" + followerID + "'").list();
					for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
						User user = (User) iterator.next();
						userEmails.add(user.getEmail());
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
			
			for (String email : userEmails) {
				System.out.println("Sending email to :" + email);
				sendFollowNotification(email);
			}
	   }
	   
	   public static void executeMotherboardFollowings(Integer id, String expansionSlots, String socket, String price) {
		   List<String> userEmails = new ArrayList<String>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				Query query = session.createQuery("UPDATE Followed_Motherboard SET listing_id = " + id.toString() + " WHERE expansion_slots = '" + expansionSlots + "' AND socket = '" + socket + "' AND price >= '" + price + "'");
				query.executeUpdate();
				List<?> followings = session.createQuery("FROM Followed_Motherboard WHERE expansion_slots = '" + expansionSlots + "' AND socket = '" + socket + "' AND price >= '" + price + "'").list();
				List<Integer> followerIDs = new ArrayList<Integer>();
				for (Iterator<?> iterator = followings.iterator(); iterator.hasNext();) {
					Followed_Motherboard motherboard = (Followed_Motherboard) iterator.next();
					followerIDs.add(motherboard.getFollowerID());
				}
				List<?> followings2 = session.createQuery("FROM Followed_Motherboard").list();
				for (Iterator<?> iterator = followings2.iterator(); iterator.hasNext();) {
					Followed_Motherboard motherboard = (Followed_Motherboard) iterator.next();
					System.out.println(motherboard.getExpansionSlots() + " = " + expansionSlots);
					System.out.println(motherboard.getSocket() + " = " + socket);
					System.out.println(motherboard.getPrice() + " >= " + price);
				}
				for (Integer followerID : followerIDs) {
					List<?> users = session.createQuery("FROM User WHERE id = '" + followerID + "'").list();
					for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
						User user = (User) iterator.next();
						userEmails.add(user.getEmail());
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
			
			for (String email : userEmails) {
				System.out.println("Sending email to :" + email);
				sendFollowNotification(email);
			}
	   }
	   
	   public static void executeRAMFollowings(Integer id, String capacity, String type, String speed, String price) {
		   List<String> userEmails = new ArrayList<String>();

			org.hibernate.Session session = getSessionFactory().openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				Query query = session.createQuery("UPDATE Followed_RAM SET listing_id = " + id.toString() + " WHERE type = '" + type + "' AND capacity = '" + capacity + "' AND speed = '" + speed + "' AND price >= " + price);
				query.executeUpdate();
				List<?> followings = session.createQuery("FROM Followed_RAM WHERE type = '" + type + "' AND capacity = '" + capacity + "' AND speed = '" + speed + "' AND price >= '" + price + "'").list();
				List<Integer> followerIDs = new ArrayList<Integer>();
				for (Iterator<?> iterator = followings.iterator(); iterator.hasNext();) {
					Followed_RAM ram = (Followed_RAM) iterator.next();
					followerIDs.add(ram.getFollowerID());
				}
				for (Integer followerID : followerIDs) {
					List<?> users = session.createQuery("FROM User WHERE id = '" + followerID + "'").list();
					for (Iterator<?> iterator = users.iterator(); iterator.hasNext();) {
						User user = (User) iterator.next();
						userEmails.add(user.getEmail());
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
			
			for (String email : userEmails) {
				System.out.println("Sending email to :" + email);
				sendFollowNotification(email);
			}
	   }
	   
	   public static void sendFollowNotification(String to) {
	        String from = "PCMarketBiz@gmail.com";
	        String host = "smtp.gmail.com";

	        Properties properties = System.getProperties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");

	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("PCMarketBiz@gmail.com", "PCMarket1234");
	            }
	        });
	        session.setDebug(true);

	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            message.setSubject("Buy Now!");
	            message.setText("One of your followed parts has been listed! Visit the site now to buy!");

	            System.out.println("sending...");
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	   }
}
