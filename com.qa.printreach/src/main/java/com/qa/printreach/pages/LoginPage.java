package com.qa.printreach.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.printreach.base.TestBase;

public class LoginPage extends TestBase {

	public static final Logger logger = Logger.getLogger(LoginPage.class.getName());
	
	/* Page Factory-OR*/	
	@FindBy(xpath="//input[contains(@id,'_UserName')]")
	WebElement username;
	
	@FindBy(xpath="//input[contains(@id,'_Password')]")
	WebElement password;
	
	@FindBy(xpath="//td[contains(@id,'_LoginButton')]//span")
	WebElement loginBtn;
	
	@FindBy(xpath=".//*[@id='aspxCompanyLogo']")
	WebElement loginLogo;
	
		
    /* Initializing the Page Objects:*/
	public LoginPage() throws Exception {
		PageFactory.initElements(driver, this);				
	}
	
    /*Actions*/
	public String validateLoginPageTitle(){
		return driver.getTitle();		
	}
	
	public boolean validateLoginPageImage(){
		return loginLogo.isDisplayed();		
	}
	
	public HomePage validateLogin(String username, String password) throws Exception{
		this.username.sendKeys(username);
		logger.info("User Name Entered: "+username);
		this.password.sendKeys(password);
		logger.info("Password Entered: "+password);
		loginBtn.click();
		logger.info("Login Button is clicked");
		return new HomePage();
	}
}
