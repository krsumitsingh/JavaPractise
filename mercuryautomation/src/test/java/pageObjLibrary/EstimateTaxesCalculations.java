package pageObjLibrary;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pkgTestBase.TestBase;

public class EstimateTaxesCalculations extends TestBase {

	protected WebDriver driver;

	// genericFunctionsEstimates GFE = new genericFunctionsEstimates(driver);

	public static final Logger logger = Logger
			.getLogger(EstimateTaxesCalculations.class.getName());

	/*
	 * Variables
	 * DEFINED++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++
	 */

	String estimate_label = "", estimate_search = "", estimate_Id = "",
			menuItem = "", estnum = "", estimate_search1 = "";
	String text_name = "";
	String accountWarningMsg = "";
	String text_name1 = "";
	String dataDept = "";
	String extpricetotal = "";
	String totalandtax = "";
	String detailLinkText = "";
	String text_name2 = "";
	String ExtPrice = "";
	String ExtPrice_TC03 = "", ExtPrice_TC05 = "", ExtPrice_TC04 = "",
			ExtPrice_TC07 = "";
	double ExtPrice3, ExtPrice5;
	double ExtPrice1;
	String TaxPercentage1 = "", TaxPercentage04 = "", TaxPercentage07 = "",
			taxTotal_ServiceInfoPage04 = "", taxTotal_ServiceInfoPage07 = "";
	String TaxPercentage2 = "";
	Double Amt1;
	Double Amt2;
	Double TaxTotal, TotalandTax_04, ExtPrice4, ExtPrice7, taxAndServiceTotal,
	TotalandTax_07;
	Double TaxTotal_TC03;
	Double LineItemTotal_TC02;
	Double LineItemTotal_TC03, LineItemTotal_TC05;
	Double DeptsLineItemTotal_TC03, DeptsLineItemTotal;
	Double TaxTotaloFDepts_TC03, TaxTotaloFDepts;
	Double TotalEPoFDepts_TC03, TotalEPoFDepts, TaxPercentagenew_04,
	TaxPercentagenew_07, taxTotal_ServiceInfoPage_04, LineItemTotal04,
	taxTotal_ServiceInfoPage_07, LineItemTotal07;
	String totalAndTax1 = "";
	String totalAndTax2 = "";
	String orderexportedMessage = "";
	String exportedOrderNum = "";
	String copyEstimateNum = "";
	String attachmentTabMsg = "";
	String docTypeTxt = "";
	String template_grp = "";
	String template_name = "";
	String desc_text = "";
	double tax_svcs_total;
	String designDeptTab = "", taxAmount_TC03 = "", mailingDeptTab,
			taxAmount_TC05, TotalAndTax04, TotalAndTax07;
	double taxAmount1_TC03, TaxPercentagenew1, TaxPercentagenew2,
	taxAmount1_TC05;

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
	By BtnCancel = By
			.xpath(".//*[@id='ctl00_mainContentPlaceHolder_cancelButton_CD']/span");
	By saveclose = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_submitButton']//span");
	By estimatenumber = By
			.xpath("//tr[@id='ctl00_mainContentPlaceHolder_estimateSearchGridView_DXDataRow0']/td[1]/a");
	By dataTab = By
			.xpath("//*[@class='dxmMenuItem']//*[text()='Data']");
	By servicesTextField = By
			.xpath(".//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_1_pnlGridViewServices_serviceCodeEditComboBox_I']");
	By servicesTextField1 = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell1_1_pnlGridViewServices_serviceCodeEditComboBox_I']");
	By ExtPriceTotal = By
			.xpath("*//label[@id='ctl00_mainContentPlaceHolder_priceTotalTextBoxLabel']");
	By TotalAndTax = By
			.xpath("*//label[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_serviceTotalDueLabel']");
	By detailLinks = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_6_estimateDetailButton']//span");
	By detailLinks1 = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell1_6_estimateDetailButton']//span");
	By serviceInfoPage = By.cssSelector("#ctl00_iframeCommonPopup");
	By servicePageLabel = By.xpath("//label[@id='serviceHeaderLabel']");
	By wizardService = By
			.xpath(".//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_1_pnlGridViewServices_serviceCodeEditComboBox_I']");
	By wizardScreen = By
			.cssSelector("#ctl00_mainContentPlaceHolder_iframeServiceWizard");
	By wizardDescLabel = By
			.xpath("//label[@id='serviceWizardDescriptionTextLabel']");
	By designDept = By.xpath("//*[@class='dxmMenuItem']//*[text()='Design']");

	By exportOrderBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_EstToOrderButton_CD']/span");
	By orderexported = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_CopiedMsgLabel']");
	By ORDERId = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_titleLabel']");
	By estimateCopyBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_copyButton']//span");
	By taxAmount = By.xpath("//*[@id='taxGridView_tccell0_2']/label");
	By taxJuris = By.xpath("//*[@class='dxeBase taxableCheckBox']");
	By mailingTab = By
			.xpath("//*[@class='dxmMenuItem']//*[text()='Mailing']");
	By printTab = By
			.xpath("//*[@class='dxmMenuItem']//*[text()='Print']");
	By taxJurisdiction = By.xpath("//*[@class='dxeBase taxableCheckBox']");
	By taxTotal_ServiceInfoPage = By.xpath(".//*[@id='taxTotalTextBoxLabel']");
	By taxJursidictionArea = By
			.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_cbTaxJurisdiction_I']");
	By runRate = By.xpath(".//*[@id='runRateTextBox_I']");
	By taxCheckBox_ServiceInfoPage = By.xpath(".//*[@id='taxableCheckBox_I']");
	By ServiceInfoPageSaveandClose = By
			.xpath(".//*[@id='submitButton_CD']/span");

	/*
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++
	 */

	public EstimateTaxesCalculations(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will call add_wizard() and add a new taxable wizard type
	 * service
	 */
	public void addWizardService() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 20);
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
		text_name = repo.getProperty("cust_name");
		driver.findElement(customerName)
		.sendKeys(repo.getProperty("cust_name"));
		logger.info("Customer Name Entered is: " + text_name);
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
		text_name = repo.getProperty("contact_name");
		driver.findElement(contact).sendKeys(repo.getProperty("contact_name"));
		logger.info("Contact Name Entered is: " + text_name);
		driver.findElement(contact).sendKeys(Keys.TAB);

		// *****This will add a sales rep in the sales rep drop down...****
		text_name = repo.getProperty("sales_contact");
		driver.findElement(salesrep)
		.sendKeys(repo.getProperty("sales_contact"));
		logger.info("Sales Rep Entered: " + text_name);
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);

		// ******This will add a csr in the csr drop down...******
		text_name = repo.getProperty("csr");
		driver.findElement(csr).sendKeys(repo.getProperty("csr"));
		logger.info("CSR Entered is: " + text_name);
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		text_name = repo.getProperty("projecttxt_taxes");
		driver.findElement(projfield).sendKeys(
				repo.getProperty("projecttxt_taxes"));
		logger.info("Project Name Entered: " + text_name);
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {

			logger.info("Currently under " + menuItem + " tab");

			// ********This will add a expected qty of 1000 and clicks on save
			// and submit to close the estimate page********
			text_name = repo.getProperty("expqty");
			driver.findElement(expectedQty)
			.sendKeys(repo.getProperty("expqty"));
			logger.info("Expected Qty Entered is: " + text_name);
			
			waitFor(5);
			// This will select Data department and click on it
			dataDept = driver.findElement(dataTab).getText();

			logger.info("Selecting.." + dataDept + " "
					+ "Department and entering line item to it");
			driver.findElement(dataTab).click();
			waitFor(8);
		}
		driver.findElement(wizardService).click();
		waitFor(8);
		driver.findElement(wizardService).sendKeys(
				repo.getProperty("wizservicename"));
		text_name = repo.getProperty("wizservicename");
		logger.info("Wizard Type Service selected is: " + text_name);
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
		text_name = repo.getProperty("wizservicename");
		logger.info("Wizard Type Service Added is: " + text_name);
		driver.findElement(saveBtn).click();
		waitFor(8);
		logger.info("Save Button is clicked on the estimate page" + estimate_Id);

	}

	/*
	 * This method will calculate tax of taxable wizard service and taxable
	 * customer
	 */
	public void TC02_taxable_wizard_customer() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
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
		ExtPrice1 = Double.parseDouble(ExtPrice);
		logger.info("Ext. Price on Detail popup :" + ExtPrice1);
		TaxPercentage1 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell0_1_taxPercentLabel']"))
						.getText().replace("%", "");
		TaxPercentagenew1 = Double.parseDouble(TaxPercentage1);
		logger.info("Tax % on first row Detail popup :" + TaxPercentagenew1);
		Amt1 = (ExtPrice1 * TaxPercentagenew1) / 100;
		TaxPercentage2 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell1_1_taxPercentLabel']"))
						.getText().replace("%", "");
		TaxPercentagenew2 = Double.parseDouble(TaxPercentage2);
		logger.info("Tax % on second row Detail popup :" + TaxPercentagenew2);
		Amt2 = (ExtPrice1 * TaxPercentagenew2) / 100;
		TaxTotal = Amt1 + Amt2;
		TaxTotal = Double.parseDouble(new DecimalFormat("0.00")
		.format(TaxTotal));
		logger.info("Tax Total amount on detail pop up :" + TaxTotal);
		LineItemTotal_TC02 = ExtPrice1 + TaxTotal;
		logger.info("Line Item Total amount on detail pop up :"
				+ LineItemTotal_TC02);
		tax_svcs_total = Double.parseDouble(repo.getProperty("TaxTotal_TC02"));
		if (LineItemTotal_TC02.equals(tax_svcs_total)) {
			logger.info("Tax calculation is correct:");
			logger.info("The Extended Price is:" + "" + ExtPrice + ","
					+ "The Tax Total is:" + "" + TaxTotal + ","
					+ "Line Item Total with Taxes is:" + ""
					+ LineItemTotal_TC02);
		} else {

			logger.info("Tax calculation is incorrect:");
			logger.info("The Extended Price is:" + "" + ExtPrice + ","
					+ "The Tax Total is:" + "" + TaxTotal + ","
					+ "Line Item Total with Taxes is:" + ""
					+ LineItemTotal_TC02);
		}
		driver.findElement(By.xpath("//table[@id='cancelButton']//span"))
		.click();
		logger.info("Service Information Page is closed:");
		driver.switchTo().defaultContent();
		waitFor(5);
	}

	/*
	 * This TC03 will calculate tax of on taxable no action service and taxable
	 * customer
	 */
	public void TC03_noAction_Tax_Customer() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		designDeptTab = driver.findElement(designDept).getText();
		logger.info("Selecting.." + designDeptTab + " "
				+ "Department and entering line item to it");
		driver.findElement(designDept).click();
		waitFor(8);
		driver.findElement(wizardService).click();
		waitFor(8);
		driver.findElement(wizardService).sendKeys(
				repo.getProperty("noactionservice"));
		text_name = repo.getProperty("noactionservice");
		logger.info("No Action Service selected is: " + text_name);
		driver.findElement(wizardService).sendKeys(Keys.TAB);
		waitFor(5);
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
		ExtPrice_TC03 = driver
				.findElement(By.xpath("*//label[@id='subTotalTextBoxLabel']"))
				.getText().replace("$", "");
		ExtPrice3 = Double.parseDouble(ExtPrice_TC03);
		logger.info("Ext. Price on Detail popup :" + ExtPrice3);
		TaxPercentage1 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell0_1_taxPercentLabel']"))
						.getText().replace("%", "");
		TaxPercentagenew1 = Double.parseDouble(TaxPercentage1);
		logger.info("Tax % on first row Detail popup :" + TaxPercentagenew1);

		taxAmount_TC03 = driver.findElement(taxAmount).getText()
				.replace("$", "");
		taxAmount1_TC03 = Double.parseDouble(taxAmount_TC03);
		logger.info("Tax Amount on first row of the Tax Grid:"
				+ taxAmount1_TC03);

		LineItemTotal_TC03 = ExtPrice3 + taxAmount1_TC03;
		logger.info("Line Item Total amount on detail pop up :"
				+ LineItemTotal_TC03);
		DeptsLineItemTotal_TC03 = LineItemTotal_TC02 + LineItemTotal_TC03;
		TotalEPoFDepts_TC03 = ExtPrice1 + ExtPrice3;
		TaxTotaloFDepts_TC03 = TaxTotal + taxAmount1_TC03;
		logger.info("The Total Line Item of " + dataDept + " and "
				+ designDeptTab + " is:" + DeptsLineItemTotal_TC03);
		tax_svcs_total = Double.parseDouble(repo
				.getProperty("TotalOfSvcsAndTax_TC03"));
		if (DeptsLineItemTotal_TC03.equals(tax_svcs_total)) {
			logger.info("Tax calculation is correct:");
			logger.info("The Total Extended Price of " + dataDept + "and "
					+ designDeptTab + " is:" + TotalEPoFDepts_TC03 + ","
					+ " The Tax Total is:" + "" + TaxTotaloFDepts_TC03 + ","
					+ "Line Item Total with Taxes is:" + ""
					+ DeptsLineItemTotal_TC03);
		} else {

			logger.info("Tax calculation is incorrect:");
			logger.info("The Total Extended Price of " + dataDept + " and "
					+ designDeptTab + " is:" + TotalEPoFDepts_TC03 + ","
					+ " The Tax Total is:" + "" + TaxTotaloFDepts_TC03 + ","
					+ "Line Item Total with Taxes is:" + ""
					+ DeptsLineItemTotal_TC03);
		}
		driver.findElement(By.xpath("//table[@id='cancelButton']//span"))
		.click();
		logger.info("Service Information Page is closed:");
		driver.switchTo().defaultContent();
		waitFor(5);
		driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page" + estimate_Id);
		waitFor(5);

	}

	/*
	 * This TC05 will calculate total and tax of all the depts when tax
	 * jurisdiction is unchecked making the customer non taxable and new (non
	 * taxable) no action service is added in the mailing tab
	 */
	public void TC05_noAction_Customer_nontaxable() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_termsDropDownList_I']"))
				.click();
		waitFor(3);

		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_termsDropDownList_I']"))
				.sendKeys(Keys.TAB);

		waitFor(3);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_taxableCustomerCheckBox_I']"))
				.sendKeys(Keys.SPACE);
		// unCheck_TaxJurisdiction();//This method will uncheck the tax
		// jurisdiction checkbox
		
		waitFor(5);
		mailingDeptTab = driver.findElement(mailingTab).getText();
		logger.info("Selecting.." + mailingDeptTab + " "
				+ "Department and entering line item to it");
		driver.findElement(mailingTab).click();
		waitFor(8);
		driver.findElement(wizardService).click();
		waitFor(8);
		driver.findElement(wizardService).sendKeys(
				repo.getProperty("noaction_mailing"));
		text_name = repo.getProperty("noaction_mailing");
		logger.info("No Action Service selected is: " + text_name);
		driver.findElement(wizardService).sendKeys(Keys.TAB);
		waitFor(5);
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
		ExtPrice_TC05 = driver
				.findElement(By.xpath("*//label[@id='subTotalTextBoxLabel']"))
				.getText().replace("$", "");
		ExtPrice5 = Double.parseDouble(ExtPrice_TC05);
		logger.info("Ext. Price on Detail popup :" + ExtPrice5);
		TaxPercentage1 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell0_1_taxPercentLabel']"))
						.getText().replace("%", "");
		TaxPercentagenew1 = Double.parseDouble(TaxPercentage1);
		logger.info("Tax % on first row Detail popup :" + TaxPercentagenew1);

		taxAmount_TC05 = driver.findElement(taxAmount).getText()
				.replace("$", "");
		taxAmount1_TC05 = Double.parseDouble(taxAmount_TC05);
		logger.info("Tax Amount on first row of the Tax Grid:"
				+ taxAmount1_TC05);

		LineItemTotal_TC05 = ExtPrice5 + taxAmount1_TC05;
		logger.info("Line Item Total amount on detail pop up :"
				+ LineItemTotal_TC05);
		DeptsLineItemTotal = LineItemTotal_TC02 + LineItemTotal_TC03
				+ LineItemTotal_TC05;
		TotalEPoFDepts = ExtPrice1 + ExtPrice3 + ExtPrice5;
		TaxTotaloFDepts = TaxTotal + taxAmount1_TC03 + taxAmount1_TC05;
		logger.info("The Total Line Item of " + dataDept + " , "
				+ designDeptTab + " and " + mailingDeptTab + " is:"
				+ DeptsLineItemTotal);
		tax_svcs_total = Double.parseDouble(repo
				.getProperty("TotalOfSvcsAndTax_TC05"));
		if (DeptsLineItemTotal.equals(tax_svcs_total)) {
			logger.info("Tax calculation is correct:");
			logger.info("The Total Extended Price of " + dataDept + " , "
					+ designDeptTab + " and " + mailingDeptTab + " is:"
					+ TotalEPoFDepts + "," + " The Tax Total is:" + ""
					+ TaxTotaloFDepts + ","
					+ "Line Item Total without taxes is:" + ""
					+ DeptsLineItemTotal);
		} else {

			logger.info("Tax calculation is incorrect:");
			logger.info("The Total Extended Price of " + dataDept + " , "
					+ designDeptTab + " and " + mailingDeptTab + " is:"
					+ TotalEPoFDepts + "," + " The Tax Total is:" + ""
					+ TaxTotaloFDepts + ","
					+ "Line Item Total without taxes is:" + ""
					+ DeptsLineItemTotal);
		}
		driver.findElement(By.xpath("//table[@id='cancelButton']//span"))
		.click();
		logger.info("Service Information Page is closed:");
		driver.switchTo().defaultContent();
		waitFor(5);
		driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page" + estimate_Id);
		waitFor(5);

	}

	/*
	 * TC_06-Making the tax jurisdiction taxable again. Taxes will be applicable
	 * to all the services in the line items
	 */
	public void TC06_taxJusrisdictionTaxable() throws Exception {
		// driver.findElement(taxJurisdiction).click();
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_termsDropDownList_I']"))
				.click();
		waitFor(3);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_termsDropDownList_I']"))
				.sendKeys(Keys.TAB);
		waitFor(3);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_taxableCustomerCheckBox_I']"))
				.sendKeys(Keys.SPACE);
		waitFor(8);
		Double tax_svcs_total1 = Double.parseDouble(repo
				.getProperty("TotalOfSvcsAndTax_TC06"));

		String TotalAndTax06 = driver.findElement(TotalAndTax).getText()
				.replace("$", "");
		Double TotalandTax_06 = Double.parseDouble(TotalAndTax06);
		if (TotalandTax_06.equals(tax_svcs_total1)) {

			logger.info("Tax calculation is correct: $" + TotalandTax_06);

		} else {

			logger.info("Tax calculation is incorrect: $" + TotalandTax_06);

		}
		driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page" + estimate_Id);
		waitFor(8);
		driver.findElement(BtnCancel).click();
		logger.info("Cancel Button is clicked on the estimate page"
				+ estimate_Id);
	}

	/*
	 * TC_04-Both Service(no launch service) and customer are nontaxable. Taxes
	 * will not be applied in the services.
	 */
	public void TC04() throws Exception {

		// This method will create a new estimate with finishing service

		// *****A new estimate will be created*********
		WebDriverWait wait = new WebDriverWait(driver, 20);
		estimate_label = driver.findElement(estimatelabel).getText();

		logger.info("The label name is---" + estimate_label.toString());
		driver.findElement(estimatelabel).click();
		estimate_search1 = driver.findElement(estimateSearch).getText();

		logger.info("The User is on the: " + estimate_search1.toString()
				+ " page");
		driver.findElement(newEstimateBtn).click();

		logger.info("The User has clicked on the New Estimate Button:");
		waitFor(8);
		estimate_Id = driver.findElement(esitmateId).getText();

		logger.info("The New Estimate ID is..." + estimate_Id.toString());
		text_name = repo.getProperty("cust_name_TC04");
		driver.findElement(customerName).sendKeys(
				repo.getProperty("cust_name_TC04"));
		waitFor(5);
		logger.info("Customer Name Entered: " + text_name);
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
		text_name = repo.getProperty("contact_name_TC04");
		driver.findElement(contact).sendKeys(
				repo.getProperty("contact_name_TC04"));
		logger.info("Contact Name Entered: " + text_name);
		driver.findElement(contact).sendKeys(Keys.TAB);

		// *****This will add a sales rep in the sales rep drop down...****
		text_name = repo.getProperty("sales_contact_TC04");
		driver.findElement(salesrep).sendKeys(
				repo.getProperty("sales_contact_TC04"));
		logger.info("Sales Rep Entered: " + text_name);
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);

		// ******This will add a csr in the csr drop down...******
		text_name = repo.getProperty("csr_TC04");
		driver.findElement(csr).sendKeys(repo.getProperty("csr_TC04"));
		logger.info("CSR Entered: " + text_name);
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		text_name = repo.getProperty("projecttxt_TC04");
		driver.findElement(projfield).sendKeys(
				repo.getProperty("projecttxt_TC04"));
		logger.info("Project Name Entered: " + text_name);
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {

			logger.info("Currently under " + menuItem + " tab");

			// ********This will add a expected qty of 12500*******
			text_name = repo.getProperty("expqty_TC04");
			driver.findElement(expectedQty).sendKeys(
					repo.getProperty("expqty_TC04"));
			logger.info("Expected Qty Entered: " + text_name);
			// This will select Data department and click on it
			dataDept = driver.findElement(dataTab).getText();

			logger.info("Selecting.." + dataDept + " "
					+ "Department and entering line item to it");
			driver.findElement(dataTab).click();
		}

		// ********This will add line item to data department*******
		text_name = repo.getProperty("data_TC04");
		driver.findElement(servicesTextField).click();
		waitFor(8);
		driver.findElement(servicesTextField).sendKeys(
				repo.getProperty("data_TC04"));
		driver.findElement(servicesTextField).sendKeys(Keys.TAB);
		waitFor(10);
		logger.info("Service is Added In The Data Department: " + text_name);
		waitFor(5);

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

		/* Tax calculation */
		ExtPrice_TC04 = driver
				.findElement(By.xpath("*//label[@id='subTotalTextBoxLabel']"))
				.getText().replace("$", "");
		ExtPrice4 = Double.parseDouble(ExtPrice_TC04);
		
		logger.info("Ext. Price on Detail popup :" + ExtPrice4);
		TaxPercentage04 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell0_1_taxPercentLabel']"))
						.getText().replace("%", "");
		TaxPercentagenew_04 = Double.parseDouble(TaxPercentage04);
		
		logger.info("Tax % on first row Detail popup :" + TaxPercentagenew_04);
		taxTotal_ServiceInfoPage04 = driver
				.findElement(taxTotal_ServiceInfoPage).getText()
				.replace("$", "");
		taxTotal_ServiceInfoPage_04 = Double
				.parseDouble(taxTotal_ServiceInfoPage04);
		/*
		 * taxTotal_ServiceInfoPage_04 = Double.parseDouble(new DecimalFormat(
		 * "0.00").format(taxTotal_ServiceInfoPage04));
		 */
		logger.info("Tax Total Amount in the Detail popup :"
				+ taxTotal_ServiceInfoPage_04);
		LineItemTotal04 = ExtPrice4 + taxTotal_ServiceInfoPage_04;
		logger.info("Extended Price And Tax Total In Detail popup :"
				+ LineItemTotal04);

		/* Closing the service info page */
		driver.findElement(By.xpath("//table[@id='cancelButton']//span"))
		.click();
		logger.info("Service Information Page is closed:");
		driver.switchTo().defaultContent();
		waitFor(8);

		/* Total and Tax amount at the order header level */
		TotalAndTax04 = driver.findElement(TotalAndTax).getText()
				.replace("$", "");
		TotalandTax_04 = Double.parseDouble(TotalAndTax04);
		
		logger.info("Total and Tax amount at the order header level :"
				+ TotalandTax_04);

		if (LineItemTotal04.equals(TotalandTax_04)) {

			logger.info("Tax calculation is correct:");
			logger.info("The Total Extended Price is: " + ExtPrice4 + ","
					+ "The Tax% is: " + TaxPercentagenew_04 + ","
					+ "The Total Tax Amount is: " + taxTotal_ServiceInfoPage_04
					+ "," + "Total Line Item Amount Is: " + LineItemTotal04);

		} else {

			logger.info("Tax calculation is incorrect:");
			logger.info("The Total Extended Price is: " + ExtPrice4 + ","
					+ "The Tax% is: " + TaxPercentagenew_04 + ","
					+ "The Total Tax Amount is: " + taxTotal_ServiceInfoPage_04
					+ "," + "Total Line Item Amount Is: " + LineItemTotal04);

		}
		driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page" + estimate_Id);
		waitFor(8);
	}

	/*
	 * TC_07-service(nolaunch)taxable and customer is not taxable. Taxes will
	 * not be applied.
	 */
	public void TC07() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		text_name = repo.getProperty("data_TC07");
		driver.findElement(servicesTextField1).click();
		waitFor(8);
		driver.findElement(servicesTextField1).sendKeys(
				repo.getProperty("data_TC07"));
		driver.findElement(servicesTextField1).sendKeys(Keys.TAB);
		waitFor(10);
		logger.info("Service is Added In The Data Department: " + text_name);
		waitFor(5);

		// ********This will click on details link and open service information
		// page********
		driver.findElement(detailLinks1).click();
		detailLinkText = driver.findElement(detailLinks1).getText();
		logger.info("The " + detailLinkText.toString() + " link is clicked");
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(serviceInfoPage));
		text_name2 = driver.findElement(servicePageLabel).getText();
		logger.info("The " + text_name2.toString() + " page opened");
		waitFor(5);

		/* Tax calculation */
		ExtPrice_TC07 = driver
				.findElement(By.xpath("*//label[@id='subTotalTextBoxLabel']"))
				.getText().replace("$", "");
		ExtPrice7 = Double.parseDouble(ExtPrice_TC07);
		
		logger.info("Ext. Price on Detail popup :" + ExtPrice7);
		TaxPercentage07 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell0_1_taxPercentLabel']"))
						.getText().replace("%", "");
		TaxPercentagenew_07 = Double.parseDouble(TaxPercentage07);
		
		logger.info("Tax % on first row Detail popup :" + TaxPercentagenew_07);
		taxTotal_ServiceInfoPage07 = driver
				.findElement(taxTotal_ServiceInfoPage).getText()
				.replace("$", "");
		taxTotal_ServiceInfoPage_07 = Double
				.parseDouble(taxTotal_ServiceInfoPage07);
		
		logger.info("Tax Total Amount in the Detail popup :"
				+ taxTotal_ServiceInfoPage_07);
		LineItemTotal07 = ExtPrice7 + taxTotal_ServiceInfoPage_07;
		logger.info("Extended Price And Tax Total In Detail popup :"
				+ LineItemTotal07);

		/* Closing the service info page */
		driver.findElement(By.xpath("//table[@id='cancelButton']//span"))
		.click();
		logger.info("Service Information Page is closed:");
		driver.switchTo().defaultContent();
		waitFor(8);

		taxAndServiceTotal = LineItemTotal07 + LineItemTotal04;
		
		logger.info("Total and Tax amount of all the services is $"
				+ taxAndServiceTotal);

	
		if (taxAndServiceTotal.equals(Double.parseDouble(repo
				.getProperty("TotalOfSvcsAndTax_TC07")))) {

			logger.info("Tax calculation is correct:");
			logger.info("The Total Extended Price is: $"
					+ (ExtPrice7 + ExtPrice4)
					+ ","
					+ "The Tax% is: "
					+ (TaxPercentagenew_07 + TaxPercentagenew_04)
					+ ","
					+ "The Total Tax Amount is: $"
					+ (taxTotal_ServiceInfoPage_07 + taxTotal_ServiceInfoPage_04)
					+ "," + "Total Line Item Amount Is: $"
					+ (LineItemTotal07 + LineItemTotal04));

		} else {

			logger.info("Tax calculation is incorrect:");
			logger.info("The Total Extended Price is: $"
					+ (ExtPrice7 + ExtPrice4)
					+ ","
					+ "The Tax% is: "
					+ (TaxPercentagenew_07 + TaxPercentagenew_04)
					+ ","
					+ "The Total Tax Amount is: $"
					+ (taxTotal_ServiceInfoPage_07 + taxTotal_ServiceInfoPage_04)
					+ "," + "Total Line Item Amount Is: $"
					+ (LineItemTotal07 + LineItemTotal04));

		}
		driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page" + estimate_Id);
		waitFor(8);
	}

	/*
	 * TC_08-Making non-taxable customer as taxable and non-taxable service
	 * taxable from the detail link. Taxes will be applied.
	 */

	public void TC08() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_termsDropDownList_I']"))
				.click();
		waitFor(3);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_termsDropDownList_I']"))
				.sendKeys(Keys.TAB);
		waitFor(3);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_taxableCustomerCheckBox_I']"))
				.sendKeys(Keys.SPACE);
		waitFor(8);

		/* This will select the tax jusrisdiction from the drop down list */
		String taxJursidictionTxt = repo.getProperty("taxJursidiction");
		driver.findElement(taxJursidictionArea).click();
		driver.findElement(taxJursidictionArea).sendKeys(Keys.CONTROL + "a");
		waitFor(3);
		driver.findElement(taxJursidictionArea).sendKeys(
				repo.getProperty("taxJursidiction"));
		waitFor(3);
		driver.findElement(taxJursidictionArea).sendKeys(Keys.TAB);
		logger.info("Tax Jursidiction selected is: " + taxJursidictionTxt);
		
		waitFor(8);

		// ********This will click on details link of the first line item and
		// open service information
		// page********
		driver.findElement(detailLinks).click();
		detailLinkText = driver.findElement(detailLinks).getText();
		logger.info("The " + detailLinkText.toString() + " link is clicked");
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(serviceInfoPage));
		text_name2 = driver.findElement(servicePageLabel).getText();
		logger.info("The " + text_name2.toString() + " page opened");
		waitFor(5);
		driver.findElement(runRate).click();
		driver.findElement(runRate).sendKeys(Keys.TAB);
		driver.findElement(taxCheckBox_ServiceInfoPage).sendKeys(Keys.SPACE);
		waitFor(8);

		/* Getting values of extended price and taxes in the service info page */
		String ExtPrice_TC08 = driver
				.findElement(By.xpath("*//label[@id='subTotalTextBoxLabel']"))
				.getText().replace("$", "");
		Double ExtPrice8 = Double.parseDouble(ExtPrice_TC08);

		logger.info("Ext. Price on Detail popup :" + ExtPrice8);
		String TaxPercentage08 = driver
				.findElement(
						By.xpath("*//label[@id='taxGridView_cell0_1_taxPercentLabel']"))
						.getText().replace("%", "");
		Double TaxPercentagenew_08 = Double.parseDouble(TaxPercentage08);

		logger.info("Tax % on first row Detail popup :" + TaxPercentagenew_08);
		String taxTotal_ServiceInfoPage08 = driver
				.findElement(taxTotal_ServiceInfoPage).getText()
				.replace("$", "");
		Double taxTotal_ServiceInfoPage_08 = Double
				.parseDouble(taxTotal_ServiceInfoPage08);

		logger.info("Tax Total Amount in the Detail popup :"
				+ taxTotal_ServiceInfoPage_08);
		Double LineItemTotal08 = ExtPrice8 + taxTotal_ServiceInfoPage_08;
		logger.info("Extended Price And Tax Total In Detail popup :"
				+ LineItemTotal08);

		/* Closing the service info page */
		driver.findElement(ServiceInfoPageSaveandClose).click();
		logger.info("Service Information Page is saved and closed:");
		driver.switchTo().defaultContent();
		waitFor(8);

		Double taxAndServiceTotal08 = LineItemTotal08 + LineItemTotal07;
		logger.info("Total and Tax amount of all the services is $"
				+ taxAndServiceTotal08);

		if (taxAndServiceTotal08.equals(Double.parseDouble(repo
				.getProperty("TotalOfSvcsAndTax_TC08")))) {

			logger.info("Tax calculation is correct:");
			logger.info("The Total Extended Price is: $"
					+ (ExtPrice8 + ExtPrice7)
					+ ","
					+ "The Tax% is: "
					+ (TaxPercentagenew_07 + TaxPercentagenew_08)
					+ ","
					+ "The Total Tax Amount is: $"
					+ (taxTotal_ServiceInfoPage_07 + taxTotal_ServiceInfoPage_08)
					+ "," + "Total Line Item Amount Is: $"
					+ (LineItemTotal07 + LineItemTotal08));

		} else {

			logger.info("Tax calculation is incorrect:");
			logger.info("The Total Extended Price is: $"
					+ (ExtPrice8 + ExtPrice7)
					+ ","
					+ "The Tax% is: "
					+ (TaxPercentagenew_07 + TaxPercentagenew_08)
					+ ","
					+ "The Total Tax Amount is: $"
					+ (taxTotal_ServiceInfoPage_07 + taxTotal_ServiceInfoPage_08)
					+ "," + "Total Line Item Amount Is: $"
					+ (LineItemTotal07 + LineItemTotal08));

		}
		driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page" + estimate_Id);
		waitFor(8);
	}

	/*
	 * TC_09-customer taxable with nontaxable wizard service
	 */
	public void TC09() throws Exception {

		// GFE.addNewEstimate();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		estimate_label = driver.findElement(estimatelabel).getText();
		logger.info("The label name is---" + estimate_label.toString());
		driver.findElement(estimatelabel).click();
		estimate_search = driver.findElement(estimateSearch).getText();
		logger.info("The User is on the: " + estimate_search.toString()
				+ " page");
		driver.findElement(newEstimateBtn).click();
		logger.info("The User has clicked on the New Estimate Button:");
		waitFor(8);
		estimate_Id = driver.findElement(esitmateId).getText();
		logger.info("The New Estimate ID is..." + estimate_Id.toString());
		text_name = repo.getProperty("cust_name");
		driver.findElement(customerName)
		.sendKeys(repo.getProperty("cust_name"));
		logger.info("Customer Name Entered is: " + text_name);
		driver.findElement(customerName).sendKeys(Keys.ENTER);
		waitFor(15);
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
		text_name = repo.getProperty("contact_name");
		driver.findElement(contact).sendKeys(repo.getProperty("contact_name"));
		logger.info("Contact Name Entered is: " + text_name);
		driver.findElement(contact).sendKeys(Keys.TAB);

		// *****This will add a sales rep in the sales rep drop down...****
		text_name = repo.getProperty("sales_contact");
		driver.findElement(salesrep)
		.sendKeys(repo.getProperty("sales_contact"));
		logger.info("Sales Rep Entered: " + text_name);
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);

		// ******This will add a csr in the csr drop down...******
		text_name = repo.getProperty("csr");
		driver.findElement(csr).sendKeys(repo.getProperty("csr"));
		logger.info("CSR Entered is: " + text_name);
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		text_name = repo.getProperty("projecttxt_TC09");
		driver.findElement(projfield).sendKeys(
				repo.getProperty("projecttxt_TC09"));
		logger.info("Project Name Entered: " + text_name);

		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {

			logger.info("Currently under " + menuItem + " tab");

			// ********This will add a expected qty of 1000 and clicks on save
			// and submit to close the estimate page********
			text_name = repo.getProperty("expqty_TC09");
			driver.findElement(expectedQty).sendKeys(
					repo.getProperty("expqty_TC09"));
			logger.info("Expected Qty Entered is: " + text_name);
			
			waitFor(5);
			// This will select Data department and click on it
			String printDept = driver.findElement(printTab).getText();

			logger.info("Selecting.." + printDept + " "
					+ "Department and entering line item to it");
			driver.findElement(printTab).click();
			waitFor(8);
		}
		driver.findElement(wizardService).click();
		waitFor(8);
		driver.findElement(wizardService).sendKeys(
				repo.getProperty("wizardservice_TC09"));
		text_name = repo.getProperty("wizardservice_TC09");
		logger.info("Wizard Type Service selected is: " + text_name);
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
		text_name = repo.getProperty("wizardservice_TC09");
		logger.info("Wizard Type Service Added is: " + text_name);
		
		driver.findElement(detailLinks).click();
		detailLinkText = driver.findElement(detailLinks).getText();
		logger.info("The " + detailLinkText.toString() + " link is clicked");
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(serviceInfoPage));
		text_name2 = driver.findElement(servicePageLabel).getText();
		logger.info("The " + text_name2.toString() + " page opened");
		waitFor(5);

		/* Tax calculation */
		String ExtPrice_TC09 = driver
				.findElement(By.xpath("*//label[@id='subTotalTextBoxLabel']"))
				.getText().replace("$", "").replace(",", "");
		Double ExtPrice09 = Double.parseDouble(ExtPrice_TC09);
		
		logger.info("Ext. Price on Service Info Page popup is $" + ExtPrice09);
		String TaxTotal_09 = driver.findElement(taxTotal_ServiceInfoPage)
				.getText().replace("$", "").replace(",", "");
		;
		Double TaxTotal09 = Double.parseDouble(TaxTotal_09);
		
		logger.info("Tax Total On The Service Info Page is $" + TaxTotal09);
		

		Double LineItemTotal09 = ExtPrice09 + TaxTotal09;
		logger.info("Extended Price And Tax Total In Detail popup is $:"
				+ LineItemTotal09);

		/* Closing the service info page */
		driver.findElement(By.xpath("//table[@id='cancelButton']//span"))
		.click();
		logger.info("Service Information Page is closed:");
		driver.switchTo().defaultContent();
		waitFor(8);

		if (LineItemTotal09.equals(Double.parseDouble(repo
				.getProperty("TotalOfSvcsAndTax_TC09")))) {

			logger.info("Tax calculation is correct:");
			logger.info("The Total Extended Price is $:" + ExtPrice09 + ","
					+ "The Total Tax Amount is $:" + TaxTotal09 + ","
					+ "Total Line Item Amount is $:" + LineItemTotal09);

		} else {

			logger.info("Tax calculation is incorrect:");
			logger.info("The Total Extended Price is $:" + ExtPrice09 + ","
					+ "The Total Tax Amount is $:" + TaxTotal09 + ","
					+ "Total Line Item Amount is $:" + LineItemTotal09);

		}
		driver.findElement(saveBtn).click();
		logger.info("Save Button is clicked on the estimate page" + estimate_Id);
		waitFor(8);
	}

	/*
	 * TC_10-customer non-taxable with taxable wizard service
	 */
	public void TC10() throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_termsDropDownList_I']"))
				.click();
		waitFor(3);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_termsDropDownList_I']"))
				.sendKeys(Keys.TAB);
		waitFor(3);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_taxableCustomerCheckBox_I']"))
				.sendKeys(Keys.SPACE);
		waitFor(8);
		
		
		
		
	}
	
	
	
}