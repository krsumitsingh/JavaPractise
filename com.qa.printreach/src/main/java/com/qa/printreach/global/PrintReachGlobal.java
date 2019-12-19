package com.qa.printreach.global;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.qa.printreach.base.TestBase;

public class PrintReachGlobal extends TestBase {

	// PrintReachGlobal class constructor
	public PrintReachGlobal() throws Exception {

	}

	public static final Logger logger = Logger.getLogger(PrintReachGlobal.class
			.getName());

	static boolean flag = false;
	
	String accountWarningMsgTxt = "", estimateSearchNumTxt = "";

	/* ACTIONS */
	// Save and Close button
	public void saveclose(WebElement element) {
		element.click();
	}

	// Save button
	public void save(WebElement element) {
		element.click();
	}

	// Account warning message popup
	public void accountWarningMsg(By locator, By locator1) {
		accountWarningMsgTxt = driver.findElement(locator).getText();
		logger.info("The Name of the Pop up is---"
				+ accountWarningMsgTxt.toString());
		try {
			if (accountWarningMsgTxt.matches("Account Warning Message:")) {
				driver.findElement(locator1).click();
				logger.info("Account Warning Message is closed:");
			}
		} catch (Exception e) {

			logger.info("Account Warning Message Pop up Not Found:");
		}
	}
	
	//Check whether menu item exist or not
	public boolean menuItemPresentAndEnabled(WebElement element){
		if(element.isDisplayed() && element.isEnabled()){
			logger.info("Menu Item is displayed and enabled");
			return flag = true;			
		}else{
			logger.info("Menu Item is not displayed and enabled");
			return flag;
		}
				
	}
	

	// New Estimate Number
	public void newEstimateNumber(WebElement element) {
		estimateSearchNumTxt = element.getText().toString();
		logger.info("New Estimate Number: " + estimateSearchNumTxt + " created");
	}

	/* ESTIMATE COMMON METHODS */
	public String EstimateGetCustmorName() {
		return prop.getProperty("estimatecustname");
	}

	public String EstimateGetProjectName() {
		return prop.getProperty("projecttxt");
	}

	public String EstimateExpectedQty() {
		return prop.getProperty("expqty");
	}
	
}
