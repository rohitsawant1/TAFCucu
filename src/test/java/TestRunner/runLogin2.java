package TestRunner;
//Junit related
/*import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
*/
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.CucumberOptions;
import com.utils.Logger;

//@RunWith(Cucumber.class)//Junit related
@CucumberOptions(features = {"src/test/resources/Features/Login"}
					, glue = {"Web.StepDefLogin"}
					, plugin = {"pretty", "html:target/reports/test-output", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}
					, monochrome = true
					, strict = true
					, dryRun = false
					, tags = {"@Regression"}//,@SanityTest"} //<- All Sanity
					//tags = {"@Sanity" , "@Regression"} //<- AND
					//tags = {"@Sanity , @Regression"} //<- OR ie. Sanity, Regression, Sanity&Regression
					//tags = {"@E2E" } //<- All scenarios in the feature
					//, tags = {"~@Login1", "~@Login2", "@Login3", "@Login3DT", "@Login3", "@Login3DTTest", "~@Login3Examples_NOEXE"}
					// 'format' been replaced by plugin tag for reporting
				)
public class runLogin2 {
	//Junit related
	/*
	@BeforeClass
	public static void testStart() {
		TestUtils.initReport("login");
		//TestUtils.testStart("Login", "Login Verifcation in UAT");
		System.out.println("INSIDE BeforeClass - initReport");
	}
	@AfterClass 
	public static void testEnd() {
		TestUtils.testEnd();
		System.out.println("INSIDE AfterClass - closeReport");
	}
	*/
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeSuite(alwaysRun = true)
    public void setUpClass() throws Exception {
		System.out.println("inside @BeforeSuite");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        Logger.initReport("IServe Test Suite");
    }
	
	@DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature via TestNG", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
    	System.out.println("Test execution from TestRunner using @DataProvider");
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
    
    @AfterSuite(alwaysRun = true)
    public void tearDownClass() throws Exception {
    	System.out.println("inside @AfterSuite");
        testNGCucumberRunner.finish();
        Logger.closeReport();
    }
    
 
    
	
}
