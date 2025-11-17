package session43_TestNGAnno;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 	TC1
 	
 	1 - Login --> @BeforeMethod
 	2 - Search --> @Test
 	3 - Logout --> @AfterMethod
 	4 - Login
 	5 - Adv Search --> @Test
 	6 - Logout
 	
 */

public class Annotations 
{
	
	@BeforeMethod 
	void login()
	{
		System.out.println("Login");
	}
	
	
	@AfterMethod
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
