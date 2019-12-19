package com.qa.printreach.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.printreach.base.TestBase;
import com.qa.printreach.global.PrintReachGlobal;
import com.qa.printreach.utilities.CommonMethods;

public class EstimatesPage extends TestBase {
	
	EstimatesPage estimatePage;
	String estimate_label = "", estimateNumTxt="",customerNameTxt="",projectNameTxt="",accountWarningMsgTxt="";		
	boolean flag;   
	PrintReachGlobal PRG;
	CommonMethods CM;
	
	public static final Logger logger = Logger.getLogger(EstimatesPage.class
			.getName());
	
	//***OR***	
	@FindBy(xpath="//label[@id='ctl00_mainContentPlaceHolder_titleLabel']")
	public static WebElement estimateLabel;
	
	@FindBy(xpath="//*[@id='ctl00_newAddButtonDiv']//span")
	public WebElement newEstimateBtn;
	
	@FindBy(xpath="//*[contains(@id,'SaveButton_CD')]//span")
	public WebElement saveBtn;
	
	@FindBy(xpath="//*[contains(@id,'submitButton_CD')]//span")
	public WebElement saveCloseBtn;
	
	@FindBy(xpath="//label[@id='ctl00_mainContentPlaceHolder_titleLabel']")
	public WebElement estimateNumber;
	
	public By accountWarningMsg = By
			.xpath("//td[@class='pnlCalculateBookHeader']/label");
	
	public By acctwarningOkBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_pnlWarning']//input");
	
	@FindBy(xpath = ".//*[contains(@id,'customerDropDownList_I')]")
	public WebElement customerName;
	
	@FindBy(xpath = ".//*[contains(@id,'projectTextBox_I')]")
	public WebElement projectName;
	
	@FindBy(xpath = "//*[contains(@id,'DXDataRow0')]/td[1]/a")
	public WebElement estimateSearchNumber;
	
	@FindBy(xpath="//*[contains(@id,'estimateSubMenu_DXI0_T')]/span")
	public WebElement detailsTab;
	
	@FindBy(xpath="//*[contains(@id,'expectedQuantityTextBox_I999')]")
	public WebElement expQty;
	
	
	

	public EstimatesPage() throws Exception {	
		PageFactory.initElements(driver, this);	
		PRG = new PrintReachGlobal();
		CM = new CommonMethods();
	}	
	
	//estimate without customer-validation check
	public void validateEstimateWithoutCustomer(WebElement newEstimateBtn,WebElement saveCloseBtn ) throws Exception{
		try{			
		newEstimateBtn.click();		
		logger.info("The User has clicked on the New Estimate Button:");	
		CM.waitFor(5);
		estimateNumTxt = estimateNumber.getText();
		logger.info("The New Estimate ID is..." + estimateNumTxt.toString());
		PRG.saveclose(saveCloseBtn);
		logger.info("Save and Close Button on the Estimate "+estimateNumTxt+" is clicked:");		
		CM.alert_accept(driver);	
		}catch(Exception ex)
		{
		 logger.error("Errror Occurred "+ex);	
		 Assert.fail("***Test Case Failed***");
		}
	}

	//Create an estimate without services
	public void validateEstimateWithoutServices() throws Exception{	
		try{		
		newEstimateBtn.click();		
		CM.waitFor(5);
		customerName.sendKeys(PRG.EstimateGetCustmorName());
		customerName.sendKeys(Keys.ENTER);
		customerNameTxt = PRG.EstimateGetCustmorName().toString();
		logger.info("Customer"+customerNameTxt+" added");
		CM.waitFor(5);	
		CM.WaitForXathToPresent(accountWarningMsg);		
		PRG.accountWarningMsg(accountWarningMsg, acctwarningOkBtn);	
		CM.waitFor(5);	
		projectName.sendKeys(Keys.CONTROL+"a");
		CM.waitFor(3);
		projectName.sendKeys(PRG.EstimateGetProjectName());
		projectNameTxt = PRG.EstimateGetProjectName().toString();
		logger.info(projectNameTxt+" entered:");
		CM.waitFor(3);
		try{	
		PRG.saveclose(saveCloseBtn);
		logger.info("Save and Close button is clicked:");
		}catch(Exception ex)
		{
			 logger.error("Errror Occurred "+ex);	
			 //Assert.fail("***Test Case Failed***");
		}
		CM.waitFor(5);
		PRG.newEstimateNumber(estimateSearchNumber);
		
		}catch(Exception ex){
			 logger.error("Errror Occurred "+ex);	
			 Assert.fail("***Test Case Failed***");
		}
	}
	
	
	//Create an estimate with service
	public void validateEstimateWithService(WebElement element, String menuItemExpTxt){
		try{		
			newEstimateBtn.click();		
			CM.waitFor(5);
			customerName.sendKeys(PRG.EstimateGetCustmorName());
			customerName.sendKeys(Keys.ENTER);
			customerNameTxt = PRG.EstimateGetCustmorName().toString();
			logger.info("Customer"+customerNameTxt+" added");
			CM.waitFor(5);	
			CM.WaitForXathToPresent(accountWarningMsg);		
			PRG.accountWarningMsg(accountWarningMsg, acctwarningOkBtn);	
			CM.waitFor(5);	
			projectName.sendKeys(Keys.CONTROL+"a");
			CM.waitFor(3);
			projectName.sendKeys(prop.getProperty("projecttxt1"));
			projectNameTxt = prop.getProperty("projecttxt1").toString();
			logger.info(projectNameTxt+" entered:");
			CM.waitFor(3);
			flag = CommonMethods.verifyTextElement(element,menuItemExpTxt);
			assertTrue(flag, "Estimate MenuItem Text not correct");	
			flag=PRG.menuItemPresentAndEnabled(element);
			assertTrue(flag, "MenuItem Not Enabled");		
			expQty.sendKeys(PRG.EstimateExpectedQty());
			CM.waitFor(3);
			
			
			
			
			try{	
			PRG.saveclose(saveCloseBtn);
			logger.info("Save and Close button is clicked:");
			}catch(Exception ex)
			{
				 logger.error("Errror Occurred "+ex);	
				 //Assert.fail("***Test Case Failed***");
			}
			CM.waitFor(5);
			PRG.newEstimateNumber(estimateSearchNumber);
			
			}
			catch(Exception ex)
			{
				 logger.error("Errror Occurred "+ex);	
				 Assert.fail("***Test Case Failed***");
				
				
			}

	}


	
	
	
	
	
	
	
	
	
	

	

}
