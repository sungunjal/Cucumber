package stepDefination;

import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;

public class HomePageStep {

	TestContext testContext;
	HomePage homePage;
	
	public HomePageStep(TestContext context)
	{
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePgae();
	}
	
	@Given("^user open DemoQa app$")
	public void user_open_DemoQa_app() throws Throwable {
		//configFileReader = new ConfigFileReader();
		
	}

	@Then("^navigate to contact tab$")
	public void navigate_to_contact_tab() throws Throwable {
	    homePage.clickOn_linkContactTab();
	}
	
}
