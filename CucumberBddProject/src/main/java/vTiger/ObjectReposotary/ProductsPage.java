package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement productlookUpImg;
	//intialization
public ProductsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getProductlookUpImg() {
	return productlookUpImg;
}
public void clickonProdctsImg()
{
	productlookUpImg.click();
}
}
