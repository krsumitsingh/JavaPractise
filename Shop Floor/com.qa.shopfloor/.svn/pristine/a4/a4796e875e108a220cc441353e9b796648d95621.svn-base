/**
 * 
 */
package com.qa.shopfloor.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.shopfloor.base.SPTestBase;

/**
 * @author sumit.singh
 *
 */
public class SPLoginPage extends SPTestBase {
	
	public static final Logger logger = Logger.getLogger(SPLoginPage.class.getName());
	
	@FindBy(name="Username")
	WebElement username;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(xpath="//span[contains(@class,'ui-btn-text')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'ui-header ui-bar-a ui-header')]//span")
	WebElement dcLabel;
	
	public SPLoginPage() throws Exception{
		PageFactory.initElements(driver, this);			
	}
	
	/*public String verifyLoginPageTitle(){
		return driver.getTitle();	
	}*/
	
	public boolean verifyLoginPageImage(){
		return dcLabel.isDisplayed();
	}
	
	public SPHomePage validateLogin(String url, String username, String password) throws Exception{
		driver.get(url);
		logger.info("Logging In:--");
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		this.username.sendKeys(username);
		logger.info("User Name Entered: "+username);
		this.password.sendKeys(password);
		logger.info("User Name Entered: "+password);
		loginBtn.click();
		logger.info("Login Button is clicked");
		return new SPHomePage();
		
	}

}
