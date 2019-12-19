package com.qa.printreach.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.printreach.base.TestBase;

public class CommonMethods extends TestBase {

	//CommonMethods class constructor
	public CommonMethods() throws Exception {

	}

	static boolean flag = false;
	static String actualTxt = "";
	public static final Logger logger = Logger.getLogger(CommonMethods.class
			.getName());
	String accountWarningMsgTxt = "";

	/* Method to verify text element */
	public static boolean verifyTextElement(WebElement element,
			String expectedTxt) {
		try {
			actualTxt = element.getText().toString();
			if (actualTxt.equals(expectedTxt)) {
				logger.info("The text displayed is--" + actualTxt);
				return flag = true;
			} else {
				logger.error("actualText is--" + actualTxt
						+ " expected text is--" + expectedTxt);
				return flag;
			}
		} catch (Exception ex) {
			logger.error("actualText is :" + element.getText()
					+ " expected text is: " + expectedTxt);
			logger.info("text not matching" + ex);
			return flag;
		}
	}

	// for accepting alert
	public void alert_accept(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		logger.info("Message in Alert Popup..." + alert.getText());
		alert.accept();
		waitFor(5);
		logger.info("OK button pressed on the Message alert");
	}

	// For cancelling alert
	public void alert_dismiss(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		logger.info("Message in Alert Popup..." + alert.getText());
		alert.dismiss();
		logger.info("Cancel button pressed on the Message alert");
	}

	// wait using sleep
	public void waitFor(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
	}

	// Explicit wait condition
	public void WaitForXathToPresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
       
	}
	
}
