package vTiger.ObjectReposotary;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage1 {
	// Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImg;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[*]/input[@name='selected_id']")
	private List<WebElement> allCheckBoxes;

	// //*/a[@title='Organizations']
	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[*]/td[*]/a[@title='Organizations']")
	private List<WebElement> allOrganizations;

	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[last()]/td/input")
	private WebElement lastCheckBox;

	// Intialization
	public OrganizationPage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//Utilization
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}

	public List<WebElement> getAllCheckBoxes() {
		return allCheckBoxes;
	}

	public List<WebElement> getAllOrganizations() {
		return allOrganizations;
	}

	public WebElement getLastCheckBox() {
		return lastCheckBox;
	}
	
	//Business Library
	/**
	 * This method will click on create orgnization lookup Image
	 */
	public void clickOnCreateOrg()
	{
		createOrgImg.click();
	}
	/**
	 * This method will click on All check Boxes 
	 */
	public void allcheckBoxes()
	{
		for(WebElement k:allCheckBoxes)
		{
			k.click();
		}
	}
	/**
	 * This method will print all the Organizations 
	 */
	public void printAllOrganizations()
	{
		for(WebElement k:allOrganizations)
		{
			System.out.println(k.getText());
		}
	}
	/**
	 * This method will check last checkBox
	 */
	public void checkLastCheckBox()
	{
		lastCheckBox.click();
	}
}
