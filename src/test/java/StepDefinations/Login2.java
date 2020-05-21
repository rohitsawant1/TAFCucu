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
import Utils.Logger;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import justRunner.TestHooks;


public class Login2 {
	
	private boolean bActual = true;
	/*private static SoftAssert softAssert = new SoftAssert();*/
	/*
	public Login2() {
		System.out.println("Inside Login2()");
	}
	
	@Before
	public static void testStart2() {
		//TestUtils.initReport("login");
		//TestUtils.testStart("Data Table", "Verify the datatable list");
		System.out.println("INSIDE Before");
	}
	@After
	public static void testEnd2() {
		//TestUtils.testEnd();
		try {
			System.out.println("INSIDE After");
			PageObjectManager.getMyWebDriver().quitDriver();
			System.out.println("quitDriver");
			softAssert.assertAll();
			System.out.println("softAssert");
		}
		catch(Exception e) {}
	}
	*/
	@Then("^Enter my current nominee details$")
	public void enter_my_current_nominee_details(DataTable dt) throws Throwable {
		//Extent report ->> needs to be included in the first test step
		Logger.testStart("Data Table", "Verify the datatable list");
		System.out.println("using datatable.raw");
		List<List<String>> lls = dt.raw();
		for(int i=0; i<lls.size(); i++) {
			System.out.println(i+": "+lls.get(i).get(0)+lls.get(i).get(1)+lls.get(i).get(2));
		}
		//OR
		System.out.println("using datatable.maps");
		List<Map<String, String>> data = dt.asMaps(String.class,String.class);
		for(int i=0; i<data.size(); i++) {
			System.out.println(i+": "+data.get(i).get("name")+data.get(i).get("age")+data.get(i).get("sex")); 
		}
	}
}
