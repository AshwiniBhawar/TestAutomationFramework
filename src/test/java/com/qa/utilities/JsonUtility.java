package com.qa.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.qa.constants.EnvConstants;
import com.qa.pojo.Config;
import com.qa.pojo.Config.Environment;

public class JsonUtility {
	private static Config.Environment environment;
	
	public static Environment readJSONFile(EnvConstants env) {
		Gson gson= new Gson();
		
		File jsonFile= new File("./src/test/resources/config/config.json");
		FileReader fileReader=null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			throw new CustomException("File is not found "+e.getMessage());
		}
		Config config=gson.fromJson(fileReader, Config.class);
		
		if(env.toString().equals("QA")) {
			environment=config.getEnvironments().get("QA");
		}
		else if(env.toString().equals("DEV")) {
			environment=config.getEnvironments().get("DEV");
		}
		else if(env.toString().equals("UAT")) {
			environment=config.getEnvironments().get("UAT");
		}
		else {
			throw new CustomException("Enter correct enviornmnet..QA, DEV, UAT");
		}
		
		String url=environment.getUrl();
		System.out.println(url);
	    return environment;
	}

}
