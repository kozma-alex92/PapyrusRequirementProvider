package hu.bme.mit.papyrus.oslc.adaptor.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class ConfigProperties {
	
	private static Properties properties;
	
	public static void initProperties(){
		
		properties = new Properties();
		FileInputStream input;
		try {
			input = new FileInputStream("resources//config.properties");
			properties.load(input);
			input.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String getPropertyValue(String key){
		return properties.getProperty(key);
	}
	
}
