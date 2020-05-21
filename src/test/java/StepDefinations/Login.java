package StepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
//import org.testng.Assert; //TestNG Assert class conflicts with Junit

import Base.MyWebDriver;
import PageObjectFunctions.PageObjectManager;
import Utils.ExcelDataReader;
import Utils.Logger;
import Utils.GlobalVars;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import justRunner.TestHooks;

/*import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.testng.pro.QAFAnnotationTransformer2;
import com.qmetry.qaf.automation.step.client.gherkin.GherkinScenarioFactory;
*/

public class Login {
	
	private boolean bActual = true;
	//private static SoftAssert softAssert = new SoftAssert();
	private static String strUsername ="";// PageObjectManager.getPOM().getMyConfig().properties.getProperty("user"); 
	private static String strPassword ="";// PageObjectManager.getPOM().getMyConfig().properties.getProperty("pass");
	//Needs to be included in global step
	private static String FilePath = "src/main/resources/Data/personData.xlsx";
	private static String SheetName = "Sheet1";
	private static String strColName = "";
	public Login() {
		System.out.println("Inside Login()");
	}
	
	//Hooks defined once will execute before/ after every scenario out of the feature file
	@Before
	public static void testStart() {
		System.out.println("INSIDE Before");
		GlobalVars.softAssert = new SoftAssert();
		//VarUtils.gllo = GetDataTable.getListfromExcel(FilePath, SheetName, strColName);
	}
	@After
	public static void testEnd() {
		//TestUtils.testEnd();
		try {
			System.out.println("INSIDE After");
			PageObjectManager.getMyWebDriver().quitDriver();
			System.out.println("quitDriver");
			GlobalVars.softAssert.assertAll();
			//softAssert.assertAll();
			System.out.println("softAssert");
		}
		catch(Exception e) {}
	}
	
	@Given("^Users navigates to the SIA website$")
	public void users_navigates_to_the_SIA_website() throws Throwable {
		Logger.testStart("Login", "Login Verifcation in UAT");
		PageObjectManager.getMyWebDriver().initialization();
		//Assert.assertEquals(false, true); to check dependency failure
	}
	

	@When("^User enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		if (!PageObjectManager.getLoginPage().loginasCustomer(strUsername, strPassword)) {
			bActual = false;
			//softAssert.assertEquals(true, bActual);
			Assert.assertEquals(true, bActual);
			System.out.println("FAIL - User enters username and password");
		}
	}

	@When("^clicks login button$")
	public void clicks_login_button() throws Throwable {
	    System.out.println("Common clicks login button");

	}

	@Then("^User home page is displayed$")
	public void user_home_page_is_displayed() throws Throwable {
		if (!PageObjectManager.getLoginPage().verifyloggedinCustomer("RS")) {
			bActual = false;
			GlobalVars.softAssert.assertEquals(bActual, true);
			System.out.println("FAIL - User home page is displayed");
		}
	}
	
	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String searchKey) throws Throwable {
		System.out.println("inside I_search_for");

	}
	
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void LoginasCustomer(String strUser, String strPass) throws Exception{
		/*
		if (!(strUser.isEmpty() || strUser.equals("")) && (strPass.isEmpty() || strPass.equals(""))){
			strUsername = strUser;
			strPassword = strPass;
		}
		*/
		if (!PageObjectManager.getLoginPage().loginasCustomer(strUser, strPass)) {
			bActual = false;
			//softAssert.assertEquals(true, bActual);
			Assert.assertEquals(true, bActual);
			System.out.println("FAIL - User enters username and password");
		}
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
