package Web.StepDefLogin;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import Web.PageObjectFunctions.InitPageObject;
import Web.PageObjectFunctions.PageObjectManager;
import Web.PageObjectFunctions.WebdriverManager;

import com.utils.Logger;
import com.utils.GlobalVars;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {//extends InitPageObject{

	private boolean bActual = true;
	WebDriver driver;
	PageObjectManager pageObjectManager = new PageObjectManager();
	WebdriverManager driverManager = new WebdriverManager();
	public Login() throws IOException {

	}
	/*//Hooks defined once will execute before/ after every testcase mapped to the feature file
	@Before
	public void testStart() {
		System.out.println("INSIDE Before"+Thread.currentThread().getId());
		//driver = pageObjectManager.getMyWebDriver().remoteWebdriver();
		//driver = pageObjectManager.getMyWebDriver().standaloneWebdriver();
		//InitPageObject initPageObject = new InitPageObject();
		//System.out.println("Before webdriver value:"+driver);		
		//globalVars.storedDrivers.add(driver);
		GlobalVars.gdriver=driverManager.getDriver();
	}
	@After
	public void testEnd() {
		try {
			System.out.println("INSIDE After"+Thread.currentThread().getId());
			//pageObjectManager.getMyWebDriver().quitDriver(globalVars.storedDrivers.get(0));
			pageObjectManager.getMyWebDriver().quitDriver(GlobalVars.gdriver);
			System.out.println("quitDriver");
			//GlobalVars.softAssert.assertAll();
		}
		catch(Exception e) {}
	}*/

	@Given("^Users navigates to the SIA website$")
	public void users_navigates_to_the_SIA_website() throws Throwable {
		Logger.testStart("Login"+Thread.currentThread().getId(), "Login Verifcation in UAT");
		//System.out.println("hooks.driver: "+hooks.driver);
		//System.out.println("Users navigates to the SIA website");
	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void LoginasCustomer(String strUser, String strPass) throws Exception{
		//loginPage.loginasCustomer(strUsername, strPassword)
		if (!pageObjectManager.getLoginPage().loginasCustomer(strUser, strPass)) {
			bActual = false;
			//softAssert.assertEquals(true, bActual);
			Assert.assertEquals(true, bActual);
			System.out.println("FAIL - User enters username and password");
		}
	}

	@When("^clicks login button$")
	public void clicks_login_button() throws Throwable {
	   // System.out.println("Inside clicks_login_button");

	}

	@Then("^User home page is displayed$")
	public void user_home_page_is_displayed() throws Throwable {
		//System.out.println("Inside user_home_page_is_displayed");
		if (!pageObjectManager.getLoginPage().verifyloggedinCustomer("RS")) {
			bActual = false;
			//GlobalVars.softAssert.assertEquals(bActual, true);
			System.out.println("FAIL - User home page is displayed");
		}
	}
	
	
	
	
	
	
	
	
	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String searchKey) throws Throwable {
		System.out.println("inside I_search_for");

	}
	@Then("^Verify other page items as \"([^\"]*)\" (\\d+) \"([^\"]*)\" (\\d+) (\\d+) \"([^\"]*)\" (\\d+)$")
	public void verify_other_page_items_as(String arg1, int arg2, String arg3, int arg4, int arg5, String arg6, int arg7) {
	   System.out.println("DD: "+arg1+arg2+arg3+arg4+arg5+arg6+arg7);
	}
	private void getWebDriverManager() {
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
	}
}
