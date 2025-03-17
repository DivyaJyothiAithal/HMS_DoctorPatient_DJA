package com.MIT.HMS_DJ.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./AppConfigData/MIT_HMS.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String result=prop.getProperty(key);
		return result;
		
	}

}
