package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverTypes;
import enums.EnvironemntTypes;

public class ConfigFileReader
{
	private Properties properties;
	private final String propertyFilePath= "configs\\Configuation.properties";
	
	public ConfigFileReader() 
	{
		BufferedReader reader;
		try
		{
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try
			{
				properties.load(reader);
				reader.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Execptin occurred:"+e);
			}
		}
		catch(FileNotFoundException f)
		{
			System.out.println("File Not Found:"+f);
		}
	}
	
	public long getImplicitWait()
	{
		String implicitWait = properties.getProperty("implicitWait");
		if (implicitWait != null)
		{
			try
			{
				return Long.parseLong(implicitWait);
			}
			catch(Exception e){
				throw new RuntimeException("implicitWait not specified in the Configuration.properties file.");
			}
		}
		return 30;
	}
	
	public long getExplicitWait()
	{
		String explicitWait = properties.getProperty("wait");
		if (explicitWait != null)
		{
			try
			{
				return Long.parseLong(explicitWait);
			}
			catch(Exception e){
				throw new RuntimeException("explicitlyWait not specified in the Configuration.properties file.");
			}
		}
		return 30;
	}
	
	public String getAppUrl()
	{
		String appUrl = properties.getProperty("appUrl");
		if (appUrl == null)
		{
			throw new RuntimeException("app url not specified in the Configuration.properties file.");
		}
		return appUrl;
	}
	
	public EnvironemntTypes getEnvironment()
	{
		String env = properties.getProperty("environment");
		if (env == null || env.equalsIgnoreCase("local"))
		{
			return EnvironemntTypes.LOCAL;
		}
		else if (env.equalsIgnoreCase("remote"))
		{
			return EnvironemntTypes.REMOTE;
		}
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + env);
	}
	
	public DriverTypes getBrowser()
	{
		String browser = properties.getProperty("browser");
		if (browser == null || browser.equalsIgnoreCase("chrome"))
		{
			return DriverTypes.CHROME;
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			return DriverTypes.FIREFOX;
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			return DriverTypes.INTERNETEXPLORER;
		}
		else 
			throw new RuntimeException("Browser Type Key value in Configuration.properties is not matched : " + browser);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}
}
