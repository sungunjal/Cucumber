package stepDefination;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import managers.FileReaderManager;
import managers.WebDriverManager;
import pageObjects.ContactPage;

public class ContactPageStep 
{
	TestContext testContext;
	ContactPage contactPage;
	WebDriverManager webdriverManager;
	WebDriverWait wait;
	public ContactPageStep(TestContext context)
	{
		testContext = context;
		contactPage = testContext.getPageObjectManager().getContactgae();
	}
	
	@And("^field all mandate info$")
	public void field_all_mandate_info() throws Throwable {
	    contactPage.enter_YourName("Sunil");
	    contactPage.enter_YourEmail("sunil@sunil.com");
	    contactPage.enter_YourSubject("Sunil_Subject");
	    contactPage.enter_YourMessage("Sunil Text Message");
	}
	
	@And("^provide username as \"([^\"]*)\" email as \"([^\"]*)\" subject as \"([^\"]*)\" and message as \"([^\"]*)\"$")
	public void provide_username_as_email_as_subject_as_and_message_as(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		contactPage.enter_YourName(arg1);
	    contactPage.enter_YourEmail(arg2);
	    contactPage.enter_YourSubject(arg3);
	    contactPage.enter_YourMessage(arg4);
	}

	@And("^click on send button$")
	public void click_on_send_button() throws Throwable {
		wait = new WebDriverWait(testContext.getWebDrivrManager().getDriver(), FileReaderManager.getInstance().getConfigFileReader().getExplicitWait());
	    contactPage.clickOn_btnSend();
	    wait.until(ExpectedConditions.visibilityOf(contactPage.txtVerifyMessage));
	    assertTrue(contactPage.verifyMessage("Your message was sent successfully."));
	    {
	    	System.out.println("Success");
	    }
	}

	@And("^close browser$")
	public void close_browser() throws Throwable {
	    //driver.close();
	}

}

