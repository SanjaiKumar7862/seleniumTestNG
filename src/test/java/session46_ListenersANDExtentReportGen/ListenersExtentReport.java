//Utility file

package session46_ListenersANDExtentReportGen;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersExtentReport implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
    // Create the SparkReporter with output path
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html"); //path name - issue here is report name is hardcoded. so we need to mention timestamp

        // Configure the report
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.STANDARD);

     // Create ExtentReports and attach reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system info - user defined keys & value we mentioned here. So we can get automatically using some pre-defined method
        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Pavan");
        extent.setSystemInfo("OS", "Windows 10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName()); // Create a test node (new entry) in the report for all below methods
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
        test.log(Status.FAIL, "Test Failed: " + result.getName());
        test.log(Status.FAIL, result.getThrowable()); // log exception
        
        //Also we can attach failure screenshot in the report 
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped: " + result.getName());
        test.log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Write everything to the report
    }
}

/*
 * --> The issue in report is, only test methods are displayed - which is difficult to find on which test case and class that particular method got failed
 * 		for this issues also there is a solution by adding TC ID and Class name
 */









