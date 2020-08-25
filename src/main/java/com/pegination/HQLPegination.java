package com.pegination;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLPegination {

	public static void main(String[] args) {
	
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();
	    

		Session s=factory.openSession();
	    
	    
	    String query="from Student";
	    
	    Query q=s.createQuery(query);
	    
	    //implementing pegination using Hibernate
	    
	    
	    q.setFirstResult(0);
	    q.setMaxResults(5);
	    
	    List<Student> list=((org.hibernate.query.Query) q).list();
	    
	    for(Student st:list) {
	    	
	    	System.out.println(st.getId()+":"+st.getName()+":"+st.getCity());
	    	
	    }
	    
		factory.close();
		
	}
	
	
}
