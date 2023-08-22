package com.generic.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains property file data for Data Driven Testing
 * 
 * @author Vivekanand M
 *
 */
public class PropertiesFileUtility {

	/**
	 * This method read data from property file.
	 * 
	 * @return
	 * @throws IOException
	 */
	public String readPropertiFile(String key) throws IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.PROPERTYFILEPATH);
		Properties properties = new Properties();
		properties.load(file);
		String value = properties.getProperty(key);
		return value;
	}
}
