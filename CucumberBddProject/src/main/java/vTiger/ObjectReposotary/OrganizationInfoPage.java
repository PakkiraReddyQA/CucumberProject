package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	//declaration
	@FindBy(className = "dvHeaderText")
	private WebElement orgHeader;
	//initalization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getOrgHeader() {
		return orgHeader;
	}
	/**
	 * this method will get the text of org header
	 * @return
	 */
	public String orgnizationHeaderText()
	{
		return orgHeader.getText();
	}

}
