package extent;

import java.io.File;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import managers.WebDriverManager;

public class ExtentReport 
{
	public static void setup() {
		File theDir;
		String timeStamp;
		WebDriverManager webDriverManager = new WebDriverManager();
		theDir = webDriverManager.getReportPath();
		timeStamp = webDriverManager.getTimeStamp();
		
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath(System.getProperty("user.dir") + "/"+ theDir +"/"+timeStamp+".html");
	}
	
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\configs\\extent-config.xml"));
	}
}
