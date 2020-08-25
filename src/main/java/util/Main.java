package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

Session session=sessionFactory.openSession();



		
session.close();		
	}

}
