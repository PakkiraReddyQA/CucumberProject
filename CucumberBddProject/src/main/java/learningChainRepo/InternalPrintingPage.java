package learningChainRepo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InternalPrintingPage {
//	WebDriver driver=null;
	
	@FindBy(name = "username")
	private WebElement usernameEdt;
	
	@FindBy(xpath  = "//input[@type='password']")
	private WebElement pwdEdt;
	
	@FindBy(xpath  = "//input[@type='submit']")
	private WebElement LoginBtn;
	
	@FindBy(xpath  = "//a[text()='Certificates ']")
	private WebElement Certificatelnk;
	
	@FindBy(xpath = "//a[text()='Internal Printing ']")
	private WebElement intrnalPrintingLnk;
	
	@FindBy(xpath = "//div[@class='row my-5']/div/select")
	private WebElement CertificateType;
	
	@FindBy(xpath = "//input[@type='file']")
   private WebElement uploadCsvFile;
	
	@FindBy(xpath = "//input[@value='Next']")
	private WebElement NextBtn;
	
	@FindBy(xpath = "//label[@class='switch']/span")
	private WebElement toggleBtn;
	
	@FindBy(xpath = "//input[@value='Generate QR-Code']")
	private WebElement generateQRCode;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement OKBtn;
	
	
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement okBtn;
	
	@FindBy(xpath = "//div[text()='Drop your document here.']")
	private WebElement DropDocumentLnk;
	
	@FindBy(xpath = "//button[@title='Insert image']")
	private WebElement InsertImageBtn;
	
	@FindBy(xpath = "//div[contains(text(),'Drop image here or click to select a file.')]")
	private WebElement DropImageHereLnk;
	
	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement ApplyTheQrcodeonPdf;
	
	@FindBy(xpath = "//button[@title='Download']")
	private WebElement DownloadBtn;
	
	@FindBy(xpath = "//a[text()='Download PDF']")
	private WebElement DownLoadPDF;
	
	@FindBy(xpath = "//button[text()='Download basic PDF with watermark']")
	private WebElement DownLoadPDFwithWaterMarkBtn;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement UploadQRCodePdf;
	
	
	
	public InternalPrintingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginApp(String UserName,String password)
	{
		usernameEdt.sendKeys(UserName);
		
		pwdEdt.sendKeys(password);
		
		LoginBtn.click();
		
	}
	
	public void UploadCSVFile(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.moveToElement(Certificatelnk).click().build().perform();
		Thread.sleep(2000);
		intrnalPrintingLnk.click();

		 Select sc=new Select(CertificateType);
		 sc.selectByVisibleText("Btech");
		 
		 uploadCsvFile.sendKeys("D:\\SappProject\\intercsv.csv");
		 
		
	}
	public void generateQRCode() throws InterruptedException
	{
         NextBtn.click();
		 Thread.sleep(1000);
		 
		 toggleBtn.click();
		 
		 Thread.sleep(1000);
		 
		 OKBtn.click();
		 
		 generateQRCode.click();
		 
		 okBtn.click();
	}
	
	public void WorkingWithScanWriter() throws AWTException, InterruptedException
	{
		DropDocumentLnk.click();
		
		Robot r=new Robot();
		r.delay(2000);
		
		//Path copy to ClipBoard
		StringSelection ss=new StringSelection("C:\\Users\\pakki\\Downloads\\SampleLearning.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//for pressing cntrl+v
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		//for realising cntl+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		//Click on Enter key
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		InsertImageBtn.click();
		Thread.sleep(1000);
		DropImageHereLnk.click();
		
		StringSelection ss1=new StringSelection("C:\\Users\\pakki\\Downloads\\priorities-meadow-murphy-obooko-35.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
		Thread.sleep(2000);
		//for pressing cntrl+v
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		
		//for realising cntl+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		
		//Click on Enter key
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		ApplyTheQrcodeonPdf.click();
		Thread.sleep(1000);
		DownloadBtn.click();
		Thread.sleep(1000);
		DownLoadPDF.click();
		Thread.sleep(1000);
		DownLoadPDFwithWaterMarkBtn.click();
		
		System.out.println("Attached QRCode Pdf Downloaded successfully");
		
		
	}
	
	public void UploadQrCodePDFCertificate(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(1000);
		driver.get("https://stage.learningchain.in/printer-generate-certificate");
		UploadQRCodePdf.sendKeys("D:\\SappProject\\Document.pdf");
		System.out.println("Pdf uploaded successfully");
	}
}
