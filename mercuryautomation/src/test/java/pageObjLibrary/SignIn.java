package pageObjLibrary;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pkgTestBase.TestBase;

public class SignIn extends TestBase
{	
	public static final Logger logger = Logger.getLogger(SignIn.class.getName());
	WebDriver driver;
	By userName = By.id("PnlLoginPage_loginControl_UserName");
	By passWord = By.id("PnlLoginPage_loginControl_Password");
	By loginBtn = By.id("PnlLoginPage_loginControl_LoginButton");
	
	/*
	 * This constructor will initiate the object
	 */
	public SignIn(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/*
	 * This method will enter user credentials in login page and click on login button
	 */
	public  void clickonSignIn()
	{	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(userName).sendKeys(repo.getProperty("user_name"));
		logger.info("User Name Entered");
		//reportPass();
		//test.log(LogStatus.PASS, "User Name Entered");
		driver.findElement(passWord).sendKeys(repo.getProperty("password"));
		logger.info("Password Entered");
		driver.findElement(loginBtn).click();
		logger.info("Login Button is clicked");
			
	}

		
}
