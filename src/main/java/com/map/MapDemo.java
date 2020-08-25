package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		 System.out.println( "Project Started" );
	        Configuration cfg=new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        
	        SessionFactory factory=cfg.buildSessionFactory();
	        	
	        //creating question
	        Question q1=new Question();
	        q1.setQuestion("what is java?");
	        q1.setQuestionId(1212);
	        
	        Answer answer=new Answer();
	        answer.setAnswerId(343);
	        answer.setAnswer("Java is programming language");
	        q1.setAnswer(answer);
	        answer.setQuestion(q1);
	        
	        
	        
	        //creating question
	        Question q2=new Question();
	        q2.setQuestion("what is android?");
	        q2.setQuestionId(242);
	        
	        
	        Answer answer1=new Answer();
	        answer1.setAnswerId(143);
	        answer1.setAnswer("android is programming language");
	        q2.setAnswer(answer1);
	        answer1.setQuestion(q2);
	        
	        
	        Session session=factory.openSession();
	        
	        Transaction tx=session.beginTransaction();
	        
	        session.save(q1);
	        session.save(q2);
	        
	        session.save(answer1);
	        session.save(answer);
	        
	        tx.commit();
	       
	        
	        session.close();
	        
	        System.out.println("Done");
		
		
	}
	
}
