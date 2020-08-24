package com.tut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started" );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        SessionFactory factory=cfg.buildSessionFactory();
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
        Student st=new Student();
        
        st.setId(103);
        st.setName("Karun");
        st.setCity("Sangrur");
        
        
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.34);
        //Reading image
        
        FileInputStream fis=new FileInputStream("src/main/java/IMG_20200101_132029.jpg");
        
        byte[] data=new byte[fis.available()];
        
        fis.read(data);
        ad.setImage(data);
        
        
        System.out.println(st);
        
        Session session=factory.openSession();
        
        Transaction tx=session.beginTransaction();
        
        session.save(st);
        session.save(ad);
        
        tx.commit();
       
        
        session.close();
        
        System.out.println("Done");
        
    }
}
