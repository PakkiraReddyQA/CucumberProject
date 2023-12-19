package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {
	@FindBy(name = "accountname")
	WebElement orgNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveBtn;
	@FindBy(name = "industry")
	WebElement industryDropdown;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	/**
	 * this method will create new organization and save
	 * @param orgName
	 */
	public void createNeworganization(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	/**
	 * this method will create new organization with industry drop down and save
	 * @param orgName
	 * @param Industry
	 */
	public void createNeworganization(String orgName,String Industry)
	{
		orgNameEdt.sendKeys(orgName);
		handleDropdown(Industry, industryDropdown);
		saveBtn.click();
		
	}
	

}
