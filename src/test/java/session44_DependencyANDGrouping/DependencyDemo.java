package session44_DependencyANDGrouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyDemo 
{
	
	@Test(priority=1)
	void openapp()
	{
		//Assert.assertTrue(false); //Failed
		Assert.assertTrue(true);  //Passed
	}
	
	@Test(priority=2, dependsOnMethods= {"openapp"})
	void login()
	{
		Assert.assertTrue(true); //Passed
	}
	
	@Test(priority=3, dependsOnMethods= {"login"})
	void search()
	{
		Assert.assertTrue(false); //Failed
	}
	
	@Test(priority=4, dependsOnMethods= {"login","search"})   //specify (n) no of methods
	void advsearch()
	{
		Assert.assertTrue(true); //Passed
	}
	
	@Test(priority=5, dependsOnMethods= {"login"})
	void logout()
	{
		Assert.assertTrue(true); //Passed
	}
	
	
}

/*
 * By default TestNG executes all the test method Pass or Failed
 * 
 * Adding dependecies inside test method makes the test to Skips if the dependent method failed and test to execute if the depenedent method passed
 * Eg: @Test(priority=1, dependsOnMethods={"openapp"})
 * Now based on the dependent setting method the test will get executed
 * If the dependent failed, then rest all gets skipped based on the condition given 
 *  
 * Main Adv: Dont need to unnecessaryly execute  all test methods 
 *  
 */



