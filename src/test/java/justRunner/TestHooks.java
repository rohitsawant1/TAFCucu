package justRunner;

import org.testng.asserts.SoftAssert;

import PageObjectFunctions.PageObjectManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks {
	
	//Hooks defined once will execute before/ after every scenario out of the feature file
		/*@Before
		public static void testStart() {
			System.out.println("INSIDE Before");
		}
		@After
		public static void testEnd() {
			//TestUtils.testEnd();
			try {
				System.out.println("INSIDE After");
				PageObjectManager.getMyWebDriver().quitDriver();
				System.out.println("quitDriver");
				//softAssert.assertAll();
				System.out.println("softAssert");
			}
			catch(Exception e) {}
		}
		*/
		//Hooks defined once will execute before/ after every scenario out of the feature file
		

}
