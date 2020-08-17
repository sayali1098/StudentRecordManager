package dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Admin;
import utility.HibernateConnectionManager;


public class AdminDAO implements AdminInterface
{
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();
	 
	public int signUp(Admin admin) 
	{
		 Session session = this.sessionFactory.openSession();
	     Transaction transaction = session.beginTransaction();  
	        if(session.save(admin)!=null)
	        {
		        transaction.commit();
		        session.close();
		        return 1;
	        }
	        else 
	        {
	        	return 0;  
	        }
	}
	
	
	public boolean loginAdmin(Admin admin) {
		Session session = this.sessionFactory.openSession();
	     Transaction tx = null;
	     
	     try 
	     {
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Admin where email='"+admin.getEmail()+"'"+"and password ='"+admin.getPassword()+"'");
			 admin = (Admin)query.uniqueResult();
			 tx.commit();
	     }
	     catch(Exception e) 
	     {
	    	 if (tx != null) 
	    	 {
	    		 tx.rollback();
	         }
	         e.printStackTrace(); 	
	     }
	     finally 
	     {
	         session.close();
	     }
	     return true;
	}

}
