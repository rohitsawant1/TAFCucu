package Web.PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.GlobalVars;
import com.utils.Logger;

import Web.PageObjectFunctions.InitPageObject;
import Web.PageObjectFunctions.PageObjectManager;
import Web.PageObjectFunctions.WebdriverManager;


public class LoginPage {
	
	PageObjectManager pageObjectManager = new PageObjectManager();
	//WebdriverManager driverManager = new WebdriverManager();
	//GlobalVars globalVars = new GlobalVars();
	WebDriver driver = GlobalVars.gdriver;
	public LoginPage(){
		
		this.driver = GlobalVars.gdriver;
		PageFactory.initElements(driver, this);
		System.out.println("LoginPage driver value:"+driver);
	}
	/*public LoginPage(WebDriver driver) throws IOException {
		//System.out.println("LoginPage driver value:"+driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}*/
	
	//PO
	//@FindBy(xpath = "//button[contains(text(), 'Log in')]")
	@FindBy(xpath = "//*[@id='hlogin']//button[contains(text(),'Log in')]")
	private WebElement btnLogin;
	
	@FindBy(xpath = "//input[@id='userEmailKfPpsClub']")
	private WebElement txtLogin;
	
	@FindBy(xpath = "//input[@id='userPasswordKfPpsClub']")
	private WebElement txtPassword;
	
	//@FindBy(xpath = "//button[@type='submit']")
	@FindBy(xpath = "//*[@class='login-btn-wrapper']//button[contains(text(), 'LOG IN')]")
	private WebElement btnSubmit;
	
	//@FindBy(xpath = "//a[contains[text(), 'RS']]")
	@FindBy(xpath = "//*[@id='profile-popover-root']")
	private WebElement hrefUser;
	//
	@FindAll(@FindBy(tagName = "a"))
	private List<WebElement> lsa;
	
	public boolean loginasCustomer(String strUsername, String strPassword) throws Exception {
		try {
			System.out.println("Action: loginasCustomer");
			System.out.println("LoginPage driver value:"+driver);
			btnLogin.click();
			Thread.sleep(2000);
			txtLogin.sendKeys(strUsername);
			txtPassword.sendKeys(strPassword);
			//btnSubmit.click();
			//Logger.logMsg("PASS", "Login operation - Success");
			pageObjectManager.logger(driver).logMsg("PASS", "Login operation - Success");
			//logger.logMsg("PASS", "Login operation - Success");
			return true;
		}
		catch(Exception e) {
			System.out.println("Error is: "+e.getMessage());
			pageObjectManager.logger(driver).logMsg("ERROR", "Login operation - Fail");
			//logger.logMsg("ERROR", "Login operation - Fail");
		}		
		return false;
	}
	
	public boolean verifyloggedinCustomer(String strUserinfo) throws Exception {
		try {
			System.out.println("Action: verifyloggedinCustomer");
			if (hrefUser.isDisplayed()) {
				if (hrefUser.getText() == strUserinfo) {
					System.out.println("Verification Pass: Userinfo displayed as expected");
					return true;
				}
				else {
					System.out.println("Verification Fail: Userinfo, Expected: "+strUserinfo +" Actual: "+hrefUser.getText());
				}
			}
			else {
				System.out.println("User info is not dsiplayed");
			}
		}
		catch(Exception e) {
			System.out.println("Error is: "+e.getMessage());
			pageObjectManager.logger(driver).logMsg("ERROR", "Login Verification - Fail");
			//logger.logMsg("ERROR", "Login Verification - Fail");
		}
		return false;
	}

}
