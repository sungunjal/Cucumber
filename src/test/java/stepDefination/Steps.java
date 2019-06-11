package stepDefination;

/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.ContactPage;
import pageObjects.HomePage;*/

public class Steps 
{
	/*WebDriver driver;
	HomePage homePage;
	ContactPage contactPage;
	WebDriverWait wait;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	//ConfigFileReader configFileReader;
	
	@Given("^user open DemoQa app$")
	public void user_open_DemoQa_app() throws Throwable {
		//configFileReader = new ConfigFileReader();
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		wait = new WebDriverWait(driver,FileReaderManager.getInstance().getConfigFileReader().getExplicitWait());
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePgae();
		contactPage = pageObjectManager.getContactgae();
		
	}

	@Then("^navigate to contact tab$")
	public void navigate_to_contact_tab() throws Throwable {
	    homePage.clickOn_linkContactTab();
	}

	@And("^field all mandate info$")
	public void field_all_mandate_info() throws Throwable {
	    contactPage.enter_YourName("Sunil");
	    contactPage.enter_YourEmail("sunil@sunil.com");
	    contactPage.enter_YourSubject("Sunil_Subject");
	    contactPage.enter_YourMessage("Sunil Text Message");
	}

	@And("^click on send button$")
	public void click_on_send_button() throws Throwable {
	    contactPage.clickOn_btnSend();
	    wait.until(ExpectedConditions.visibilityOf(contactPage.txtVerifyMessage));
	    if (contactPage.verifyMessage("Your message was sent successfully. Thanks."))
	    {
	    	System.out.println("Success");
	    }
	    else
	    {
	    	System.out.println("Failed");
	    }
	}

	@And("^close browser$")
	public void close_browser() throws Throwable {
	    driver.close();
	}
	*/
}
