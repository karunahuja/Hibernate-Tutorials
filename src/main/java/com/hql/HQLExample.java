package com.hql;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {
	
	public static void main(String[] args) {
		
		
		
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    
	    SessionFactory factory=cfg.buildSessionFactory();
	    

		
		Session s=factory.openSession();
	    
	    
	    String query="from Student as s where s.city=:x and s.name=:n ";
	    
	    Query q=s.createQuery(query);
	    
	    q.setParameter("x","sangrur");
	    q.setParameter("n", "kaku");
	    //single=(Unique)
	    //multiple-list
	    
	    List<Student> list=((org.hibernate.query.Query) q).list();
	    
	    
	    for(Student student:list) {
	    	System.out.println(student.getName());
	    	System.out.println(student.getCity());
	    }
	    
	    
	    Transaction tx=s.beginTransaction();
		
	    //delete query
	    Query q2=s.createQuery("delete from Student as s where s.city=:c");
	    
	    q2.setParameter("c", "sangrur");
	    
	    int r=q2.executeUpdate();
	    
	    System.out.print("Deleted");
	    System.out.println(r);
//	    
//	    
	    
	    //update query
	    
	   Query q2= s.createQuery("update Student set city=:c where name=:n");
	    
	    q2.setParameter("c","Chandigarh");
	    q2.setParameter("n","kaku");
	    
	    int r=q2.executeUpdate();
	    
	   System.out.println("objects updated");
	   
	   
	    
	    //Join query
	   
	   Query q3=s.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a ");

	   List<Object []> list3=q3.getResultList();
	   
	   for(Object[] arr:list3) {
		   System.out.println(Arrays.toString(arr));
	   }
	    
	    tx.commit();
	    
	    
	    s.close();
	    factory.close();
	    
	    
	    
	}
	

}
