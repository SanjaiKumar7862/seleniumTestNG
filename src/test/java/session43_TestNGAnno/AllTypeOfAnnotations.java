package session43_TestNGAnno;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllTypeOfAnnotations 
{
	@BeforeSuite
	void beforesuite()
	{
		System.out.println("This is before suite..");
	}
	
	@AfterSuite
	void aftersuite()
	{
		System.out.println("This is after suite..");
	}
	
	@BeforeTest
	void beforetest()
	{
		System.out.println("This is before test..");
	}
	
	@AfterTest
	void aftertest()
	{
		System.out.println("This is after test..");
	}
	
	@BeforeClass
	void beforeclass()
	{
		System.out.println("This is before class..");
	}
	
	@AfterClass
	void afterclass()
	{
		System.out.println("This is after class..");
	}
	
	@BeforeMethod
	void beforemethod()
	{
		System.out.println("This is before method..");
	}
	
	@AfterMethod
	void aftermethod()
	{
		System.out.println("This is after method..");
	}
	
	@Test(priority=1)
	void test1()
	{
		System.out.println("This is test1..");
	}
	
	@Test(priority=2)
	void test2()
	{
		System.out.println("This is test2..");
	}
	
	
	
}
