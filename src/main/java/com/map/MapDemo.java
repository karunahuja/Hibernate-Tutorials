package com.map;

import java.util.ArrayList;
import java.util.List;

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
	        answer.setAnswerId(1);
	        answer.setAnswer("Java is programming language");
	       answer.setQuestion(q1);
	        
	        
	        Answer answer1=new Answer();
	        answer1.setAnswerId(3);
	        answer1.setAnswer("Java creates applications");
	        answer1.setQuestion(q1);
	        
	        
	        
	        Answer answer2=new Answer();
	        answer2.setAnswerId(5);
	        answer2.setAnswer("Java s applications");
	        answer2.setQuestion(q1);
	        
	        List<Answer> list=new ArrayList<Answer>();
	        list.add(answer);
	        list.add(answer1);
	        list.add(answer2);
	        
	        q1.setAnswers(list);
	        
	        
	      
	        
	        Session session=factory.openSession();
	        
	        Transaction tx=session.beginTransaction();
	        
	        session.save(q1);
	        session.save(answer1);
	        session.save(answer2);
	        
	      
	       
	        
	        tx.commit();
	       
	        
	        session.close();
	        
	        System.out.println("Done");
		
		
	}
	
}
