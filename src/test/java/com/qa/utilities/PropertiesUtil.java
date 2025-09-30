package com.qa.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.qa.constants.EnvConstants;

public class PropertiesUtil {
	
	public static String readProperty(EnvConstants env, String propertyName) {
		File propFile= new File("./src/test/resources/config/"+env+".properties");
		FileReader fileReader=null;
		Properties properties= new Properties();
		try {
			fileReader=new FileReader(propFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			throw new CustomException("File is not found "+e.getMessage());	
		} catch (IOException e) {
			throw new CustomException("File is not loaded: "+e.getMessage());
		}
		
		return properties.getProperty(propertyName.toUpperCase());
	}

}
