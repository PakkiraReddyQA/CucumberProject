package vTiger.ObjectReposotary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	//declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homebtn;
	@FindBy(linkText = "Calendar")
	private WebElement CalenderLnk;
	@FindBy(linkText = "Leads")
	private WebElement leadsLnk;
	 @FindBy(linkText = "Contacts")
	  private WebElement contactsLnk;
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	@FindBy(linkText = "Documents")
	private WebElement DocumentsLnk;
	@FindBy(linkText = "Email")
	private WebElement EmailLnk;
	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTicketsLnk;
	@FindBy(linkText = "Dashboard")
	private WebElement DashboardLnk;
	@FindBy(name = "query_string")
	private WebElement searchBarLnk;
	@FindBy(className = "searchBtn")
	private WebElement searcgLnk;
	
	@FindBy(linkText = "Sign Out")
	WebElement SignOutLnk; 
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
WebElement AdminstratorImg;	 

	//intialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}


	public WebElement getHomebtn() {
		return homebtn;
	}


	public WebElement getCalenderLnk() {
		return CalenderLnk;
	}


	public WebElement getLeadsLnk() {
		return leadsLnk;
	}


	public WebElement getContactsLnk() {
		return contactsLnk;
	}


	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}


	public WebElement getProductsLnk() {
		return ProductsLnk;
	}


	public WebElement getDocumentsLnk() {
		return DocumentsLnk;
	}


	public WebElement getEmailLnk() {
		return EmailLnk;
	}


	public WebElement getTroubleTicketsLnk() {
		return TroubleTicketsLnk;
	}


	public WebElement getDashboardLnk() {
		return DashboardLnk;
	}


	public WebElement getSearchBarLnk() {
		return searchBarLnk;
	}


	public WebElement getSearcgLnk() {
		return searcgLnk;
	}
	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}

	public WebElement getAdminstratorImg() {
		return AdminstratorImg;
	}

	//Business library
	public void clickonContactsLink()
	{
		contactsLnk.click();
	}
	public void clickonOrganizationsLink()
	{
		organizationLnk.click();
	}
	public void clickonProductsLink()
	{
		ProductsLnk.click();
	}
	public void logoutofApp(WebDriver driver)
	{
		mouseHoverAction(driver,AdminstratorImg);
		SignOutLnk.click();
		
	}

}
