package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManager entityManager= createEntityManager();
	
	private static EntityManager createEntityManager() {
		
		
		try {
			

		      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "my-persistence-unit" );
		      
		      return emfactory.createEntityManager( );
			
			
			
		}
		
		catch(Throwable throwable) {
			
			throw new ExceptionInInitializerError(throwable);
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	public static EntityManager getEntityManager() {
		return entityManager;
	}
}
