package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import extent.ExtentReport;

//@RunWith(Cucumber.class)
@CucumberOptions(features = { "resources\\featureFiles\\regressionTest\\contactParameter.feature" }, glue = {
		"stepDefination" }, plugin = { "com.cucumber.listener.ExtentCucumberFormatter:" })
public class TestRunner extends AbstractTestNGCucumberTests {
	@org.testng.annotations.BeforeClass
	public void before() {
		ExtentReport.setup();
	}

	@org.testng.annotations.AfterClass
	public void after() {
		ExtentReport.writeExtentReport();
	}

}
