//Utility file

package session46_ListenersANDExtentReportGen;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners1 implements ITestListener    //Interface concept - ctrl + click to get default methods

{
	
	//--> Copied default listener methods from listener class and implement 
	
	
	public void onStart(ITestContext context) 
	{
		System.out.println("Whenever Started test execution, like before statring all the test it will get triggered only once"); 
	}
	
	public void onTestStart(ITestResult result) 
	{
		System.out.println("Whenever Started test methods execution, before starting each time it will get triggered based on test"); 
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Whenever passed");
	}
	 
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Whenever failed");
	}

	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Whenever skipped");
	}
	
	public void onFinish(ITestContext context) 
	{
		System.out.println("Whenever test execution is completed");
	}
	
}


/*
 * --> 2 Ways to implement listener interface
 * 		1) By implementing ITest Listener interface
 * 		2) By extending TestListenerAdapter
 * 
 * 
*/