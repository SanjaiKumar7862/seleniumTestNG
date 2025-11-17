package session44_DependencyANDGrouping;

import org.testng.annotations.Test;

public class GroupingSignup {


//Consider these 3 methods are Regression test	
	
	@Test(priority=1, groups= {"Regression"})   //group name is user defined
	void singupByEmail()
	{
		System.out.println("Signup by Email..");
	}
	
	
	@Test(priority=2, groups= {"Regression"})
	void singupByFacebook()
	{
		System.out.println("Signup by Facebook..");
	}
	

	@Test(priority=3, groups= {"Regression"})
	void singupByTwitter()
	{
		System.out.println("Signup by Twitter..");
	}
}
