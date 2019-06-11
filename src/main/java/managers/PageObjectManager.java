package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.ContactPage;
import pageObjects.HomePage;

public class PageObjectManager {
	public WebDriver driver;
	public HomePage homePage;
	public ContactPage contactPage;
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HomePage getHomePgae() 
	{
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public ContactPage getContactgae() 
	{
		return (contactPage == null) ? contactPage = new ContactPage(driver) : contactPage;
	}
}
