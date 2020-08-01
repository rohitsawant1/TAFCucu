package Web.PageObjectFunctions;

import Web.PageObject.*;
import com.utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InitPageObject {
	protected static LoginPage loginPage;
	protected Logger logger;
	WebdriverManager driverManager = new WebdriverManager();
	WebDriver driver;
	
	
	public InitPageObject() {
		//driver = mydriver.remoteWebdriver();
		//driver = mydriver.standaloneWebdriver();
		System.out.println("Inside InitPageObject");
		GlobalVars.gdriver = driverManager.getDriver();
		//loginPage = PageFactory.initElements(GlobalVars.gdriver, LoginPage.class);
		//logger = PageFactory.initElements(GlobalVars.gdriver, Logger.class);

	}

}
