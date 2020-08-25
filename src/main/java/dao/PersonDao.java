package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Person;
import util.HibernateUtil;

public class PersonDao {

	
	
	public void savePerson(Person person){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		session.saveOrUpdate(person);
		}
		catch(HibernateException exc){
		tx.rollback();
		exc.printStackTrace();
		}
		finally{
		tx.commit();
		session.close();
		}
		}
		
	
	
	
	
	
	public void deletePerson(Person person){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		session.delete(person);
		}
		catch(HibernateException exc){
		tx.rollback();
		exc.printStackTrace();
		}
		finally{
		tx.commit();
		session.close();
		}
		}
		}
	
	

