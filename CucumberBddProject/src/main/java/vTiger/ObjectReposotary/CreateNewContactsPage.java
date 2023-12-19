package vTiger.ObjectReposotary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;


public class CreateNewContactsPage extends WebDriverUtility {
	//declaration
	@FindBy(name = "lastname")
	WebElement lastNameEdt;
	@FindBy(name = "leadsource")
	WebElement leadsourceDropdown;
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	WebElement orgnizationImg;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveBtn;
	@FindBy(xpath = "//input[@name='search_text']")
	WebElement searchEdt;
	@FindBy(name = "search")
	WebElement searchBtn;
	
	//intialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public WebElement getLeadsourceDropdown() {
		return leadsourceDropdown;
	}
	public WebElement getOrgnizationImg() {
		return orgnizationImg;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	//Business libraries
	/**
	 * this method will create contac with mandatary fields
	 * @param LastName
	 */
	public void createNewContact(String LastName)
	{
		lastNameEdt.sendKeys(LastName);
	}
	/**
	 * this method will create new contact based on what we give org name
	 * @param driver
	 * @param lastName
	 * @param orgName
	 */
	public void createNewContact(WebDriver driver,String lastName,String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgnizationImg.click();
		switchTowindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchTowindow(driver, "Contacts");
		saveBtn.click();
	}
}
