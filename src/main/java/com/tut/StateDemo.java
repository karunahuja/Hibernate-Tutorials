package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
public static void main(String[] args) {
	
	
	
	Configuration cfg=new Configuration();
    cfg.configure("hibernate.cfg.xml");
    
    SessionFactory factory=cfg.buildSessionFactory();
    
    Student student=new Student();
    student.setId(12);
    student.setName("kaku");
    student.setCity("sangrur");
	
    Certificate certificate1=new Certificate();
    certificate1.setCourse("Android1");
	certificate1.setDuration("month");
	student.setCerti(certificate1);
	
	
	
	
	
	Session s=factory.openSession();
	Transaction tx=s.beginTransaction();
	
	s.save(student);

	student.setName("joy");
	
    tx.commit();
   
    
    s.close();
    
    student.setName("sak");
    
    
    System.out.println("Done");
    
	
	
}
}
