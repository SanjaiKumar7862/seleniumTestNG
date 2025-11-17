package session43_TestNGAnno;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 	TC1
 	
 	1 - Login --> @BeforeClass
 	2 - Search --> @Test
 	3 - Adv Search --> @Test
 	4 - Logout --> @AfterClass
 	
 */

public class Annotations1 
{
	
	@BeforeClass 
	void login()
	{
		System.out.println("Login");
	}
	
	
	@AfterClass
	void logout()
	{
		System.out.println("Logout");
	}
	
	
	@Test(priority=1)
	void search()
	{
		System.out.println("Search");
	}
	
	
	@Test(priority=2)
	void Advsearch()
	{
		System.out.println("Adv Search");
	}
		
}
