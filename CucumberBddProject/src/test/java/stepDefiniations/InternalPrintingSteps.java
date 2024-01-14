package stepDefiniations;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_Utility.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;  
import learningChainRepo.InternalPrintingPage;

public class InternalPrintingSteps extends BaseClass{
	
	
	public WebDriver driver;
	
	
	@Before
	public void setUp() throws Exception
{
//		log=Logger.getLogger("Vtiger App");
//		PropertyConfigurator.configure(".\\src\\test\\resources\\log4j.properties");
		
	
		String BROWSER = pUtil.readDataFromLearningChainPropertys("browser");
		
		//Launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
////							WebDriverManager.chromedriver().setup();
//							ChromeOptions options=new ChromeOptions();
//							options.addArguments("--remote-allow-origins=*");
//			log.info("====="+BROWSER+" Browser Launched=====");
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

	

	}
	@Given("open the Application URL {string}")
	public void open_the_application_url(String string) throws Exception {
		String URL = pUtil.readDataFromLearningChainPropertys("url");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);  
	}
	
	@Given("User Enters Username {string} and Password {string}")
	public void user_enters_username_and_password(String username, String password) {
		
		InternalPrintingPage ipe=new InternalPrintingPage(driver);
		ipe.LoginApp(username, password);
	    
	}
	
	@When("Click on Certificates and Upload CSV File")
	public void click_on_certificates_and_upload_csv_file() throws InterruptedException {
		
	    InternalPrintingPage ipe=new InternalPrintingPage(driver);
	    ipe.UploadCSVFile(driver);
	}
	
	@When("Generate the QR Code")
	public void generate_the_qr_code() throws InterruptedException {
	   InternalPrintingPage ipe=new InternalPrintingPage(driver);
	   ipe.generateQRCode();
	}
	
	@When("attach QR Code to pdf with ScanWriter app")
	public void attach_qr_code_to_pdf_with_scan_writer_app() throws Exception, InterruptedException 
	{
		driver.get("https://www.scanwritr.com/app/#!/gallery");
		driver.manage().window().maximize();
	   InternalPrintingPage ipe=new InternalPrintingPage(driver);
	   ipe.WorkingWithScanWriter();
	}
	
	@When("Upload the Certificate")
	public void upload_the_certificate() throws InterruptedException 
	{
		driver.get("https://stage.learningchain.in/printer-generate-certificate");
	    InternalPrintingPage ipe=new InternalPrintingPage(driver);
	    ipe.UploadQrCodePDFCertificate(driver);
	}


}
