package base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel per1 = new PersonDomainModel();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		per1.setBirthday(new Date(0));
		per1.setCity("Newark");
		per1.setFirstName("Becky");
		per1.setLastName("Gee");
		per1.setPostalCode(12345);
		per1.setStreet("111 Delaware Ave.");
		
		PersonDAL.addPerson(per1);
		
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertNotNull(per2);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		PersonDAL.deletePerson(per1.getPersonID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void GetAllPersonsTest()
	{
		ArrayList<PersonDomainModel> persons = PersonDAL.getPersons();
		assertNotNull(persons);
	}
	
	@Test
	public void UpdatePersonTest()
	{
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		
		assertEquals(per1.getPersonID(), per2.getPersonID());
		
		per2.setFirstName("B.");
		PersonDAL.updatePerson(per2);
		
		PersonDomainModel per3 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per2.getFirstName(), per3.getFirstName());
		assertNotEquals(per1.getFirstName(), per3.getFirstName());
		
		PersonDAL.deletePerson(per2.getPersonID());
	}
	
	@Test
	public void DeletePersonTest()
	{
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDomainModel perx = PersonDAL.getPerson(per1.getPersonID());
		assertNull(perx);
	}

	@Test
	public void AddPerson() {
		
		
		
	}

}