package session42_TestNG;

import org.testng.annotations.Test;

/*
 
 Automate below using TestNG style
 
 TC1 - Open App
 TC2 - Login 
 TC3 - Logout
 TC4 - Close App
 
 */

public class FirstCase 
{

	@Test
	void openapp()
	{
		System.out.println("Open Application...");
	}
	

	@Test(priority=3)
	void logout()
	{
		System.out.println("Logout Application...");
	}
	
	
	@Test(priority=2)
	void login()
	{
		System.out.println("Login Application...");
	}
	

	@Test(priority=4)
	void closeapp()
	{
		System.out.println("Close Application...");
	}
}


/*
 * --> TestNG will execute test cases only if they have a @Test annotations. wihout that @test, it will not consider for execution
 * --> Without main method by creating @Test annotation, we can able to execute testng methods
 * --> After that, Resultls printed in console window and also in seperate testng result window
 * --> So basically, it will run test as unordered
 * NOTES: TestNG execute the test cases in alphabetical order by default
 * 
 * --> @Test(priority=1..) by adding in methods, it will control the order of execution based on priority. If priority given is same, it will run based on alphabetic name
 * --> By default (Priority is Zero), if we dont specify any priority to the test methods so that will be executed first
 * --> We can also provide Negative numbers in prorities (-3, -2, -1,0, 1, 2, 3..)
 * 
 * 
 * 
 */