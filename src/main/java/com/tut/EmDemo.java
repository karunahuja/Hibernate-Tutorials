package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory=cfg.buildSessionFactory();
        
        Student student1=new Student();
        student1.setId(1234);
        student1.setName("kaku");
        student1.setCity("sangrur");
		
        Certificate certificate=new Certificate();
        certificate.setCourse("Android");
		certificate.setDuration("2 month");
		student1.setCerti(certificate);
		
		
		
		   Student student2=new Student();
	        student2.setId(1214);
	        student2.setName("Ravi");
	        student2.setCity("sangrur");
			
	        Certificate certificate1=new Certificate();
	        certificate1.setCourse("Java");
			certificate1.setDuration("3 month");
		student2.setCerti(certificate1);

		
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(student1);
		s.save(student2);
		
        tx.commit();
       
        
        s.close();
        
        System.out.println("Done");
        
			
	}

}
