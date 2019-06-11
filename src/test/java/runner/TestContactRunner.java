package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import extent.ExtentReport;

//public static thrd;
//@RunWith(Cucumber.class)
@CucumberOptions(features = {"resources\\featureFiles\\regressionTest\\contactSendMail2.feature"},
glue = {"stepDefination"},
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:"})
public class TestContactRunner extends AbstractTestNGCucumberTests
{
	@org.testng.annotations.BeforeClass
	public void before() {
		ExtentReport.setup();
	}

	@org.testng.annotations.AfterClass
	public void after() {
		ExtentReport.writeExtentReport();
	}

}
