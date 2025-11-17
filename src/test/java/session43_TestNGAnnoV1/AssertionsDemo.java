package session43_TestNGAnnoV1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo 
{
	
	@Test
	void testTitle()
	{
		String exp_title = "Opencart";
		String act_title = "Openshop";
		
		
		//Normal If condition for validation. But we cant able to fail the test method if validation fails
		if(exp_title.equals(act_title))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		
		//Instead of using IF condition we use Assertion class for comparision and it will provide the test method Pass or Fail in testNG report
		Assert.assertEquals(exp_title, act_title);
		
		
		//Also it can be used inside Condition
		if(exp_title.equals(act_title))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Test Failed");
			Assert.assertTrue(false);
		}
		
			
	}
}
