package session43_TestNGAnnoV1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



public class Annotations1 
{
	
	@Test 
	void login()
	{
		System.out.println("Login 2");
	}
	
	
	@AfterTest
	void at()
	{
		System.out.println("After Test..");
	}
	
		
}
