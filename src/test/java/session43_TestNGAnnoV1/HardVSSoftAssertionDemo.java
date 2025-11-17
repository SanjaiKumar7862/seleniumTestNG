package session43_TestNGAnnoV1;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVSSoftAssertionDemo 
{
	
		// SoftAssert sa;    --> while using inside class, create variable and access inside test methods and main methods..
	
	@Test
	void hardassertions()
	{
		System.out.println("Hard assert..");
		System.out.println("Hard assert..");
		
		Assert.assertEquals(1,2);  //
		
		System.out.println("Hard assert..");
		System.out.println("Hard assert..");
	}
	
	
	@Test
	void softassertions()
	{
		System.out.println("soft assert..");
		System.out.println("soft assert..");
		
		SoftAssert sa = new SoftAssert();  //Create an Object of a SoftAssert class
		sa.assertEquals(1,2);  //Access methods using Object
		
		System.out.println("soft assert..");
		System.out.println("soft assert..");
		
		sa.assertAll();  //Mandatory for SoftAssertion to be used at End of the test
	}
	
}


// If a soft assertion fails, execution continues.
// At the end, you must call assertAll() → otherwise the test will always pass.
// Only at assertAll() → the test is marked failed with all error messages.

// Use Soft Assertions when you want to validate multiple fields in one test without stopping midway.





