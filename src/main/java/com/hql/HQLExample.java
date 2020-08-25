package com.hql;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.map.Project;

public class HQLExample {
	
	public static void main(String[] args) {
		
		
		
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    
	    SessionFactory factory=cfg.buildSessionFactory();
	    

		
		Session s=factory.openSession();
	    
	    
	    String query="from Project where pid=:x";
	    
	    Query q=s.createQuery(query);
	    
	    q.setParameter("x", 14213);
	    //single=(Unique)
	    //multiple-list
	    
	    List<Project> list=((org.hibernate.query.Query) q).list();
	    
	    
	    for(Project student:list) {
	    	System.out.println(student.getProjectName());
	    }
	    
	    
	    
	}
	

}
