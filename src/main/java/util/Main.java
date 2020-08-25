package util;


import org.hibernate.Session;
import org.hibernate.SessionFactorl;

import dao.PersonDao;
import entity.Person;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person person=new Person(1, "John","Smith");
		
		PersonDao personDao=new PersonDao();
		
		personDao.savePerson(person);
		
		person.setLastName("Dao");
		
		personDao.savePerson(person);
		
		personDao.deletePerson(person);
	
				
	}

}
