package util;


import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.hibernate.Transaction;

import dao.PersonDao;
import entity.Person;



public class Main {

	public static void main(String[] args) throws Exception {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		
		try {
			
			tx=session.beginTransaction();
			for(int i=0;i<100;i++) {
				session.save(new Person(i,"John"+i,"Smith"+i));
			
			if(i%30==0) {
				session.flush();
				session.clear();
			}
			
			}
			
			tx.commit();
			
			
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
