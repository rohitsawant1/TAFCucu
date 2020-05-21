package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.MyWebDriver;
import PageObjectFunctions.PageObjectManager;
import Utils.Logger;


public final class LoginPage extends MyWebDriver{
	
	private static LoginPage loginPage;
	

	public LoginPage() throws IOException {
		//super(MyWebDriver.driver); or super(driver); 
		//super(MyWebDriver.str)
		System.out.println("Inside LoginPage()");
		//PageFactory.initElements(MyWebDriver.driver, this);
		PageFactory.initElements(driver, this);
	}
	
	public static LoginPage getLoginPage() throws Exception {
		if (loginPage == null) {
			System.out.println("LOGIN PAGE object is null thus creating a new object");
			return new LoginPage();
		}
		else {
			return loginPage;
		}		
	}
	
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
			//MyWebDriver.initialization();
			btnLogin.click();
			Thread.sleep(2000);
			txtLogin.sendKeys(strUsername);
			txtPassword.sendKeys(strPassword);
			//btnSubmit.click();
			Logger.logMsg("PASS", "Login operation - Success");
			return true;
		}
		catch(Exception e) {
			System.out.println("Error is: "+e.getMessage());
			Logger.logMsg("ERROR", "Login operation - Fail");
		}		
		return false;
	}
	
	public boolean verifyloggedinCustomer(String strUserinfo) throws Exception {
		try {
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
			Logger.logMsg("ERROR", "Login Verification - Fail");
		}
		return false;
	}

}
