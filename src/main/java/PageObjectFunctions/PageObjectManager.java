package PageObjectFunctions;

import java.io.IOException;

import Base.MyConfig;
import Base.MyWebDriver;
import PageObject.LoginPage;
import Utils.Logger;

public final class PageObjectManager{

	private static PageObjectManager pageObjectManager = new PageObjectManager();
	private static LoginPage loginPage;
	private static MyConfig myConfig;
	private static MyWebDriver myWebDriver;
	private static Logger testUtils;
	
	private PageObjectManager(){
		
	}
	public static PageObjectManager getPOM() {
		return pageObjectManager;
	}
	
	public static LoginPage getLoginPage() throws Exception {
		if (loginPage == null) {
			return new LoginPage();
		}
		return loginPage;
	}
	public static MyConfig getMyConfig() {
		if (myConfig==null) {
			return (new MyConfig());
		}
		return myConfig;
	}
	public static MyWebDriver getMyWebDriver() {
		try {
			if (myWebDriver == null) {
				return (new MyWebDriver());
			}
		}
		catch(Exception e) {}
		return myWebDriver;
	}
	public static Logger getTestUtils() throws Exception {
		if(testUtils == null) {
			return new Logger();
		}
		return testUtils;
	}
}
