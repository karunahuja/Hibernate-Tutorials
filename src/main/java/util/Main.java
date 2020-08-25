package util;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.Filter;

import entity.Person;



public class Main {

	public static void main(String[] args) throws Exception {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		
		try {
			
			tx=session.beginTransaction();
			
			Filter filter=session.enableFilter("personFilter");
			
			filter.setParameter("idParam",5);
			
			List<Object []> list3=session.createQuery("from Person").list();
			 
			   
			   for(Object[] arr:list3) {
				   System.out.println(Arrays.toString(arr));
			   }
				
			   
			
			session.disableFilter("personFilter");
			

			
		}
		catch(HibernateException exc){
			
			tx.rollback();
			
		}
		finally {
			session.close();
			System.exit(0);
		}
				
		
	}

}
