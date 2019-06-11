package stepDefination;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
	TestContext testContext;
	File theDir;
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	public Hooks(TestContext context) {
		testContext = context;
		theDir = testContext.getWebDrivrManager().getReportPath();
	//	timeStamp = testContext.getWebDrivrManager().getTimeStamp();
	}

	@Before
	public void BeforeSteps() {
		
	}

	@After(order = 1)
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				// This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) testContext.getWebDrivrManager().getDriver())
						.getScreenshotAs(OutputType.FILE);
				
				
				
				File destinationPath = new File(System.getProperty("user.dir") + "\\" + this.createNewDestFilePath() + "/TC"+screenshotName+ timeStamp+ ".png");
				
				/*File destinationPath = new File(System.getProperty("user.dir") + "\\" + theDir + "/FailedTestsScreenshots/"
						+ screenshotName + timeStamp + ".png");*/
				
				// Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
	}
	
	private File createNewDestFilePath() 
	{
		File destfilePath = new File(theDir + "\\FailedTestScreenShots");
		// if the directory does not exist, create it
		if (!destfilePath.exists()) {
			System.out.println("creating directory: " + destfilePath.getName());
			destfilePath.mkdirs();
		}
		return destfilePath;
	}

	@After(order = 0)
	public void AfterSteps() {
		testContext.getWebDrivrManager().closeDriver();
	}
}
