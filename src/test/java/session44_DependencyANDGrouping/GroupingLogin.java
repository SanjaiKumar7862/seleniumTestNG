package session44_DependencyANDGrouping;

import org.testng.annotations.Test;

public class GroupingLogin {

	
//Consider these 3 methods are Sanity test	
	
	@Test(priority=1, groups= {"Sanity"})    //group name is user defined
	void loginByEmail()
	{
		System.out.println("Login by Email..");
	}
	
	@Test(priority=2, groups= {"Sanity"})
	void loginByFacebook()
	{
		System.out.println("Login by facebook");
	}
	
	@Test(priority=3, groups= {"Sanity"})
	void loginByTwittwe()
	{
		System.out.println("Login by Twitter");
	}
	
}
