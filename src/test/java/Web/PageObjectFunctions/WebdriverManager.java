package Web.PageObjectFunctions;

import org.openqa.selenium.WebDriver;
import com.base.MyWebDriver;
import com.utils.GlobalVars;

public class WebdriverManager {
	
	public WebDriver driver;
	public WebDriver getDriver() {
		System.out.println("getStandaloneDriver is: "+driver);
		if(driver == null) {
			driver = new MyWebDriver().standaloneWebdriver();
		}
		return driver;
	}

}
