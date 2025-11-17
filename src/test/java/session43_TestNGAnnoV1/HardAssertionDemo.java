package session43_TestNGAnnoV1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionDemo 
{
	
	@Test
	void test()
	{
		
		Assert.assertEquals("abc" , "xyz");  //-> Compare all type of values string, numbers, boolean...
		Assert.assertEquals(1234 , "abc");  
		Assert.assertNotEquals(123, 123);  //Failed
		
		Assert.assertTrue(true); //Passed
		Assert.assertTrue(false); //Failed
		
		Assert.assertTrue(1==2); //Failed
		Assert.assertTrue(1==1); //Passed
		
		Assert.assertFalse(1==2); //Passed
		Assert.assertFalse(1==1); //Failed
		
		Assert.fail();  //This method directly fail test method
		
	}
}


// If a hard assertion fails, the test execution stops immediately and the next lines will not run.