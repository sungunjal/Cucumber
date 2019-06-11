package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='your-name']")
	public WebElement txtYourName;
	
	@FindBy(xpath = "//input[@name='your-email']")
	public WebElement txtYourEmail;
	
	@FindBy(xpath = "//input[@name='your-subject']")
	public WebElement txtYourSubject;
	
	@FindBy(xpath = "//textarea[@name='your-message']")
	public WebElement txtYourMessage;
	
	@FindBy(xpath = "//input[@value='Send']")
	public WebElement btnSend;
	
	@FindBy(xpath = "//div[contains(@class,'response-output')]")
	public WebElement txtVerifyMessage;
	
	public void enter_YourName(String str)
	{
		txtYourName.sendKeys(str);
	}
	
	public void enter_YourEmail(String str)
	{
		txtYourEmail.sendKeys(str);
	}
	public void enter_YourSubject(String str)
	{
		txtYourSubject.sendKeys(str);
	}
	
	public void enter_YourMessage(String str)
	{
		txtYourMessage.sendKeys(str);
	}
	
	public void clickOn_btnSend() 
	{
		btnSend.click();
	}
	
	public boolean verifyMessage(String expectedmsg)
	{
		String actualMsg = txtVerifyMessage.getText();
		if (actualMsg.equalsIgnoreCase(expectedmsg))
		{
			System.out.println("Verified Message..");
		}
		else
		{
			System.out.println("Not able to Verified Message..");
			return false;
		}
		return true;
	}
}
