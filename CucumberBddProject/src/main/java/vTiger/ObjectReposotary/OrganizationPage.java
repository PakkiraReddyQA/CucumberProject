package vTiger.ObjectReposotary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

public class OrganizationPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement OrgLookupBtn;
   @FindBy(xpath = "//img[@title='Search in Organizations...']")
   private WebElement searchIconBtn;
   @FindBy(name = "search_text")
   private WebElement searchBarEdt;
   @FindBy(name="submit")
   private WebElement searchBtn;
   @FindBy(name = "selected_id")
   private List<WebElement> clickCheckBox;

    @FindBy(name = "selectall")
   private WebElement clickOnselectAllBox;
    
    @FindBy(xpath = "//a[@title='Organizations']")
    private List<WebElement> printAllOrgs;
    
    @FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@id='9']")
    private WebElement clickBasedIndex;
    
	// Intialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgLookupBtn() {
		return OrgLookupBtn;
	}
	public WebElement getSearchIconBtn() {
		return searchIconBtn;
	}
	public WebElement getSearchBarEdt() {
		return searchBarEdt;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public List<WebElement> getClickCheckBox() {
		return clickCheckBox;
	}
	   
	   public WebElement getClickOnselectAllBox() {
		return clickOnselectAllBox;
	}
	//Business library
	public void clickOnOrganizationImg()
	{
		OrgLookupBtn.click();
	}
	
	/**
	 * this method will click on check box individulay in Organization page
	 * @param driver
	 */
	public void checkBoxClickAllIndividually(WebDriver driver)
	{
	for(WebElement k:clickCheckBox)
	{
		k.click();
	}
	}
	/**
	 * This method will click on select all check Box at one time
	 */
	
	public void selectAllcheckBoxClick()
	{
		getClickOnselectAllBox().click();
	}
	/**
	 * This method will print all the Orgnization presnet in the Organization page
	 * 
	 */
	public void printOrganizations()
	{
		
		for(WebElement k:printAllOrgs)
		{
			System.out.println(k.getText());
		}
	}
	/**
	 * This method will Select the check Based on Index
	 * @param driver
	 * @param indexNumber
	 */
	public void clickOnCheckBoxBasedOnIndex(WebDriver driver,int indexNumber)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@id='"+indexNumber+"']")).click();
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[*]/a[text()='del']")).click();
		WebDriverUtility wUtil=new WebDriverUtility();
		wUtil.acceptAlert(driver);
	}
	
}
