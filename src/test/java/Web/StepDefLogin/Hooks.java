package Web.StepDefLogin;

import com.utils.GlobalVars;

import Web.PageObjectFunctions.InitPageObject;
import Web.PageObjectFunctions.PageObjectManager;
import Web.PageObjectFunctions.WebdriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends InitPageObject{
	PageObjectManager pageObjectManager = new PageObjectManager();
	WebdriverManager driverManager = new WebdriverManager();
	
	//Hooks defined once will execute before/ after every testcase mapped to the feature file
		@Before
		public void testStart() {
			System.out.println("****TEST START****");
			System.out.println("INSIDE Before"+Thread.currentThread().getId());
			//driver = pageObjectManager.getMyWebDriver().remoteWebdriver();
			//driver = pageObjectManager.getMyWebDriver().standaloneWebdriver();
			//InitPageObject initPageObject = new InitPageObject();
			//System.out.println("Before webdriver value:"+driver);		
			//globalVars.storedDrivers.add(driver);
			
			//1. Environment refresh for execution
			//close all open browser 
			//GlobalVars.gdriver=driverManager.getDriver();
		}
		@After
		public void testEnd() {
			try {
				System.out.println("INSIDE After"+Thread.currentThread().getId());
				//pageObjectManager.getMyWebDriver().quitDriver(globalVars.storedDrivers.get(0));
				System.out.println("driver value: "+GlobalVars.gdriver);
				pageObjectManager.getMyWebDriver().quitDriver(GlobalVars.gdriver);
				System.out.println("quitDriver");
				System.out.println("****TEST END****");
				//GlobalVars.softAssert.assertAll();
			}
			catch(Exception e) {}
		}

}
