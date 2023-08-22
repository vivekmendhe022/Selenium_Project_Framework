package com.generic.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream("");
		Properties properties = new Properties();
		properties.load(file);
		String value=properties.getProperty(key);
		return value;
	}
}
