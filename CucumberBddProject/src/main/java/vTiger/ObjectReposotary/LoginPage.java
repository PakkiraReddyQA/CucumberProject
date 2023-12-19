package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//rule1:create a pom class for every web page
	//rule2:class name should be the title of page and ending with page
	//Rule3:Identify the web elements using @findBy,@FindBys,@findAll annotations
	//Declaration
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	WebElement LoginButton;
    //rule4:create constuctor to intialise the varibles /web elements
	//intialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
			
	}
	//Rule5:provide getters to access the webElements
	//utilization
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	//Business librarary-generic methods-for this applications
	/**
	 * this method login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginapp(String USERNAME,String PASSWORD ){
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		LoginButton.click();
	}
	
	
}
