package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {
	public static void main(String[] args) {
		

		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();
	    

		Session s=factory.openSession();
	    
		//sql query
	    String q="Select * from student";
	    
	    NativeQuery nq= s.createSQLQuery(q);
	    
	    List<Object[]> list =nq.list();
	    
	    for(Object[] student:list) {
	    	
	    	
	    	System.out.println(Arrays.deepToString(student));
	    	
	    }
	    
	    
	    
		
		
		
		s.close();
		factory.close();
		
		
	}
	
	
	

}
