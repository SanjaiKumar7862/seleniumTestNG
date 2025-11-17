package session43_TestNGAnnoV1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations3 

{
	@Test
	void suite()
	{
		System.out.println("Example of Suites");
	}
	
	
	@BeforeSuite
	void beforesuite()
	{
		System.out.println("Before Test Suite..");
	}
	
	
	@AfterSuite
	void aftersuite()
	{
		System.out.println("After Test Suite..");
	}
	
	
}
