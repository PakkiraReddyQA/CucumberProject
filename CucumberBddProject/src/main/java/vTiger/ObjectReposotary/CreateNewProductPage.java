package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility{
	//declaration
	@FindBy(name = "productname")
	WebElement productNameEdt;
	@FindBy(xpath = "//select[@name='productcategory']")
	WebElement productcategoryDropDown;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveBtn;
	//intialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}
	public WebElement getProductcategoryDropDown() {
		return productcategoryDropDown;
	}
	//business library
	/**
	 * this method will create new product 
	 * @param productName
	 */
	public void createNewProduct(String productName)
	{
		productNameEdt.sendKeys(productName);
	}
	/**
	 * this method will create new product with productCatgoryDropdown and click on save button
	 * @param productName
	 * @param productCatogoryDropdown
	 */
	public void createNewProduct(String productName,String productCatogoryDropdown)
	{
		productNameEdt.sendKeys(productName);
		handleDropdown(productCatogoryDropdown, productcategoryDropDown);
		saveBtn.click();
	}
	
	

}
