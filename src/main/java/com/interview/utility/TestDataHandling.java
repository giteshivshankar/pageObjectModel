package com.interview.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestDataHandling {
	
	FileInputStream file;
	Properties prop;

	public String getProperty(String key) {
		String value = null;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/interview/testData/amazonTestData.properties");
			prop = new Properties();
			prop.load(file);
			value = prop.getProperty(key);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		
	}
}
