package pageObjLibrary;

import java.text.DecimalFormat;
import java.time.LocalTime;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pkgTestBase.TestBase;

public class EstimatesPage extends TestBase {

	WebDriver driver;

	public static final Logger logger = Logger.getLogger(EstimatesPage.class
			.getName());

	/*
	 * Variables
	 * DEFINED++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++
	 */
	LocalTime startTime;
	LocalTime endTime;
	String estimate_label = "";
	String estimate_search = "";
	String estimate_Id = "";
	String menuItem = "";
	String estnum = "";
	String text_name = "";
	String accountWarningMsg = "";
	String text_name1 = "";
	String dataDept = "";
	String extpricetotal = "";
	String totalandtax = "";
	String detailLinkText = "";
	String text_name2 = "";
	String ExtPrice = "";
	String TaxPercentage1 = "";
	String TaxPercentage2 = "";
	Double Amt1;
	Double Amt2;
	Double TaxTotal;
	Double LineItemTotal;
	String totalAndTax1 = "";
	String totalAndTax2 = "";
	String wideFormatText = "";
	String calcLabel = "";
	String contractTemplate = "";
	String projectNameContractTemplateTxt = "";
	String fullFillmentDeptTxt = "";
	String orderexportedMessage = "";
	String exportedOrderNum = "";
	String copyEstimateNum = "";
	String attachmentTabMsg = "";
	String docTypeTxt = "";
	boolean image = false;
	String template_grp = "";
	String template_name = "";
	String desc_text = "";

	/*
	 * XPATHS/ID's/CSS
	 * DEFINED++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	By estimatelabel = By.id("ctl00_MainMenuSub_DXI0_T");
	By estimateSearch = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_titleLabel']");
	By newEstimateBtn = By.xpath("//*[@id='ctl00_newAddButtonDiv']//span");
	By esitmateId = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_titleLabel']");
	By saveBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_SaveButton_CD']//span");
	By customerName = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_customerDropDownList_I']");
	By accountWarning = By.xpath("//td[@class='pnlCalculateBookHeader']/label");
	By acctwarningOkBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_pnlWarning']//input");
	By contact = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_contactDropDownList_I']");
	By salesrep = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_salesDropDownList_I']");
	By csr = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_csrDropDownList_I']");
	By projfield = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_projectTextBox_I']");
	By detailstab = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_estimateSubMenu_DXI0_T']");
	By expectedQty = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_expectedQuantityTextBox_I']");
	By saveclose = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_submitButton']//span");
	By estimatenumber = By
			.xpath("//tr[@id='ctl00_mainContentPlaceHolder_estimateSearchGridView_DXDataRow0']/td[1]/a");
	By dataTab = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_estimateSubMenu_DXI4_T']/label");
	By servicesTextField = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_1_pnlGridViewServices_serviceCodeEditComboBox_I']");
	By ExtPriceTotal = By
			.xpath("*//label[@id='ctl00_mainContentPlaceHolder_priceTotalTextBoxLabel']");
	By TotalAndTax = By
			.xpath("*//label[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_serviceTotalDueLabel']");
	By detailLinks = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_6_estimateDetailButton']//span");
	By serviceInfoPage = By.cssSelector("#ctl00_iframeCommonPopup");
	By servicePageLabel = By.xpath("//label[@id='serviceHeaderLabel']");
	By wizardService = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell1_1_pnlGridViewServices_serviceCodeEditComboBox_I']");
	By wizardScreen = By
			.cssSelector("#ctl00_mainContentPlaceHolder_iframeServiceWizard");
	By wizardDescLabel = By
			.xpath("//label[@id='serviceWizardDescriptionTextLabel']");
	By wideFormatDept = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_estimateSubMenu_DXI10_T']");
	By genericCalc = By
			.cssSelector("#ctl00_mainContentPlaceHolder_iframeWideFormat");
	By wideFormatServiceField = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_1_pnlGridViewServices_serviceCodeEditComboBox_I']");
	By awfServiceField = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell1_1_pnlGridViewServices_serviceCodeEditComboBox_I']");
	By contractTemplateLink = By
			.xpath("//*[@class='fontBold']//*[text()='Attach Contract Pricing']");
	By contractTemplatePage = By.cssSelector("#ctl00_iframeCommonPopup");
	By projectName_ContractTemplate = By
			.xpath("//*[@id='projectSearchGridView_cell1_0_ProjectCheckBox_I']");
	By fullFillmentDept = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_estimateSubMenu_DXI9_T']/label");
	By exportOrderBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_EstToOrderButton_CD']/span");
	By orderexported = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_CopiedMsgLabel']");
	By ORDERId = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_titleLabel']");
	By estimateCopyBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_copyButton']//span");
	By BtnCopyOK = By
			.xpath(".//*[@id='ctl00_mainContentPlaceHolder_btEstimateCopied']");
	By attachmentTab = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_estimateSubMenu_DXI13_T']/span");
	By documentType1 = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_linksGridView_footer0_documentTypeComboBox_I']");
	By fileNameField1 = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_linksGridView_footer1_documentTextBox_I']");
	By uploadFileBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_linksGridView_footer1_fileUpload_Input_0']");
	By saveDisketteBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_linksGridView_footer2_addImageButton']");
	By deleteBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_deleteButton']//span");
	By mq = By.xpath("//label[text()='Multiple Qtys']");
	By mqUpdateQtyBtn = By
			.xpath("//*[@class='PointerClass']//*[text()='Update Pricing']");
	By printTab = By.xpath("//*[@class='dxmMenuItem']//*[text()='Print']");
	By templateGrpDropDown = By
			.xpath("//*[@id='MainPrintPnl_ddlServiceGroup_I']");
	By templateNameDropDown = By
			.xpath("//*[@id='MainPrintPnl_PEProductType_I']");
	By description = By.xpath("//*[@id='MainPrintPnl_txtPEDescription_I']");
	//By pcSave = By.xpath("//*[@class='dxb']//*[text()='Save']");
	By pcSave = By.xpath(".//*[@id='MainPrintPnl_PEItemProcessButton_CD']/span");
	//By pcSubmit = By.xpath("//*[@class='dxb']//*[text()='Submit']");
	By pcSubmit = By.xpath(".//*[@id='MainPrintPnl_PESubmitButton_CD']/span");
	
	
	/*
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++
	 */

	public EstimatesPage() {
	}

	public EstimatesPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will verify the validation displayed when new estimate is
	 * created without selecting the customer
	 */
	public void save_without_customer() throws Exception {
		estimate_label = driver.findElement(estimatelabel).getText();
		logger.info("The label name is---" + estimate_label.toString());
		driver.findElement(estimatelabel).click();
		estimate_search = driver.findElement(estimateSearch).getText();
		logger.info("The User is on the: " + estimate_search.toString()
				+ " page");
		driver.findElement(newEstimateBtn).click();
		logger.info("The User has clicked on the New Estimate Button:");
		waitFor(5);
		estimate_Id = driver.findElement(esitmateId).getText();
		logger.info("The New Estimate ID is..." + estimate_Id.toString());
		driver.findElement(saveBtn).click();
		logger.info("Save Button on the Estimate# page is clicked:");
		alert_accept();
	}

	/*
	 * This method will create a new estimate without adding finishing services
	 */
	public void estimate_without_services() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		driver.findElement(customerName)
				.sendKeys(repo.getProperty("cust_name"));
		logger.info("Customer Name Entered");
		driver.findElement(customerName).sendKeys(Keys.ENTER);
		waitFor(10);
		wait.until(ExpectedConditions.presenceOfElementLocated(accountWarning));
		accountWarningMsg = driver.findElement(accountWarning).getText();

		logger.info("The Name of the Pop up is---" + accountWarningMsg);
		try {
			if (accountWarningMsg.matches("Account Warning Message:")) {
				driver.findElement(acctwarningOkBtn).click();
			}
		} catch (Exception e) {

			logger.info("Account Warning Message Pop up Not Found:");
		}
		// *****This will add a contact in the contact drop down..****
		driver.findElement(contact).sendKeys(Keys.CONTROL + "a");
		driver.findElement(contact).sendKeys(repo.getProperty("contact_name"));
		logger.info("Contact Name Entered");
		driver.findElement(contact).sendKeys(Keys.TAB);

		// *****This will add a sales rep in the sales rep drop down...****
		driver.findElement(salesrep)
				.sendKeys(repo.getProperty("sales_contact"));
		logger.info("Sales Rep Entered");
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);

		// ******This will add a csr in the csr drop down...******
		driver.findElement(csr).sendKeys(repo.getProperty("csr"));
		logger.info("CSR Entered");
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		driver.findElement(projfield).sendKeys(repo.getProperty("projecttxt"));
		logger.info("Project Name Entered");
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {

			logger.info("Currently under " + menuItem + " tab");

			// ********This will add a expected qty of 1000 and clicks on save
			// and submit to close the estimate page********
			driver.findElement(expectedQty)
					.sendKeys(repo.getProperty("expqty"));
			logger.info("Expected Qty Entered");
			driver.findElement(saveclose).click();
			logger.info("Save and Close Button on the estimate page clicked");
			waitFor(5);
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(estimateSearch));
		text_name = driver.findElement(estimateSearch).getText();

		logger.info("User is on the.." + text_name.toString());
		waitFor(3);
		text_name = driver.findElement(estimatenumber).getText();

		logger.info("New estimate Id.." + text_name.toString());
		estnum = "# " + text_name;
		try {
			if (estnum.matches(estimate_Id)) {

				logger.info("The New Estimate#--" + estnum
						+ "is created successfully");
			}
		} catch (Exception e) {

			logger.info("The Estimate# was not created");
		}
	}

	/* This method will create a new estimate with finishing service */
	public void estimate_with_services() throws Exception {
		// *****A new estimate will be created*********
		WebDriverWait wait = new WebDriverWait(driver, 5);
		estimate_label = driver.findElement(estimatelabel).getText();

		logger.info("The label name is---" + estimate_label.toString());
		driver.findElement(estimatelabel).click();
		estimate_search = driver.findElement(estimateSearch).getText();

		logger.info("The User is on the: " + estimate_search.toString()
				+ " page");
		driver.findElement(newEstimateBtn).click();

		logger.info("The User has clicked on the New Estimate Button:");
		waitFor(5);
		estimate_Id = driver.findElement(esitmateId).getText();

		logger.info("The New Estimate ID is..." + estimate_Id.toString());
		driver.findElement(customerName).sendKeys(
				repo.getProperty("cust_name1"));
		logger.info("Customer Name Entered");
		driver.findElement(customerName).sendKeys(Keys.ENTER);
		waitFor(10);
		wait.until(ExpectedConditions.presenceOfElementLocated(accountWarning));
		accountWarningMsg = driver.findElement(accountWarning).getText();

		logger.info("The Name of the Pop up is---" + accountWarningMsg);
		try {
			if (accountWarningMsg.matches("Account Warning Message:")) {
				driver.findElement(acctwarningOkBtn).click();
			}
		} catch (Exception e) {

			logger.info("Account Warning Message Pop up Not Found:");
		}
		// *****This will add a contact in the contact drop down..****
		driver.findElement(contact).sendKeys(Keys.CONTROL + "a");
		driver.findElement(contact).sendKeys(repo.getProperty("contact_name1"));
		logger.info("Contact Name Entered");
		driver.findElement(contact).sendKeys(Keys.TAB);

		// *****This will add a sales rep in the sales rep drop down...****
		driver.findElement(salesrep).sendKeys(
				repo.getProperty("sales_contact1"));
		logger.info("Sales Rep Entered");
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);

		// ******This will add a csr in the csr drop down...******
		driver.findElement(csr).sendKeys(repo.getProperty("csr1"));
		logger.info("CSR Entered");
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		driver.findElement(projfield).sendKeys(repo.getProperty("projecttxt1"));
		logger.info("Project Name Entered");
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {

			logger.info("Currently under " + menuItem + " tab");

			// ********This will add a expected qty of 1890 and clicks on save
			// and submit to close the estimate page********
			driver.findElement(expectedQty).sendKeys(
					repo.getProperty("expqty1"));
			logger.info("Expected Qty Entered");
			// This will select Data department and click on it
			dataDept = driver.findElement(dataTab).getText();

			logger.info("Selecting.." + dataDept + " "
					+ "Department and entering line item to it");
			driver.findElement(dataTab).click();

			// ********This will add line item to data department*******

			driver.findElement(servicesTextField).click();
			waitFor(5);
			driver.findElement(servicesTextField).sendKeys(
					repo.getProperty("servicename"));
			driver.findElement(servicesTextField).sendKeys(Keys.TAB);
			waitFor(10);

			logger.info("Service is Added In The Data Department");
		}
	}

	// This method will calculate tax
	public void tax_calculation() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		extpricetotal = driver.findElement(ExtPriceTotal).getText();
		waitFor(5);
		totalandtax = driver.findElement(TotalAndTax).getText()
				.replace("$", "");
		double totalandtax1 = Double.parseDouble(totalandtax);
		logger.info("The Extended Price Total of line item is: "
				+ extpricetotal.toString());
		logger.info("The Extended Price Total & Tax of line items is: "
				+ totalandtax1);

		// ********This will click on details link and open service information
		// page********
		driver.findElement(detailLinks).click();
		detailLinkText = driver.findElement(detailLinks).getText();
		logger.info("The " + detailLinkText.toString() + " link is clicked");
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(serviceInfoPage));
		text_name2 = driver.findElement(servicePageLabel).getText();
		logger.info("The " + text_name2.toString() + " page opened");
		waitFor(5);

		// *******Tax Calculation*****
		ExtPrice = driver
				.findElement(By.xpath("*//label[@id='subTotalTextBoxLabel']"))
				.getText().replace("$", "");
		double ExtPrice1 = Double.parseDouble(ExtPrice);
		logger.info("Ext. Price on Detail popup :" + ExtPrice1);
		TaxPercentage1 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell0_1_taxPercentLabel']"))
				.getText().replace("%", "");
		double TaxPercentagenew1 = Double.parseDouble(TaxPercentage1);
		logger.info("Tax % on first row Detail popup :" + TaxPercentagenew1);
		Amt1 = (ExtPrice1 * TaxPercentagenew1) / 100;
		TaxPercentage2 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell1_1_taxPercentLabel']"))
				.getText().replace("%", "");
		double TaxPercentagenew2 = Double.parseDouble(TaxPercentage2);
		logger.info("Tax % on second row Detail popup :" + TaxPercentagenew2);
		Amt2 = (ExtPrice1 * TaxPercentagenew2) / 100;
		TaxTotal = Amt1 + Amt2;
		TaxTotal = Double.parseDouble(new DecimalFormat("0.00")
				.format(TaxTotal));
		logger.info("Tax Total amount on detail pop up :" + TaxTotal);
		LineItemTotal = ExtPrice1 + TaxTotal;
		logger.info("Line Item Total amount on detail pop up :" + LineItemTotal);
		if (LineItemTotal.equals(totalandtax1)) {
			logger.info("Tax calculation is correct:");
			logger.info("The Extended Price is:" + "" + ExtPrice + ","
					+ "The Tax Total is:" + "" + TaxTotal + ","
					+ "Line Item Total with Taxes is:" + "" + LineItemTotal);
		} else {

			logger.info("Tax calculation is incorrect:");
		}
		driver.findElement(By.xpath("//table[@id='cancelButton']//span"))
				.click();
		logger.info("Service Information Page is closed:");
		driver.switchTo().defaultContent();
		waitFor(5);
		/*driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page# to save it");
		waitFor(5);*/
	}

	// This method will add wizard type service
	public void add_wizard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.findElement(wizardService).click();
		waitFor(8);
		driver.findElement(wizardService).sendKeys(
				repo.getProperty("wizservicename"));
		logger.info("Wizard Type Service added");
		driver.findElement(wizardService).sendKeys(Keys.TAB);
		waitFor(8);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(wizardScreen));
		text_name1 = driver.findElement(wizardDescLabel).getText();
		logger.info("The " + text_name1.toString() + " page opened");
		driver.findElement(
				By.xpath("//td[@id='serviceWizardGridView_cell0_0_wizardTextButton_B']//span"))
				.click();
		logger.info("Selecting the wizard type successor from the wizard page");
		driver.switchTo().defaultContent();
		waitFor(8);
		/*logger.info("Wizard Type Service Added");
		driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page# to save it");*/
	}

	/*
	 * This method will add simple wide format calc type service into wide
	 * format dept
	 */
	public void swf() throws Exception {
		waitFor(5);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wideFormatText = driver.findElement(wideFormatDept).getText();
		driver.findElement(wideFormatDept).click();
		logger.info("Selecting.." + wideFormatText + " "
				+ "Department and entering line item to it");
		waitFor(5);
		/* ********This will add simple wide format service to wide format */
		driver.findElement(wideFormatServiceField).click();
		waitFor(8);
		driver.findElement(wideFormatServiceField).sendKeys(
				repo.getProperty("swflaunchserv"));
		driver.findElement(wideFormatServiceField).sendKeys(Keys.TAB);
		waitFor(5);
		/*
		 * ********Launch Simple Wide Format calculator/adding product to it and
		 * click on Save
		 */
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(genericCalc));
		calcLabel = driver.findElement(By.xpath("//label[@id='ASPxLabel72']"))
				.getText();
		logger.info("The " + calcLabel.toString() + " page opened");
		driver.findElement(By.id("wfEstimateProductTypeDropDownList"))
				.sendKeys("Smith Marketing Product");
		logger.info("Selecting Smith Marketing Product type in the calculator");
		waitFor(3);
		driver.findElement(By.id("wfMessageEditor"))
				.sendKeys(
						"****Automation Script-Adding comments for simple wide format****");
		driver.findElement(By.xpath("//*[@id='wfItemProcessButton']//span"))
				.click();
		logger.info("Save button clicked:");
		driver.findElement(By.xpath("//*[@id='wfItemSubmitButton']//span"))
				.click();
		logger.info("Submit button clicked");
		driver.switchTo().defaultContent();
		waitFor(5);
		logger.info("Simple Wide format calculator successfully added");
		/*driver.findElement(saveBtn).click();
		logger.info("User clicked on the save button of the Estimate Page#:");
		waitFor(5);*/
	}

	/*
	 * This method will add advance wide format calc type service into wide
	 * format dept
	 */
	public void awf() throws Exception {
		// waitFor(5);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		/*wideFormatText = driver.findElement(wideFormatDept).getText();
		driver.findElement(wideFormatDept).click();
		logger.info("Selecting.." + wideFormatText + " "
				+ "Department and entering line item to it");
		waitFor(5);*/
		
		/* ********This will add simple wide format service to wide format */
		driver.findElement(awfServiceField).click();
		waitFor(8);
		driver.findElement(awfServiceField).sendKeys(
				repo.getProperty("awflaunchserv"));
		driver.findElement(awfServiceField).sendKeys(Keys.TAB);
		waitFor(8);
		/*
		 * ********Launch Advance Wide Format calculator/adding product to it
		 * and click on Save
		 */
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(genericCalc));
		calcLabel = driver.findElement(By.xpath("//label[@id='ASPxLabel72']"))
				.getText();
		logger.info("The " + calcLabel.toString() + " page opened");
		driver.findElement(By.id("wfEstimateProductTypeDropDownList"))
				.sendKeys("3'x5' Banner");
		logger.info("Selecting 3'x5' Banner Product type in the calculator");
		waitFor(3);
		driver.findElement(By.id("wfMessageEditor"))
				.sendKeys(
						"****Automation Script-Adding comments for advance wide format****");
		driver.findElement(By.xpath("//*[@id='wfItemProcessButton']//span"))
				.click();
		logger.info("Save button clicked:");
		driver.findElement(By.xpath("//*[@id='wfItemSubmitButton']//span"))
				.click();
		logger.info("Submit button clicked");
		driver.switchTo().defaultContent();
		waitFor(5);
		logger.info("Advance Wide format calculator successfully added");
		driver.findElement(saveclose).click();

		waitFor(3);

		logger.info("Save and Close Button on the estimate page clicked");
		waitFor(5);
		wait.until(ExpectedConditions.presenceOfElementLocated(estimateSearch));
		text_name = driver.findElement(estimateSearch).getText();

		logger.info("User is on the.." + text_name.toString());
		waitFor(3);
		text_name = driver.findElement(estimatenumber).getText();

		logger.info("New estimate Id.." + text_name.toString());
		/*estnum = "# " + text_name;
		try {
			if (estnum.matches(estimate_Id)) {
				logger.info("The New Estimate#--" + estnum
						+ "is created successfully");
			}
		} catch (Exception e) {
			logger.info("The Estimate# was not created");
		}*/
	}

	/* This method will test the contract template */
	public void contractTemplate() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		estimate_search = driver.findElement(estimateSearch).getText();
		logger.info("The User is on the: " + estimate_search.toString()
				+ " page");
		driver.findElement(newEstimateBtn).click();
		logger.info("The User has clicked on the New Estimate Button:");
		estimate_Id = driver.findElement(esitmateId).getText();
		logger.info("The New Estimate ID is..." + estimate_Id.toString());
		waitFor(5);
		driver.findElement(customerName).sendKeys(
				repo.getProperty("cust_name2"));
		logger.info("Customer Name Entered");
		waitFor(5);
		driver.findElement(customerName).sendKeys(Keys.ENTER);
		waitFor(10);
		wait.until(ExpectedConditions.presenceOfElementLocated(accountWarning));
		accountWarningMsg = driver.findElement(accountWarning).getText();
		logger.info("The Name of the Pop up is---" + accountWarningMsg);
		try {
			if (accountWarningMsg.matches("Account Warning Message:")) {
				driver.findElement(acctwarningOkBtn).click();
			}
		} catch (Exception e) {

			logger.info("Account Warning Message Pop up Not Found:");
		}

		// *****This will add a contact in the contact drop down..****
		driver.findElement(contact).sendKeys(Keys.CONTROL + "a");
		driver.findElement(contact).sendKeys(repo.getProperty("contact_name2"));
		logger.info("Contact Name Entered");
		waitFor(5);
		driver.findElement(contact).sendKeys(Keys.TAB);
		// *****This will add a sales rep in the sales rep drop down...****
		driver.findElement(salesrep).sendKeys(
				repo.getProperty("sales_contact2"));
		logger.info("Sales Rep Entered");
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);
		// ******This will add a csr in the csr drop down...******
		driver.findElement(csr).sendKeys(repo.getProperty("csr2"));
		logger.info("CSR Entered");
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		driver.findElement(projfield).sendKeys(repo.getProperty("projecttxt2"));
		logger.info("Project Name Entered");

		// ****This will click on contract pricing link to open up template
		// popup***
		contractTemplate = driver.findElement(contractTemplateLink).getText();
		logger.info("Now clicking on the link: " + contractTemplate);

		driver.findElement(contractTemplateLink).click();
		waitFor(5);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(contractTemplatePage));
		try {
			projectNameContractTemplateTxt = driver.findElement(
					By.xpath("//*[@id='projectSearchGridView_tccell1_2']"))
					.getText();
			driver.findElement(projectName_ContractTemplate).click();

			logger.info("Project Name: " + projectNameContractTemplateTxt
					+ " is selected");
			waitFor(5);
			driver.findElement(By.xpath("//*[@id='ProjectSubmitImageButton']"))
					.click();
		} catch (Exception ex) {

			logger.info("Template Not available");
		}
		driver.switchTo().defaultContent();
		waitFor(10);
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {
			logger.info("Currently under " + menuItem + " tab");

			// ********This will add a expected qty of 1500********
			driver.findElement(expectedQty).sendKeys(
					repo.getProperty("expqty2"));

			// ********This will select Fulfillment department and click on
			// it**********
			fullFillmentDeptTxt = driver.findElement(fullFillmentDept)
					.getText();
			logger.info("Selecting.." + fullFillmentDeptTxt + " "
					+ "Department and entering line item to it");
			driver.findElement(fullFillmentDept).click();
			waitFor(5);

			// ********This will add Fold service(contract pricing) to
			// Fulfillment department*******
			driver.findElement(servicesTextField).click();
			waitFor(8);
			driver.findElement(servicesTextField).sendKeys(
					repo.getProperty("servicename2"));
			driver.findElement(servicesTextField).sendKeys(Keys.TAB);
			waitFor(5);
			wait.until(ExpectedConditions
					.frameToBeAvailableAndSwitchToIt(wizardScreen));
			text_name1 = driver.findElement(wizardDescLabel).getText();
			logger.info("The " + text_name1.toString() + " page opened");

			driver.findElement(
					By.xpath("//td[@id='serviceWizardGridView_cell0_0_wizardTextButton_B']//span"))
					.click();
			waitFor(5);
			driver.findElement(
					By.xpath("//td[@id='serviceWizardGridView_cell0_0_wizardTextButton_B']//span"))
					.click();
			driver.switchTo().defaultContent();
			waitFor(5);
			driver.findElement(saveclose).click();
			waitFor(5);
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(estimateSearch));
		text_name = driver.findElement(estimateSearch).getText();

		logger.info("User is on the.." + text_name.toString());
		waitFor(3);
		text_name = driver.findElement(estimatenumber).getText();

		logger.info("New estimate Id.." + text_name.toString());
		estnum = "# " + text_name;
		try {
			if (estnum.matches(estimate_Id)) {

				logger.info("The New Estimate#--" + estnum
						+ "is created successfully");
			}
		} catch (Exception e) {

			logger.info("The Estimate# was not created");
		}
	}

	/* This method will test the export to order case */
	public void exportToOrder() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(estimateSearch));
		waitFor(3);
		text_name = driver.findElement(estimatenumber).getText();
		logger.info("User has clicked on the estimate Id "
				+ text_name.toString() + " to open an existing estimate..");
		driver.findElement(estimatenumber).click();
		waitFor(5);
		totalAndTax1 = driver.findElement(TotalAndTax).getText()
				.replace("$", "");
		logger.info("The Total & Tax of the original estimate#" + text_name
				+ " is $: " + totalAndTax1);
		try {
			driver.findElement(exportOrderBtn).click();
			waitFor(10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//*[@id='ctl00_mainContentPlaceHolder_pnlOrderCopied']")));
			waitFor(10);
			orderexportedMessage = driver.findElement(orderexported).getText();
			logger.info(orderexportedMessage);
			driver.findElement(
					By.xpath("//input[@id='ctl00_mainContentPlaceHolder_btEstimateCopied']"))
					.click();
			waitFor(10);
			exportedOrderNum = driver.findElement(ORDERId).getText()
					.replace("#", "");
			logger.info("The Exported Order# is: "
					+ exportedOrderNum.toString());
			totalAndTax2 = driver.findElement(TotalAndTax).getText()
					.replace("$", "");
			logger.info("The Total & Tax of the Exported Order# is:"
					+ exportedOrderNum + " is $: " + totalAndTax2);
			if (totalAndTax1.matches(totalAndTax2)) {
				logger.info("The Total & Tax are correct in the Exported Order# "
						+ exportedOrderNum);
			} else {
				logger.info("The Total & Tax are incorrect in the Exported Order# "
						+ exportedOrderNum);
			}
		} catch (Exception e) {
			logger.info("The Estimate# " + text_name + " could not be exported");
		}
		driver.findElement(saveclose).click();
		logger.info("Save and Close Button on the order page clicked");
		waitFor(5);
		driver.findElement(estimatelabel).click();
		logger.info("User has clicked on the Estimate tab to navigate back to the estimate search page");
		waitFor(5);
	}

	/* This method will test the copy functionality of an estimate */
	public void copyEstimate() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(estimateSearch));
		waitFor(5);
		text_name = driver.findElement(estimatenumber).getText();
		logger.info("User has clicked on the estimate Id "
				+ text_name.toString() + " to open an existing estimate..");
		driver.findElement(estimatenumber).click();
		waitFor(5);
		totalAndTax1 = driver.findElement(TotalAndTax).getText()
				.replace("$", "");
		logger.info("The Total & Tax of the original estimate#" + text_name
				+ " is $: " + totalAndTax1);
		try {
			driver.findElement(estimateCopyBtn).click();
			waitFor(8);
			driver.findElement(BtnCopyOK).click();
			waitFor(8);
			logger.info("The Estimate# " + text_name
					+ " was copied successfully");
			wait.until(ExpectedConditions
					.presenceOfElementLocated(accountWarning));
			accountWarningMsg = driver.findElement(accountWarning).getText();
			logger.info("The Name of the Pop up is---" + accountWarningMsg);
			try {
				if (accountWarningMsg.matches("Account Warning Message:")) {
					driver.findElement(acctwarningOkBtn).click();
				}
			} catch (Exception e) {
				logger.info("Account Warning Message Pop up Not Found:");
			}
			copyEstimateNum = driver.findElement(esitmateId).getText()
					.replace("#", "");
			logger.info("The new copied estimate#: "
					+ copyEstimateNum.toString());
			totalAndTax2 = driver.findElement(TotalAndTax).getText()
					.replace("$", "");
			logger.info("The Total & Tax of the copied estimate#"
					+ copyEstimateNum + " is $: " + totalAndTax2);
			if (totalAndTax1.matches(totalAndTax2)) {
				logger.info("The Total & Tax are correct in the copied estimate#:"
						+ copyEstimateNum);
			} else {
				logger.info("The Total & Tax are incorrect in the copied estimate#:"
						+ copyEstimateNum);
			}

		} catch (Exception e) {
			logger.info("The Estimate# " + text_name + " could not be copied");
		}
	}

	/* This method will add attachment in the attachment tab */
	public void addattachments() throws Exception {
		attachmentTabMsg = driver.findElement(attachmentTab).getText()
				.toString();
		logger.info("The user has clicked on the " + attachmentTabMsg);
		driver.findElement(attachmentTab).click();
		waitFor(8);
		driver.findElement(documentType1).click();
		driver.findElement(documentType1).sendKeys("Logo");
		driver.findElement(documentType1).sendKeys(Keys.TAB);
		driver.findElement(fileNameField1).sendKeys("Logo_Index");
		driver.findElement(fileNameField1).sendKeys(Keys.TAB);
		waitFor(5);
		driver.findElement(uploadFileBtn).click();
		waitFor(5);
		// ***Runtime.getRuntime().exec is used for running executable files
		// from selenium.
		Runtime.getRuntime().exec(projectPath);
		waitFor(5);
		driver.findElement(saveDisketteBtn).click();
		waitFor(7);
		logger.info("The attachment was successfully added");
		driver.findElement(saveBtn).click();
		logger.info("Saved button clicked");
		waitFor(5);
	}

	/* This method will delete estimate */
	public void deleteEstimate() throws Exception {
		try {
			estimate_Id = driver.findElement(esitmateId).getText();
			driver.findElement(deleteBtn).click();
			waitFor(3);
			alert_dismiss();
			waitFor(3);
			driver.findElement(deleteBtn).click();
			waitFor(3);
			alert_accept();
			waitFor(5);
			logger.info("The Estimate#" + estimate_Id
					+ " was deleted successfully");
		} catch (Exception ex) {
			logger.info("The Estimate# " + estimate_Id
					+ " could not be deleted");
		}
	}

	/* Adding Multiple Qty in the MQ tab */
	public void multipleQty() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		estimate_search = driver.findElement(estimateSearch).getText();
		logger.info("The User is on the: " + estimate_search.toString()
				+ " page");
		driver.findElement(newEstimateBtn).click();
		logger.info("The User has clicked on the New Estimate Button:");
		estimate_Id = driver.findElement(esitmateId).getText();
		logger.info("The New Estimate ID is..." + estimate_Id.toString());
		waitFor(5);
		driver.findElement(customerName).sendKeys(
				repo.getProperty("cust_name3"));
		logger.info("Customer Name Entered");
		waitFor(5);
		driver.findElement(customerName).sendKeys(Keys.ENTER);
		waitFor(10);;
		wait.until(ExpectedConditions.presenceOfElementLocated(accountWarning));
		accountWarningMsg = driver.findElement(accountWarning).getText();
		logger.info("The Name of the Pop up is---" + accountWarningMsg);
		try {
			if (accountWarningMsg.matches("Account Warning Message:")) {
				driver.findElement(acctwarningOkBtn).click();
			}
		} catch (Exception e) {

			logger.info("Account Warning Message Pop up Not Found:");
		}
		// *****This will add a contact in the contact drop down..****
		driver.findElement(contact).sendKeys(Keys.CONTROL + "a");
		driver.findElement(contact).sendKeys(repo.getProperty("contact_name3"));
		logger.info("Contact Name Entered");
		driver.findElement(contact).sendKeys(Keys.TAB);
		// *****This will add a sales rep in the sales rep drop down...****
		driver.findElement(salesrep).sendKeys(
				repo.getProperty("sales_contact3"));
		logger.info("Sales Rep Entered");
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);
		// ******This will add a csr in the csr drop down...******
		driver.findElement(csr).sendKeys(repo.getProperty("csr3"));
		logger.info("CSR Entered");
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);
		// ******This will add project name in the project text field******
		driver.findElement(projfield).sendKeys(repo.getProperty("projecttxt3"));
		logger.info("Project Name Entered");
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {
			logger.info("Currently under " + menuItem + " tab");
			// ********This will add a expected qty of 1000 and clicks on save
			// and submit to close the estimate page********
			driver.findElement(expectedQty).sendKeys(
					repo.getProperty("expqty3"));
			logger.info("Expected Qty Entered");
		}
		dataDept = driver.findElement(dataTab).getText();
		logger.info("Selecting.." + dataDept + " "
				+ "Department and entering line item to it");
		driver.findElement(dataTab).click();

		// ********This will add line item to data department*******

		driver.findElement(servicesTextField).click();
		waitFor(8);
		driver.findElement(servicesTextField).sendKeys(
				repo.getProperty("servicename3"));
		driver.findElement(servicesTextField).sendKeys(Keys.TAB);
		waitFor(10);;
		logger.info("Service is Added In The Data Department");

		/* This will click on the MQ tab****** */
		driver.findElement(
				By.xpath("//img[@id='ctl00_mainContentPlaceHolder_btnScrollRight_BImg']"))
				.click();
		waitFor(3);
		driver.findElement(mq).click();
		waitFor(8);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantityTwoTextBox_I']"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantityTwoTextBox_I']"))
				.sendKeys(repo.getProperty("Qty1"));
		waitFor(5);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantityThreeTextBox_I']"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantityThreeTextBox_I']"))
				.sendKeys(repo.getProperty("Qty2"));
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantityFourTextBox_I']"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantityFourTextBox_I']"))
				.sendKeys(repo.getProperty("Qty3"));
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantityFiveTextBox_I']"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantityFiveTextBox_I']"))
				.sendKeys(repo.getProperty("Qty4"));
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantitySixTextBox_I']"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_pnlCallBackMQ_multipleQuantitySixTextBox_I']"))
				.sendKeys(repo.getProperty("Qty5"));
		driver.findElement(mqUpdateQtyBtn).click();
		waitFor(5);
		logger.info("Multiple Qty Created");
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

		// ********This will add print calculator service to print department
		// department*******
		driver.findElement(wideFormatServiceField).click();
		waitFor(8);
		driver.findElement(wideFormatServiceField).sendKeys("_Flyer Print");
		driver.findElement(wideFormatServiceField).sendKeys(Keys.TAB);
		waitFor(5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.cssSelector("#ctl00_mainContentPlaceHolder_iframePrintCalculator")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
				.cssSelector("#aspxCallPnlMain_iframePrintCalc")));

		// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MainaspxCallPnlMain_iframePrintCalcPrintPnl_PECancelButton']")));
		waitFor(10);;
		/*driver.findElement(By.xpath("//*[@id='MainPrintPnl_ASPxLabel3']"))
				.getText();
		System.out.println(driver.findElement(
				By.xpath("//*[@id='MainPrintPnl_ASPxLabel3']")).getText());
		// driver.findElement(By.cssSelector("#MainPrintPnl_PECancelButton")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//img[@id='MainPrintPnl_ASPxImage5']")));
		image = driver.findElement(
				By.xpath("//img[@id='MainPrintPnl_ASPxImage5']")).isDisplayed();

		if (image == false)
			logger.info("The Print Calculator does not exits");
		else
			logger.info("The Print Calculator exits");
		
		 * template_grp = driver.findElement(
		 * By.xpath("//*[@id='MainPrintPnl_ddlServiceGroup']//input"
		 * )).getText();
		 */
		
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
		waitFor(5);
		driver.findElement(templateNameDropDown).sendKeys(Keys.TAB);
		waitFor(5);
		desc_text = driver.findElement(description).getAttribute("value");
		logger.info("The Description is:-- " + desc_text.toString());
		driver.findElement(pcSave).click();
		waitFor(5);
		driver.findElement(pcSubmit).click();
		waitFor(3);
		driver.switchTo().defaultContent();
		System.out.println("====================");
		waitFor(5);
		driver.findElement(saveBtn).click();
	}

}
