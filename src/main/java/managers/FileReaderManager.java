package managers;

import dataProvider.ConfigFileReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager= new FileReaderManager();
	private static ConfigFileReader configFileReader = new ConfigFileReader();
	
	public FileReaderManager() {}
	
	public static FileReaderManager getInstance()
	{
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigFileReader()
	{
		return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
	}
}
