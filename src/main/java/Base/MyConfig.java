package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MyConfig {
	
	public static Properties properties;
	private FileInputStream FIS;
	private String strPropertyname = "PropertyNotFound";
	private final String strFilepath = "/Users/rohit_sawant/Documents/Rohit/JavaLearningNewWS/TAFUsingTestNg/src/main/java/Config/config.properties";
	///Users/rohit_sawant/Documents/Rohit/JavaLearningNewWS/TAFUsingTestNg/src/main/java/Config/config.properties
	public MyConfig(){
		try {
		if (properties == null) {
			System.out.println("Inside MyConfig Constructor");
			properties = new Properties();
			FIS = new FileInputStream(strFilepath);	
			properties.load(FIS);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getConfigProperty(String strPropertyname) {
		try {
			this.strPropertyname = properties.get(strPropertyname).toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return this.strPropertyname;
	}

}
