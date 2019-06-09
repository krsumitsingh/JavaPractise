package pageObjLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class printCalculator extends EstimatesPage {

	WebDriver driver;
	EstimatesPage es;

	public static final Logger logger = Logger.getLogger(printCalculator.class
			.getName());

	/* Variables Defined */
	boolean image = false;
	String template_grp = "";
	String text_name = "";
	String template_name = "";
	String PreCutTime ="";
	String FinCutTime = "";
	String PreCut_Cutter_Hourly_Rate = "";
	String FinCut_Cutter_Hourly_Rate ="";
	String PreSetupCost = "";
	String FinishSetupCost = "";	
	double Pre_CutTime;
	double Fin_CutTime1;
	double PreCut_CutterHourlyRate;
	double FinCut_CutterHourlyRate;
	double Pre_SetupCost;
	double Finish_SetupCost;

	
	 /* XPATHS/ID's/CSS DEFINED */	 
	By printTab = By.xpath("//*[@class='dxmMenuItem']//*[text()='Print']");
	By templateGrpDropDown = By
			.xpath("//*[@id='MainPrintPnl_ddlServiceGroup_I']");
	By templateNameDropDown = By
			.xpath("//*[@id='MainPrintPnl_PEProductType_I']");
	By description = By
			.xpath("//*[@id='MainPrintPnl_txtPEDescription_I']");
	By pcSave = By
			.xpath("//*[@class='dxb']//*[text()='Save']");
	By pcSubmit = By
			.xpath("//*[@class='dxb']//*[text()='Submit']");
	By pcLaunchLink = By
			.xpath("//*[@class='dxb']//*[text()='Launch']");
	By MoreDetailsLink = By
			.xpath("//*[@id='MainPrintPnl_moreDetail']");
	/*By MoreDetailsLink = By
			.xpath("//*[@class='dxeHyperlink more-btn']");*/
	
	By PreCutTab = By
			.xpath(".//*[@id='MainPrintPnl_cutterSubMenu_DXI0_T']/span");
	By Pre_SetUpCost = By
			.xpath(".//*[@id='MainPrintPnl_txtSetupCostPre_I']");
	By Pre_CutterHourlyRate = By
			.xpath(".//*[@id='MainPrintPnl_txtCutterHourlyRatePre_I']");


	 /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	
	public printCalculator(WebDriver driver) {
		this.driver = driver;
	}

	/* This method will create a new estimate with finishing service */
	public void services() throws Exception {
		es = new EstimatesPage(driver);
		es.estimate_with_services();
	}

	/* This will launch PC****** */
	public void printCal() throws Exception {
		// ********This will select Print department and click on it**********
		WebDriverWait wait = new WebDriverWait(driver, 20);
		text_name = driver.findElement(printTab).getText();
		logger.info("Selecting.." + text_name + " "
				+ "Department and entering line item to it");
		waitFor(5);
		driver.findElement(printTab).click();
		waitFor(5);

		// ********This will add print calculator service to print department*******
		driver.findElement(wideFormatServiceField).click();
		driver.findElement(wideFormatServiceField).sendKeys("_Flyer Print");
		driver.findElement(wideFormatServiceField).sendKeys(Keys.TAB);
		waitFor(5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.cssSelector("#ctl00_mainContentPlaceHolder_iframePrintCalculator")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.cssSelector("#aspxCallPnlMain_iframePrintCalc")));
		waitFor(10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//img[@id='MainPrintPnl_ASPxImage5']")));
		image = driver.findElement(
				By.xpath("//img[@id='MainPrintPnl_ASPxImage5']")).isDisplayed();
		if (image == false)
			logger.info("The Print Calculator does not exits");
		else
			logger.info("The Print Calculator exits");
		waitFor(5);
		driver.findElement(templateGrpDropDown).sendKeys(
				repo.getProperty("templateGrp"));
		template_grp = driver.findElement(templateGrpDropDown).getAttribute(
				"value");
		logger.info("The Template --" + template_grp.toString()
				+ " --is selected");
		driver.findElement(templateGrpDropDown).sendKeys(Keys.TAB);
		waitFor(8);
		driver.findElement(templateNameDropDown).sendKeys(Keys.CLEAR);
		driver.findElement(templateNameDropDown).sendKeys(
				repo.getProperty("tempname"));
		template_name = driver.findElement(templateNameDropDown).getAttribute(
				"value");
		logger.info("The Template Name:-- " + template_name.toString()
				+ " --is selected");
		waitFor(3);
		driver.findElement(templateNameDropDown).sendKeys(Keys.TAB);
		waitFor(3);
		desc_text = driver.findElement(description).getAttribute("value");
		logger.info("The Description is:-- " + desc_text.toString());
		driver.findElement(pcSave).click();
		waitFor(8);
		/*driver.findElement(pcSubmit).click();
		driver.switchTo().defaultContent();
		waitFor(8);
		driver.findElement(saveBtn).click();
		waitFor(8);*/
	}

	/* This will relaunch PC****** */
	public void printCalRelaunch() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(pcLaunchLink).click();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.cssSelector("#ctl00_mainContentPlaceHolder_iframePrintCalculator")));
		/*waitFor(8);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.cssSelector("#aspxCallPnlMain_iframePrintCalc")));*/
		waitFor(8);
	}
	
	/* This will calculate the value of Cut Cost */
	public void GetValue_Cut_Cost() throws InterruptedException{
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		waitFor(8);
		driver.findElement(MoreDetailsLink).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(MoreDetailsLink)).click();
		//driver.findElement(MoreDetailsLink).click();
		
		driver.findElement(PreCutTab).click();
		
		PreCut_Cutter_Hourly_Rate = driver.findElement(Pre_CutterHourlyRate).getAttribute("value").replace("$", "");
		logger.info("The value of Pre Cutter Hourly Rate is:$"+PreCut_Cutter_Hourly_Rate);
		
		
		
		
	}
	
	
	
	
	
}
