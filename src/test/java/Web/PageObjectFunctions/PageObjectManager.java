package Web.PageObjectFunctions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.base.MyConfig;
import com.base.MyWebDriver;
import com.utils.Logger;

import Web.PageObject.LoginPage;

public final class PageObjectManager{

	//public  PageObjectManager pageObjectManager = new PageObjectManager();
	public  LoginPage loginPage;
	public  MyConfig myConfig;
	public  MyWebDriver myWebDriver;
	public  Logger logger;
	
	public PageObjectManager(){
		
	}
	/*public  PageObjectManager getPOM() {
		return pageObjectManager;
	}*/
	
	/*public  LoginPage getLoginPage(WebDriver driver) throws Exception {
		if (loginPage == null) {
			return new LoginPage(driver);
		}
		return loginPage;
	}*/
	public  LoginPage getLoginPage() throws Exception {
		if (loginPage == null) {
			return new LoginPage();
		}
		return loginPage;
	}
	public  MyConfig getMyConfig() {
		if (myConfig==null) {
			return (new MyConfig());
		}
		return myConfig;
	}
	public  MyWebDriver getMyWebDriver() {
		try {
			if (myWebDriver == null) {
				System.out.println("getMyWebDriver - Webdriver is null");
				return (new MyWebDriver());
			}
		}
		catch(Exception e) {}
		return myWebDriver;
	}
	public  Logger logger(WebDriver driver) throws Exception {
		if(logger == null) {
			return new Logger(driver);
		}
		return logger;
	}
}
