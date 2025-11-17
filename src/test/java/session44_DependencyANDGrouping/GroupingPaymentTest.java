package session44_DependencyANDGrouping;

import org.testng.annotations.Test;

public class GroupingPaymentTest {

	
//Consider these 2 methods are both Sanity test and Regression test - Combinely given as Functional test
	
	@Test(priority=1, groups= {"Sanity","Regression", "Functional"})   //group name is user defined //Functional is added as a common name to run only Sanity, Regression methods
	void paymentinRupees()
	{
		System.out.println("Payment in Ruppess..");
	}

	
	@Test(priority=2, groups= {"Sanity","Regression", "Functional"})
	void paymentinDollars()
	{
		System.out.println("Payment in Dollars..");
	}
	
}

