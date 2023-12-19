package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactstInfoPage {
	//declaration
	@FindBy(className = "dvHeaderText")
	WebElement contactHeader;
	//intialization
	public ContactstInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getContactHeader() {
		return contactHeader;
	}
	/**
	 * this method will give text of contact name
	 * @return
	 */
	public String contactHeaderText()
	{
		return contactHeader.getText();
	}
	
}
