 package generic_Utility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementaion to all the methods in ITestListener Interface of Testing
 * @author pakkira Reddy
 *
 */
public class ListenersImplementaionClass implements ITestListener
{
ExtentReports reports;
ExtentTest test;

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test=reports.createTest(methodName);//Monitor The TestScript
		test.log(Status.INFO, "=====Execution started===="+methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS,"==TestScript PASS=="+methodName);
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
//		System.out.println("============"+methodName+"======TestScript Failed======");
//		System.out.println(result.getThrowable());
		test.log(Status.FAIL, "--test script Failed--"+methodName);
		test.log(Status.FAIL, result.getThrowable());
		
		String screenshotName = methodName+"-"+jUtil.getSystemDateformat();
		try
		{
			String path = wUtil.takescreenshot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		}
		catch (Exception e) {
					
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "--test script skipped--"+methodName);
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
//		System.out.println("======Suite Execution started======");
		//Basic Configuration for Extent Reports
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\vTiger Report-"+new JavaUtility().getSystemDateformat()+".html");
		htmlReport.config().setDocumentTitle(" Reports");
		htmlReport.config().setReportName(" Report");
		htmlReport.config().setTheme(Theme.DARK);
		//Actual Report for System Information in ExtentReport
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Base URL", "http://localhost:8888/");
        reports.setSystemInfo("BaseBrowser", "Chrome");
        reports.setSystemInfo("UserName", "admin");
        reports.setSystemInfo("Password", "admin");
        
        
        reports.setSystemInfo("Base platform", "windwos");
        reports.setSystemInfo("ReporterName", "Pakkira Reddy");
        reports.setSystemInfo("Company Name", "Sapphirus System P Ltd");
		
	}

	public void onFinish(ITestContext context) 
	{
		
		System.out.println("====suite Execution finished======");
		reports.flush();//it will tell to extentreports ,,,execution completed ...you can generate report
	}
	

}
