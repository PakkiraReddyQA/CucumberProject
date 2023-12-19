package object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//	Declaration
	@FindBy(name="user_name")
	 private WebElement userNameEdt;
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement LoginBtn;
	
	//Intialization
	
	public LoginPage(WebDriver driver) 
	{
		
		PageFactory.initElements(driver,this);
	}



	//Utilization
	public WebElement getUserName() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	//Business Librarary
	/**
	 * This methos used to login the application
	 * @param userName
	 * @param password
	 */
	public void loginApp(String userName,String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		LoginBtn.click();
	}
	

}
