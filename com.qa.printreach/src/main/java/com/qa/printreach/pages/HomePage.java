package com.qa.printreach.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.printreach.base.TestBase;
import com.qa.printreach.utilities.Utilities;

public class HomePage extends TestBase{

public static final Logger logger = Logger.getLogger(HomePage.class.getName());
	
	/* Page Factory-OR*/	

	@FindBy(xpath = ".//*[@id='ctl00_ASPxMidnight_Logo']")
	public WebElement dashboardlogo;
	
	@FindBy(id = "ctl00_MainMenuSub_DXI0_T")
	public WebElement estimate;
	
	
	
	/* Initializing the Page Objects:*/
	public HomePage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	/*Actions*/
	public boolean validateDashboardImage(){
		logger.info("Dashboard is displayed");
		return dashboardlogo.isDisplayed();	
	
	}
	
	public EstimatesPage validateEstimateSearchPage() throws Exception{
		estimate.click();
		logger.info("User clicked on the Estimate Tab");
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIME,TimeUnit.SECONDS);
		return new EstimatesPage();
	}
	
	
	
	
	
	
	

}
