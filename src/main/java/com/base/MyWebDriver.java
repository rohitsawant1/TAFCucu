package com.base;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Platform;

import com.utils.GlobalVars;


public class MyWebDriver extends MyConfig{
	private static String strbrowser =  ""; //properties.getProperty("browser");
	private static String strdriverPath = ""; //properties.getProperty("driverPath");
	public WebDriver driver;
	//GlobalVars globalVars = new GlobalVars();
	public MyWebDriver() {
		//System.out.println("inside MyWebDriver");
	}
	
	public WebDriver standaloneWebdriver() {
		try {
			System.out.println("Inside standaloneWebdriver");
			strbrowser = properties.getProperty("browser").toUpperCase();
			strdriverPath = properties.getProperty("driverPath");
			//if (driver == null) {
				switch (strbrowser) {
				case "CHROME":
					System.out.println("CHROME");
					System.setProperty("webdriver.chrome.driver", strdriverPath);
					driver = new ChromeDriver();
					driver = registerEvenFiringWD(driver); //driver register with event listner
					break;
				case "FIREFOX":
					System.out.println("FIREFOX");
					System.setProperty("webdriver.giko.driver", strdriverPath);
					driver = new FirefoxDriver();
					driver = registerEvenFiringWD(driver); //driver register with event listner
					break;
				default:
					System.out.println("CHROME");
					System.setProperty("webdriver.chrome.driver", strdriverPath);
					driver = new ChromeDriver();
					driver = registerEvenFiringWD(driver); //driver register with event listner
					break;
				}
				manageDriver(driver);
			//}	
			//else
				//System.out.println("standaloneWebdriver driver is already initialized");
		}
		catch(Exception e) {}
		return driver;
	}
	
	public WebDriver remoteWebdriver() {
		try {
			System.out.println("Inside remoteWebdriver");
			strbrowser = properties.getProperty("browser").toUpperCase();
			strdriverPath = properties.getProperty("driverPath");
			//DesiredCapabilities capabilities = new DesiredCapabilities();
			if (driver == null) {
				//capabilities.setCapability(CapabilityType.BROWSER_NAME, strbrowser);
				//capabilities.setCapability(CapabilityType.PLATFORM, strbrowser);
				///driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setPlatform(Platform.ANY);
				capabilities.setBrowserName(BrowserType.CHROME);
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
				manageDriver(driver);
			}
			else
				System.out.println("Initialization driver is done already");
		}
		catch(Exception e) {}
		return driver;
	}
	
	public void manageDriver(WebDriver driver) {
		//System.out.println("before storedDrivers size: "+storedDrivers.size());
		//storedDrivers.add(driver);
		//System.out.println("after storedDrivers size: "+storedDrivers.size());
		//driver.manage().window().maximize();
		//GlobalVars.gdriver = driver;
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(GlobalVars.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(GlobalVars.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(properties.getProperty("URL"));//
	}
	
	public static void quitDriver(WebDriver driver) throws Exception {
		driver.quit();
		//driver = null;
	
	}
	public void quitDriver() throws Exception {
		driver.quit();
		//driver = null;
		//storedDrivers.get(0).quit();
		//storedDrivers.remove(0);
	}
	
	private WebDriver registerEvenFiringWD(WebDriver driver) {
		
		EventFiringWebDriver EventFiringWD = new EventFiringWebDriver(driver);
		WDEventListner eventListner = new WDEventListner();
		EventFiringWD.register(eventListner);
		return driver;
	}
}
