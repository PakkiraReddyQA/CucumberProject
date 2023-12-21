package stepDefiniations;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import generic_Utility.BaseClass;
import generic_Utility.ExcelFileUtility;
import generic_Utility.JavaUtility;
import generic_Utility.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectReposotary.CreateNewOrganizationPage;
import vTiger.ObjectReposotary.HomePage;
import vTiger.ObjectReposotary.LoginPage;
import vTiger.ObjectReposotary.OrganizationInfoPage;
import vTiger.ObjectReposotary.OrganizationPage;
@Listeners(generic_Utility.ListenersImplementaionClass.class)
public class VitgerAppTest extends BaseClass {
	
	public WebDriver driver;
	public HomePage hp;
	
	@Before
	public void setUp() throws Exception
	{
		log=Logger.getLogger("Vtiger App");
		PropertyConfigurator.configure(".\\src\\test\\resources\\log4j.properties");
		
	
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");

		//Launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
////							WebDriverManager.chromedriver().setup();
//							ChromeOptions options=new ChromeOptions();
//							options.addArguments("--remote-allow-origins=*");
			log.info("====="+BROWSER+" Browser Launched=====");
			driver=new ChromeDriver();

			//				System.out.println("===="+BROWSER+"====Launched succefully===");
			sdriver=driver;//this is used for  take screen shot in listeners
		}
		else if(BROWSER.equalsIgnoreCase("Firfox"))
		{

			//				WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			log.info("====="+BROWSER+" Browser Launched=====");
			//				System.out.println("===="+BROWSER+"====Launched succefully===");
			sdriver=driver;//this is used for  take screen shot in listeners
		}
		else
		{
			System.out.println("inavlid browser found");
		}
		wUtil.maximize(driver);
		wUtil.waitforloadPage(driver);
		log.info(URL);
		log.info("===Opening URL====");
		driver.get(URL);

	}

	@Given("Launch Browser {string}")
	public void launch_browser(String url) {
		log=Logger.getLogger("Vtiger App");
		PropertyConfigurator.configure(".\\src\\test\\resources\\log4j.properties");

	}

	@Given("Login with Valid Credentials userName {string} password {string}")
	public void login_with_valid_credentials_user_name_password(String userName, String password) throws Exception {
	
		userName=pUtil.readDataFromPropertyFile("username");
		password=pUtil.readDataFromPropertyFile("password");
		log.info("===login to application===");
		LoginPage lp=new LoginPage(driver);
		lp.loginapp(userName, password);
	}
	//Steps for Create new Organization

    @When("Click on Organization Link")
      public void click_on_organization_link() {
	hp=new HomePage(driver);
	hp.clickonOrganizationsLink();
	log.info("=====Clicked on Org Link");
}

@When("Click on Create new Organization Link")
public void click_on_create_new_organization_link() {
	
	OrganizationPage org=new OrganizationPage(driver);
	org.clickOnOrganizationImg();
	log.info("====Clicked On Org lookUp img");
    
}

@Given("Provide Organization Name in Organization Text Field Click on Save Button")
public void provide_organization_name_in_organization_text_field_click_on_save_button()  throws EncryptedDocumentException, IOException {
	CreateNewOrganizationPage crp=new CreateNewOrganizationPage(driver);
	
	String ORGNAME = eUtil.readDatafromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
	//Create Organization and save
	crp.createNeworganization(ORGNAME);
    
}
@Then("Validate Created Organization With Actual Organization Name")
public void validate_created_organization_with_actual_organization_name() throws EncryptedDocumentException, IOException {
	
	 String ORGNAME = eUtil.readDatafromExcel("Organization",1,2)+jUtil.getRandomNumber();
	System.out.println(ORGNAME);
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String ORGHEDER = oip.orgnizationHeaderText();
	System.out.println(ORGHEDER+"**** "+ORGNAME);
//	Assert.assertTrue(ORGHEDER.contains(ORGNAME));   
   }

	@Then("I validate the logged in successfully")
	public void i_validate_the_logged_in_successfully() throws InterruptedException {
		String actTitle = driver.getTitle();
	    System.out.println("Title of the page"+ actTitle);
	}
	
	
	
	
	//Create Organization with Industry
	
	
@Given("Provide Organization Name in Organization and Industry Text Field Click on Save Button")
public void provide_organization_name_in_organization_and_industry_text_field_click_on_save_button() throws EncryptedDocumentException, IOException {
	String ORGNAME = eUtil.readDatafromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
	String INDUSTRTY = eUtil.readDatafromExcel("Organization", 4, 3);
   CreateNewOrganizationPage crp=new CreateNewOrganizationPage(driver);
   crp.createNeworganization(ORGNAME, INDUSTRTY);
   
}
@Then("close the browser")
public void close_the_browser() {
//	driver.close();
}

@After
public void tearDown() throws IOException
{
	WebDriverUtility wUtil=new WebDriverUtility();
	wUtil.takescreenshot(driver, "VtigerScreen"+new JavaUtility().getRandomNumber());

	driver.close();
	log.info("====Browser Closed=====");
	log.info("====DataBase Closed Successfully===");
}
}
