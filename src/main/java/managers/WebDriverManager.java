package managers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.DriverTypes;
import enums.EnvironemntTypes;

public class WebDriverManager {
	private WebDriver driver;
	private WebDriverWait wait;
	private static DriverTypes driverTypes;
	private static EnvironemntTypes environmentType;

	// Constructor
	public WebDriverManager() {
		driverTypes = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
	}

	// Getting driver in StepDef
	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}
	
	/*public WebDriverWait getWait() {
		if (wait == null)
			wait = createWait();
		return wait;
	}

	private WebDriverWait createWait() {
		wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigFileReader().getExplicitWait());
		return wait;
	}*/

	// Calling method to create driver
	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	// Creating Remote Driver
	private WebDriver createRemoteDriver() {
		System.out.println("we will implement this in future");
		return null;
	}

	// Creating Local Driver
	private WebDriver createLocalDriver() {
		switch (driverTypes) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		}
		if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize()) {
			driver.manage().window().maximize();
		}
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getAppUrl());
		driver.manage().timeouts().implicitlyWait(
				FileReaderManager.getInstance().getConfigFileReader().getImplicitWait(), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, FileReaderManager.getInstance().getConfigFileReader().getExplicitWait());
		return driver;
	}

	// Closing Driver
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
	
	// Getting Report Path
	public static File filePath;
	public static String timeStamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(Calendar.getInstance().getTime());
	public File getReportPath() {
		
		if (filePath == null)
		{
			filePath = createNewReportFilePath();
		}
		return filePath;
	}

	//Creating Report Path
	private File createNewReportFilePath() 
	{
		filePath = new File("Logs\\" + timeStamp);
		// if the directory does not exist, create it
		if (!filePath.exists()) {
			System.out.println("creating directory: " + filePath.getName());
			filePath.mkdirs();
		}
		return filePath;
	}
    public String getTimeStamp() {
		if (timeStamp == null)
		{
			timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		}
		return timeStamp;
	}
}
