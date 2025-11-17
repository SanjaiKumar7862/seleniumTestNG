package session43_TestNGAnnoV1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Annotations 
{
	
	@Test
	void login()
	{
		System.out.println("Login 1");
	}
	
	
	@BeforeTest
	void bt()
	{
		System.out.println("Before Test..");
	}
	
		
}
