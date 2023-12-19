package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	// Delclartion
	@FindBy(xpath = "//img[@title='Create Contact...']")
	WebElement createContactLookupImg;
	// intialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	//Business library
	/**
	 * this method will click on create contact lookup img
	 */
	public void clickOnCreateContactlookUPimg()
	{
		createContactLookupImg.click();
	}

}
