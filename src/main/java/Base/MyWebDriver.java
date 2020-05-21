package Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



import Utils.GlobalVars;

public class MyWebDriver extends MyConfig{

	protected static WebDriver driver;
	private static String strbrowser =  ""; //properties.getProperty("browser");
	private static String strdriverPath = ""; //properties.getProperty("driverPath");
	//private String strDir = System.getProperty("user.dir");
	//public static String str;
	//public MyWebDriver(WebDriver driver1) {}
	//public MyWebDriver(String s1) {}
	
	public MyWebDriver() {
		//super();
		strbrowser = properties.getProperty("browser");
		strdriverPath = properties.getProperty("driverPath");
		System.out.println("Inside MyWebDriver");
		if (driver == null) {
			System.out.println("Initialization driver");
			if (strbrowser.equalsIgnoreCase("CHROME")) {
				System.out.println("CHROME");
				System.setProperty("webdriver.chrome.driver", strdriverPath);
				driver = new ChromeDriver();
				driver = registerEvenFiringWD(driver); //driver register with event listner				
			}
			else if (strbrowser.equalsIgnoreCase("FIREFOX")) {
				System.out.println("FIREFOX");
				System.setProperty("webdriver.giko.driver", strdriverPath);
				driver = new FirefoxDriver();
				driver = registerEvenFiringWD(driver); //driver register with event listner
			}
		}	
		else
			System.out.println("Initialization driver is done already");
	}
	public static final void initialization() {
		try {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(GlobalVars.PAGE_LOAD_TIME, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(GlobalVars.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(properties.getProperty("URL"));
		}
		catch(Exception e) {}
	}
	//public abstract  void doStuff();
	
	public static void quitDriver() throws Exception {
		driver.quit();
		driver = null;
	}
	
	private static final WebDriver registerEvenFiringWD(WebDriver driver) {
		
		EventFiringWebDriver EventFiringWD = new EventFiringWebDriver(driver);
		WDEventListner eventListner = new WDEventListner();
		EventFiringWD.register(eventListner);
		return driver;
	}
}
