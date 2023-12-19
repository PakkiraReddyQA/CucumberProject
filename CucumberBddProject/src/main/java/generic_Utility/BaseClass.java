package generic_Utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.Before;

/**
 * this class contains all basic configuration Annataions 
 * @author pakkira Reddy
 *
 */
public class BaseClass {
	
	public  PropertiesFileUtility pUtil=new PropertiesFileUtility();
	public  ExcelFileUtility eUtil=new ExcelFileUtility();
	public  JavaUtility jUtil=new JavaUtility();
    public 	WebDriverUtility wUtil=new WebDriverUtility();
	public  WebDriver driver;
	public static Logger log;
	
	
	public  static WebDriver sdriver; //this is used for  take screen shot 
	

	
//	@BeforeMethod(groups = {"smokesuite","regressionSuite"})
//	public void bmConfiguration() throws Exception
//	{
//		//login to appliction
//		String USERNAME = pUtil.readDataFromPropertyFile("username");
//		String PASSWORD = pUtil.readDataFromPropertyFile("password");
//		LoginPage lp=new LoginPage(driver);
//		lp.loginapp(USERNAME, PASSWORD);
//		System.out.println("application loggedin successfully");
//	}
//	@AfterMethod(groups = {"smokesuite","regressionSuite"})
//	public void amConfiguration()
//	{
//		HomePage hp=new HomePage(driver);
//		hp.logoutofApp(driver);
//		System.out.println("application loggedOut successfully");
//	}
////	@AfterTest
//	@AfterClass(groups = {"smokesuite","regressionSuite"})
//	public void acConfiguration()
//	{
//		driver.quit();
//		System.out.println("Browser closed successfully");
//	}
//	
//	@AfterSuite(groups = {"smokesuite","regressionSuite"})
//	public void asConfiguration()
//	{
//		System.out.println("======Data Base connection closed=====");
//	}
}

