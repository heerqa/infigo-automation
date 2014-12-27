package com.infigo.automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
/**
 * User: Shagufta Naz
 * Date: 1/4/14
 * Time: 12:03 PM
 */
public final class EnvSetUP {
	private static EnvSetUP instance = new EnvSetUP();
	
	private static Properties prop = new Properties();
	private static InputStream input=null;
	
	 /**
     * Singelton access.
     *
     * @return singeton instance
     */
	
	  public static EnvSetUP getInstance() {
	        return instance;
	    }

	  
	    private EnvSetUP() {
	    }


	public String getproperties(String key) {
		String value = null;
		try {

			String filename = "env.properties";
			input = getClass().getClassLoader().getResourceAsStream(filename);
	 
			// load a properties file
			prop.load(input);
	 
			// get the property value and print it out
			value = prop.getProperty(key);
					
			
	 
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	
	
	
}


