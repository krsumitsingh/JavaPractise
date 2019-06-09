package pageObjLibrary;

import pkgTestBase.TestBase;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersPage extends TestBase {

	WebDriver driver;

	public static final Logger logger = Logger.getLogger(OrdersPage.class
			.getName());

	/*
	 * Variables
	 * DEFINED++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++
	 */
	LocalTime startTime;
	LocalTime endTime;
	String order_label = "";
	String order_search = "";
	String order_Id = "";
	String menuItem = "";
	String ordnum = "";
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
	String copyOrderNum = "";
	String attachmentTabMsg = "";
	String docTypeTxt = "";
	boolean image = false;
	String template_grp = "";
	String template_name = "";
	String desc_text = "", droptabdue_date = "", VerTabDueDate_txt = "";
	String due_date = "", estimate_export = "", ExportedEstimateNum = "";

	/*
	 * XPATHS/ID's/CSS
	 * DEFINED++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++++++++++++++++
	 */
	By orderlabel = By.id("ctl00_MainMenuSub_DXI1_T");
	By orderSearch = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_titleLabel']");
	By newOrderBtn = By.xpath("//*[@id='ctl00_newAddButtonDiv']//span");
	By orderId = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_titleLabel']");
	By saveBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_SaveButton_CD']//span");
	By customerName = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_customerComboBox_I']");
	By accountWarningPanel = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_pnlWarning']");
	By accountWarning = By.xpath("//td[@class='pnlCalculateBookHeader']");
	By accountWarning1 = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_MessageLabel']");
	By acctwarningOkBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_pnlWarning']//input");
	By contact = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_contactComboBox_I']");
	By salesrep = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_salesComboBoxOrder_I']");
	By csr = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_csrComboBoxOrder_I']");
	By projfield = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_projectTextBox_I']");
	By detailstab = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_OrerSubMenuPnl_orderSubMenu_DXI1_T']/span");
	By expectedQty = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_expectedQuantityTextBox_I']");
	By saveclose = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_submitButton']//span");
	By ordernumber = By
			.xpath("//tr[@id='ctl00_mainContentPlaceHolder_orderSearchGridView_DXDataRow0']/td[1]/a");
	By dataTab = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_versionSubMenu_ITTCNT4_ctl00']");
	By servicesTextField = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_1_pnlGridViewServices_serviceCodeComboBox_I']");
	By ExtPriceTotal = By
			.xpath("*//label[@id='ctl00_mainContentPlaceHolder_priceTotalTextBoxLabel']");
	By TotalAndTax = By
			.xpath("*//label[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_serviceTotalDueLabel']");
	By detailLinks = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_6_estimateDetailButton']//span");
	By serviceInfoPage = By.cssSelector("#ctl00_iframeCommonPopup");
	By servicePageLabel = By.xpath("//label[@id='serviceHeaderLabel']");
	By wizardService = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell1_1_pnlGridViewServices_serviceCodeComboBox_I']");
	By wizardScreen = By
			.cssSelector("#ctl00_mainContentPlaceHolder_iframeServiceWizard");
	By wizardDescLabel = By
			.xpath("//label[@id='serviceWizardDescriptionTextLabel']");
	By wideFormatDept = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_versionSubMenu_DXI10_T']");
	By genericCalc = By
			.cssSelector("#ctl00_mainContentPlaceHolder_iframeWideFormat");
	By wideFormatServiceField = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell0_1_pnlGridViewServices_serviceCodeComboBox_I']");
	By awfServiceField = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ASPxCallbackPanelServiceGrid_serviceGridView_cell1_1_pnlGridViewServices_serviceCodeComboBox_I']");
	By awfMaterialDropDown = By
			.xpath(".//*[@id='wideFormatStockIdDropDownList_I']");
	By contractTemplateLink = By
			.xpath("//*[@class='fontBold']//*[text()='Attach Contract Pricing']");
	By contractTemplatePage = By.cssSelector("#ctl00_iframeCommonPopup");
	By projectName_ContractTemplate = By
			.xpath("//*[@id='projectSearchGridView_cell1_0_ProjectCheckBox_I']");
	By fullFillmentDept = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_versionSubMenu_ITTCNT9_ctl00']");
	By exportOrderBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_EstToOrderButton_CD']/span");
	By orderexported = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_CopiedMsgLabel']");
	By ORDERId = By
			.xpath("//label[@id='ctl00_mainContentPlaceHolder_titleLabel']");
	By orderCopyBtn = By.xpath("//*[@class='dxb']//*[text()='Copy']");
	By BtnCopyOK = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_btOrderCopied']");
	By attachmentTab = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_OrerSubMenuPnl_orderSubMenu_DXI3_T']/span");
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
	By printTab = By.xpath("//*[@class='dxmMenuItem']//*[text()='Print']");
	By templateGrpDropDown = By
			.xpath("//*[@id='MainPrintPnl_ddlServiceGroup_I']");
	By templateNameDropDown = By
			.xpath("//*[@id='MainPrintPnl_PEProductType_I']");
	By description = By.xpath("//*[@id='MainPrintPnl_txtPEDescription_I']");
	By pcSave = By
			.xpath(".//*[@id='MainPrintPnl_PEItemProcessButton_CD']/span");
	By pcSubmit = By.xpath(".//*[@id='MainPrintPnl_PESubmitButton_CD']/span");
	By dueDate = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_dropDateDateEdit_I']");
	By versionTab = By
			.xpath("//*[@class='subMenuAsTabItems']//*[text()='Versions']");
	By versionCopy = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_DXDataRow0']/td[9]/img");
	By versionCopyPopup = By.cssSelector("#ctl00_iframeCommonPopup");
	By versionCopyText = By.xpath("//*[@id='ASPxLabel33']");
	By verCopySaveAndClose = By
			.xpath("//*[@id='CloneVersionMPESubmitButton_CD']/span");
	By verName = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_edit1_0_txtVersionNameEdit']");
	By verQty = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_edit1_1_txtVersionQuantityEdit_I']");
	By verTotalSvcsAndTax = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_cell1_2_lblVersionTotalDue']");
	By verDueDate = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_edit1_3_deDueDateEdit_I']");
	By verDueDate1 = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_edit0_3_deDueDateEdit_I']");
	By verDropShipDate = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_edit1_5_deActualDueDateEdit_I']");
	By verSaveDiskette = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_DXEditingRow']/td[8]/img[1]");
	By verEditGrid = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_DXDataRow1']/td[8]/img");
	By verEditGrid1 = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_DXDataRow0']/td[8]/img");
	By verEditGridPopUpText = By.xpath("//*[@id='lblCommonMsgPopup']");
	By verYesBtn = By.cssSelector("#btnpnlCommonMsgPopupYes_CD");
	By verQtyAdd = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_footer1_txtVersionQuantityAdd_I']");
	By verSaveDisketteAdd = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_footer7_ibVersionAdd']");
	By verSaveDisketteAdd1 = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_DXEditingRow']/td[8]/img[1]");
	By verDel = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_DXDataRow1']/td[11]/img");
	By estimateExportBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_exportEstimateButton_CD']/span");
	By estimateExportTxt = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ExportToEstimateMsgLabel']");
	By estimateExportPanel = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_pnlExportToEstimate']");
	By estimateExportOKBtn = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_ExportToEstimateButton']");
	By estimateExportId = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_titleLabel']");
	By dropsTab = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_PnlForMiscellaneousActions_versionSubMenu_ITTCNT12_ctl00']");
	By dropTabDueDate = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_dropGridView_cell0_0_dropDate_I']");
	By VerTabDueDate = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_cell0_3_deDueDate']");
	By GeneralTab = By
			.xpath("//*[@id='ctl00_mainContentPlaceHolder_HeaderASPxCallbackPanel_OrerSubMenuPnl_orderSubMenu_DXI0_T']/span");

	/*
	 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 * +++++++++++++++++++++++++++++++++++++++
	 */

	public OrdersPage() {
	}

	public OrdersPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will verify the validation displayed when new order is
	 * created without selecting the customer
	 */
	public void save_without_customer() throws Exception {
		order_label = driver.findElement(orderlabel).getText();
		logger.info("The label name is---" + order_label.toString());
		driver.findElement(orderlabel).click();
		order_search = driver.findElement(orderSearch).getText();
		logger.info("The User is on the: " + order_search.toString() + " page");
		driver.findElement(newOrderBtn).click();
		logger.info("The User has clicked on the New Order Button:");
		waitFor(5);
		order_Id = driver.findElement(orderId).getText();
		logger.info("The New Order ID is..." + order_Id.toString());
		driver.findElement(saveBtn).click();
		logger.info("Save Button on the Order# page is clicked:");
		alert_accept();
	}

	/*
	 * This method will create a new Order without adding finishing services
	 */
	public void order_without_services() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		text_name = repo.getProperty("cust_name_ord");
		driver.findElement(customerName).sendKeys(
				repo.getProperty("cust_name_ord"));
		logger.info("Customer Name Entered " + text_name);
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

		waitFor(10);
		// *****This will add a contact in the contact drop down..****
		text_name = repo.getProperty("contact_name_ord");
		driver.findElement(contact).sendKeys(Keys.CONTROL + "a");
		driver.findElement(contact).sendKeys(
				repo.getProperty("contact_name_ord"));
		logger.info("Contact Name Entered: " + text_name);
		driver.findElement(contact).sendKeys(Keys.TAB);

		// *****This will add a sales rep in the sales rep drop down...****
		text_name = repo.getProperty("sales_contact_ord");
		driver.findElement(salesrep).sendKeys(
				repo.getProperty("sales_contact_ord"));
		logger.info("Sales Rep Entered: " + text_name);
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);

		// ******This will add a csr in the csr drop down...******
		text_name = repo.getProperty("csr_ord");
		driver.findElement(csr).sendKeys(repo.getProperty("csr_ord"));
		logger.info("CSR Entered: " + text_name);
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		text_name = repo.getProperty("projecttxt_ord");
		driver.findElement(projfield).sendKeys(
				repo.getProperty("projecttxt_ord"));
		logger.info("Project Name Entered: " + text_name);
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {

			logger.info("Currently under " + menuItem + " tab");

			// ********This will add a expected qty of 1000 and clicks on save
			// and submit to close the Order page********
			text_name = repo.getProperty("expqty_ord");
			driver.findElement(expectedQty).sendKeys(
					repo.getProperty("expqty_ord"));
			logger.info("Expected Qty Entered: " + text_name);
			driver.findElement(saveclose).click();
			logger.info("Save and Close Button on the Order page clicked");
			waitFor(5);
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(orderSearch));
		text_name = driver.findElement(orderSearch).getText();

		logger.info("User is on the.." + text_name.toString());
		waitFor(3);
		text_name = driver.findElement(ordernumber).getText();

		logger.info("New Order Id.." + text_name.toString());
		ordnum = "# " + text_name;
		try {
			if (ordnum.matches(order_Id)) {

				logger.info("The New Order#--" + ordnum
						+ "is created successfully");
			}
		} catch (Exception e) {

			logger.info("The Order# was not created");
		}
	}

	/* This method will create a new Order with finishing service */
	public void order_with_services() throws Exception {
		// *****A new Order will be created*********
		WebDriverWait wait = new WebDriverWait(driver, 8);
		order_label = driver.findElement(orderlabel).getText();

		logger.info("The label name is---" + order_label.toString());
		driver.findElement(orderlabel).click();
		order_search = driver.findElement(orderSearch).getText();

		logger.info("The User is on the: " + order_search.toString() + " page");
		driver.findElement(newOrderBtn).click();

		logger.info("The User has clicked on the New Order Button:");
		waitFor(5);
		order_Id = driver.findElement(orderId).getText();

		logger.info("The New Order ID is..." + order_Id.toString());
		text_name = repo.getProperty("cust_name1_ord");
		driver.findElement(customerName).sendKeys(
				repo.getProperty("cust_name1_ord"));
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
		waitFor(5);
		// *****This will add a contact in the contact drop down..****
		text_name = repo.getProperty("contact_name1_ord");
		driver.findElement(contact).sendKeys(Keys.CONTROL + "a");
		driver.findElement(contact).sendKeys(
				repo.getProperty("contact_name1_ord"));
		logger.info("Contact Name Entered: " + text_name);
		driver.findElement(contact).sendKeys(Keys.TAB);

		// *****This will add a sales rep in the sales rep drop down...****
		text_name = repo.getProperty("sales_contact1_ord");
		driver.findElement(salesrep).sendKeys(
				repo.getProperty("sales_contact1_ord"));
		logger.info("Sales Rep Entered: " + text_name);
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);

		// ******This will add a csr in the csr drop down...******
		text_name = repo.getProperty("csr1_ord");
		driver.findElement(csr).sendKeys(repo.getProperty("csr1_ord"));
		logger.info("CSR Entered: " + text_name);
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		text_name = repo.getProperty("projecttxt1_ord");
		driver.findElement(projfield).sendKeys(
				repo.getProperty("projecttxt1_ord"));
		logger.info("Project Name Entered: " + text_name);
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {

			logger.info("Currently under " + menuItem + " tab");

			// ********This will add a expected qty of 1890 and clicks on save
			// and submit to close the Order page********
			text_name = repo.getProperty("expqty1_ord");
			driver.findElement(expectedQty).sendKeys(
					repo.getProperty("expqty1_ord"));
			logger.info("Expected Qty Entered: " + text_name);
			// This will select Data department and click on it
			dataDept = driver.findElement(dataTab).getText();

			logger.info("Selecting.." + dataDept + " "
					+ "Department and entering line item to it");
			driver.findElement(dataTab).click();

			// ********This will add line item to data department*******
			driver.findElement(servicesTextField).click();
			waitFor(8);
			text_name = repo.getProperty("servicename_ord");
			driver.findElement(servicesTextField).sendKeys(
					repo.getProperty("servicename_ord"));
			driver.findElement(servicesTextField).sendKeys(Keys.TAB);
			waitFor(10);
			logger.info("Service is Added In The Data Department: " + text_name);
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
		waitFor(5);
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
		// driver.findElement(saveBtn).click();
		// logger.info("Save Button is clicked on the order page# to save it");
		// waitFor(5);
	}

	// This method will add wizard type service
	public void add_wizard() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(wizardService).click();
		waitFor(8);
		driver.findElement(wizardService).sendKeys(
				repo.getProperty("wizservicename_ord"));
		text_name = repo.getProperty("wizservicename_ord");
		logger.info("Wizard Type Service added: " + text_name);
		driver.findElement(wizardService).sendKeys(Keys.TAB);
		waitFor(5);
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
		//logger.info("Wizard Type Service Added");
		//driver.findElement(saveBtn).click();
		//logger.info("Save Button is clicked on the order page# to save it");
		//waitFor(10);
	}

	/*
	 * This method will add simple wide format calc type service into wide
	 * format dept
	 */
	public void swf() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wideFormatText = driver.findElement(wideFormatDept).getText();
		text_name = repo.getProperty("swflaunchserv_ord");
		driver.findElement(wideFormatDept).click();
		logger.info("Selecting.." + wideFormatText + " "
				+ "Department and entering line item to it");
		waitFor(5);
		/* ********This will add simple wide format service to wide format */
		driver.findElement(wideFormatServiceField).click();
		waitFor(8);
		driver.findElement(wideFormatServiceField).sendKeys(
				repo.getProperty("swflaunchserv_ord"));
		logger.info("Wizard Type Service added: " + text_name);
		driver.findElement(wideFormatServiceField).sendKeys(Keys.TAB);
		waitFor(5);
		/*
		 * ********Launch Simple Wide Format calculator/adding product to it and
		 * click on Save
		 */
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(genericCalc));
		calcLabel = driver.findElement(By.xpath("//*[@id='ASPxLabel14']"))
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
		/*
		 * driver.findElement(saveBtn).click();
		 * logger.info("User clicked on the save button of the Order Page#:");
		 */
		// waitFor(5);
	}

	/*
	 * This method will add advance wide format calc type service into wide
	 * format dept
	 */
	public void awf() throws Exception {
		// waitFor(5);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		/*
		 * wideFormatText = driver.findElement(wideFormatDept).getText();
		 * driver.findElement(wideFormatDept).click(); logger.info("Selecting.."
		 * + wideFormatText + " " + "Department and entering line item to it");
		 * waitFor(5);
		 */
		/* ********This will add simple wide format service to wide format */
		driver.findElement(awfServiceField).click();
		waitFor(8);
		driver.findElement(awfServiceField).sendKeys(
				repo.getProperty("awflaunchserv_ord"));
		driver.findElement(awfServiceField).sendKeys(Keys.TAB);
		waitFor(8);
		/*
		 * ********Launch Advance Wide Format calculator/adding product to it
		 * and click on Save
		 */
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(genericCalc));
		calcLabel = driver.findElement(By.xpath("//*[@id='ASPxLabel14']"))
				.getText();
		logger.info("The " + calcLabel.toString() + " page opened");
		driver.findElement(By.id("wfEstimateProductTypeDropDownList"))
				.sendKeys("3'x5' Banner");
		logger.info("Selecting 3'x5' Banner Product type in the calculator");
		waitFor(5);
		driver.findElement(awfMaterialDropDown).click();
		driver.findElement(awfMaterialDropDown).sendKeys(
				repo.getProperty("awfmaterial_ord"));
		waitFor(3);
		driver.findElement(awfMaterialDropDown).sendKeys(Keys.TAB);
		waitFor(3);
		driver.findElement(By.id("wfMessageEditor"))
				.sendKeys(
						"****Automation Script-Adding comments for advance wide format****");
		waitFor(3);
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
		logger.info("Save and Close Button on the Order page clicked");
		waitFor(5);
		wait.until(ExpectedConditions.presenceOfElementLocated(orderSearch));
		text_name = driver.findElement(orderSearch).getText();
		logger.info("User is on the.." + text_name.toString());
		waitFor(3);
		text_name = driver.findElement(ordernumber).getText();
		logger.info("New order Id created.." + text_name.toString());
		//ordnum = "# " + text_name;
		/*try {
			if (ordnum.matches(order_Id)) {
				logger.info("The New Order#--" + ordnum
						+ "is created successfully");
			}
		} catch (Exception e) {
			logger.info("The Order# was not created");
		}*/
	}

	/* This method will test the contract template */
	public void contractTemplate() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		order_search = driver.findElement(orderSearch).getText();
		logger.info("The User is on the: " + order_search.toString() + " page");
		driver.findElement(newOrderBtn).click();
		logger.info("The User has clicked on the New Order Button:");
		order_Id = driver.findElement(orderId).getText();
		logger.info("The New Order ID is..." + order_Id.toString());
		waitFor(5);
		driver.findElement(customerName).sendKeys(
				repo.getProperty("cust_name2_ord"));
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
		driver.findElement(contact).sendKeys(
				repo.getProperty("contact_name2_ord"));
		logger.info("Contact Name Entered");
		waitFor(5);
		driver.findElement(contact).sendKeys(Keys.TAB);
		// *****This will add a sales rep in the sales rep drop down...****
		driver.findElement(salesrep).sendKeys(
				repo.getProperty("sales_contact2_ord"));
		logger.info("Sales Rep Entered");
		waitFor(5);
		driver.findElement(salesrep).sendKeys(Keys.TAB);
		// ******This will add a csr in the csr drop down...******
		driver.findElement(csr).sendKeys(repo.getProperty("csr2_ord"));
		logger.info("CSR Entered");
		waitFor(5);
		driver.findElement(csr).sendKeys(Keys.TAB);

		// ******This will add project name in the project text field******
		driver.findElement(projfield).sendKeys(
				repo.getProperty("project_cp_ord"));
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
					repo.getProperty("expqty2_ord"));

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
					repo.getProperty("servicename2_ord"));
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
		wait.until(ExpectedConditions.presenceOfElementLocated(orderSearch));
		text_name = driver.findElement(orderSearch).getText();

		logger.info("User is on the.." + text_name.toString());
		waitFor(3);
		text_name = driver.findElement(ordernumber).getText();

		logger.info("New Order Id.." + text_name.toString());
		ordnum = "# " + text_name;
		try {
			if (ordnum.matches(order_Id)) {

				logger.info("The New Order#--" + ordnum
						+ "is created successfully");
			}
		} catch (Exception e) {

			logger.info("The Order# was not created");
		}
	}

	/* This method will test the copy functionality of an order */
	public void copyOrder() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(orderSearch));
		waitFor(5);
		text_name = driver.findElement(ordernumber).getText();
		logger.info("User has clicked on the order Id " + text_name.toString()
				+ " to open an existing order..");
		driver.findElement(ordernumber).click();
		waitFor(5);
		totalAndTax1 = driver.findElement(TotalAndTax).getText()
				.replace("$", "");
		logger.info("The Total & Tax of the original order#" + text_name
				+ " is $: " + totalAndTax1);
		try {
			driver.findElement(orderCopyBtn).click();
			waitFor(8);
			driver.findElement(BtnCopyOK).click();
			waitFor(8);
			logger.info("The Order# " + text_name + " was copied successfully");
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
			copyOrderNum = driver.findElement(orderId).getText()
					.replace("#", "");
			logger.info("The new copied order#: " + copyOrderNum.toString());
			totalAndTax2 = driver.findElement(TotalAndTax).getText()
					.replace("$", "");
			logger.info("The Total & Tax of the copied order#" + copyOrderNum
					+ " is $: " + totalAndTax2);
			if (totalAndTax1.matches(totalAndTax2)) {
				logger.info("The Total & Tax are correct in the copied order#:"
						+ copyOrderNum);
			} else {
				logger.info("The Total & Tax are incorrect in the copied order#:"
						+ copyOrderNum);
			}

		} catch (Exception e) {
			logger.info("The order# " + text_name + " could not be copied");
		}
	}

	/* This method will add attachment in the attachment tab */
	public void addattachments() throws Exception {
		try {
			attachmentTabMsg = driver.findElement(attachmentTab).getText()
					.toString();
			logger.info("The user has clicked on the " + attachmentTabMsg);
			driver.findElement(attachmentTab).click();
			waitFor(8);
			for (int i = 0; i <= 2; i++) {
				driver.findElement(documentType1).click();
				driver.findElement(documentType1).sendKeys("Logo");
				driver.findElement(documentType1).sendKeys(Keys.TAB);
				driver.findElement(fileNameField1).sendKeys("Logo_Index");
				driver.findElement(fileNameField1).sendKeys(Keys.TAB);
				waitFor(5);
				driver.findElement(uploadFileBtn).click();
				waitFor(5);
				// ***Runtime.getRuntime().exec is used for running executable
				// files
				// from selenium.
				Runtime.getRuntime().exec(projectPath);
				waitFor(5);
				driver.findElement(saveDisketteBtn).click();
				waitFor(7);
			}
			logger.info("The attachment was successfully added");
			driver.findElement(saveBtn).click();
			logger.info("Saved button clicked");
			waitFor(5);
		} catch (Exception e) {
			logger.info("The attachment could not be added");
		}

	}

	/* This method will delete Order */
	public void deleteOrder() throws Exception {
		try {
			order_Id = driver.findElement(orderId).getText();
			driver.findElement(deleteBtn).click();
			waitFor(3);
			alert_dismiss();
			waitFor(3);
			driver.findElement(deleteBtn).click();
			waitFor(3);
			alert_accept();
			waitFor(5);
			logger.info("The Order#" + order_Id + " was deleted successfully");
		} catch (Exception ex) {
			logger.info("The Order# " + order_Id + " could not be deleted");
		}
		waitFor(8);
	}

	/* This will launch PC****** */
	public void printCal() throws Exception {
		// ********This will select Print department and click on it**********
		WebDriverWait wait = new WebDriverWait(driver, 20);
		order_label = driver.findElement(orderlabel).getText();
		logger.info("The label name is---" + order_label.toString());
		driver.findElement(orderlabel).click();
		// order_search = driver.findElement(orderSearch).getText();

		order_search = driver.findElement(orderSearch).getText();
		logger.info("The User is on the: " + order_search.toString() + " page");
		driver.findElement(newOrderBtn).click();
		logger.info("The User has clicked on the New Order Button:");
		order_Id = driver.findElement(orderId).getText();
		logger.info("The New Order ID is..." + order_Id.toString());
		waitFor(8);
		driver.findElement(customerName).sendKeys(
				repo.getProperty("cust_name3"));
		logger.info("Customer Name Entered");
		waitFor(8);
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
		driver.findElement(projfield).sendKeys(
				repo.getProperty("projecttxt4_ord"));
		logger.info("Project Name Entered");
		waitFor(3);
		due_date = repo.getProperty("duedate_ord");
		driver.findElement(dueDate).click();
		driver.findElement(dueDate).sendKeys(repo.getProperty("duedate_ord"));
		logger.info("The due date entered: " + due_date);
		waitFor(3);
		String menuItem = driver.findElement(detailstab).getText();
		if (menuItem.matches("Details")) {
			logger.info("Currently under " + menuItem + " tab");
			// ********This will add a expected qty of 1000 and clicks on save
			// and submit to close the Order page********
			driver.findElement(expectedQty).sendKeys(
					repo.getProperty("expqty3"));
			logger.info("Expected Qty Entered");
		}
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
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
					.cssSelector("#ctl00_mainContentPlaceHolder_iframePrintCalculator")));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
					.cssSelector("#aspxCallPnlMain_iframePrintCalc")));

			// wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#MainaspxCallPnlMain_iframePrintCalcPrintPnl_PECancelButton']")));
			waitFor(10);
			/*
			 * driver.findElement(By.xpath("//*[@id='MainPrintPnl_ASPxLabel3']"))
			 * .getText(); System.out.println(driver.findElement(
			 * By.xpath("//*[@id='MainPrintPnl_ASPxLabel3']")).getText()); //
			 * driver
			 * .findElement(By.cssSelector("#MainPrintPnl_PECancelButton"))
			 * .click();
			 * 
			 * wait.until(ExpectedConditions.presenceOfElementLocated(By
			 * .xpath("//img[@id='MainPrintPnl_ASPxImage5']"))); image =
			 * driver.findElement(
			 * By.xpath("//img[@id='MainPrintPnl_ASPxImage5']")).isDisplayed();
			 * 
			 * if (image == false)
			 * logger.info("The Print Calculator does not exits"); else
			 * logger.info("The Print Calculator exits");
			 */
			/*
			 * template_grp = driver.findElement(
			 * By.xpath("//*[@id='MainPrintPnl_ddlServiceGroup']//input"
			 * )).getText();
			 */
			// waitFor(5);
			driver.findElement(templateGrpDropDown).sendKeys(
					repo.getProperty("templateGrp"));

			template_grp = driver.findElement(templateGrpDropDown)
					.getAttribute("value");
			logger.info("The Template --" + template_grp.toString()
					+ " --is selected");
			driver.findElement(templateGrpDropDown).sendKeys(Keys.TAB);
			waitFor(8);

			driver.findElement(templateNameDropDown).sendKeys(Keys.CLEAR);
			driver.findElement(templateNameDropDown).sendKeys(
					repo.getProperty("tempname"));
			template_name = driver.findElement(templateNameDropDown)
					.getAttribute("value");
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
			logger.info("Print Calculator was successfully created");
			waitFor(5);
			driver.findElement(saveBtn).click();
			waitFor(8);
		} catch (Exception E) {
			logger.info("Print Calculator was not created ");
		}

	}

	/* Check version grid copy functionality */
	public void versionCopy() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			driver.findElement(versionTab).click();
			logger.info("Version Tab clicked to open version grid:");
			waitFor(8);
			driver.findElement(versionCopy).click();
			logger.info("Version Copy button clicked to create a new copy:");
			waitFor(5);
			try {

				wait.until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(versionCopyPopup));
				text_name = wait.until(
						ExpectedConditions
								.presenceOfElementLocated(versionCopyText))
						.getText();
				logger.info(text_name);
				driver.findElement(verCopySaveAndClose).click();
				logger.info(text_name + " Is Saved");
				waitFor(5);
				driver.switchTo().defaultContent();
				waitFor(10);
				logger.info("Version Successfully Copied");

			} catch (Exception ex) {
				logger.info("Version could not be copied");
				System.out.println(ex);
			}
		} catch (Exception ex) {
			logger.info("Version could not be opened");
			System.out.println(ex);
		}
	}

	/* Check version grid edit functionality */
	public void versionEdit() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(versionTab).click();
			logger.info("Version Tab clicked to open version grid:");
			waitFor(10);
			try {
				driver.findElement(verEditGrid).click();
				waitFor(10);
				// System.out.println(verName);
				// driver.findElement(verEditGrid).sendKeys(Keys.TAB);
				// driver.findElement(verName).click();
				// driver.findElement(verName).sendKeys(Keys.CONTROL, "a");
				// driver.findElement(verName).sendKeys(repo.getProperty("vername_ord"));
				// waitFor(8);
				// driver.findElement(verName).sendKeys(Keys.TAB);
				driver.findElement(verQty).click();
				driver.findElement(verQty).sendKeys(Keys.CONTROL, "a");
				driver.findElement(verQty).sendKeys(
						repo.getProperty("verqty_ord"));
				waitFor(8);
				/*
				 * driver.findElement(verDueDate).click();
				 * driver.findElement(verDueDate).sendKeys(Keys.CONTROL, "a");
				 * //driver.findElement(verQty).sendKeys(Keys.TAB);
				 * //driver.findElement
				 * (verDueDate).sendKeys(repo.getProperty("verduedate_ord"));
				 * driver.findElement(verDueDate).sendKeys("3/1/2018");
				 * waitFor(8); driver.findElement(verDropShipDate).click();
				 * //driver.findElement(verDropShipDate).sendKeys(Keys.CONTROL,
				 * "a");
				 * //driver.findElement(verDropShipDate).sendKeys(repo.getProperty
				 * ("verdropshipdate_ord"));
				 * driver.findElement(verDropShipDate).sendKeys("3/5/2018");
				 * waitFor(5);
				 */
				driver.findElement(verSaveDiskette).click();
				waitFor(8);
				wait.until(ExpectedConditions
						.frameToBeAvailableAndSwitchToIt(versionCopyPopup));
				text_name = wait
						.until(ExpectedConditions
								.presenceOfElementLocated(verEditGridPopUpText))
						.getText();
				logger.info(text_name);
				driver.findElement(verYesBtn).click();
				waitFor(5);
				driver.switchTo().defaultContent();
				waitFor(8);
				String svcsandtotal = driver.findElement(verTotalSvcsAndTax)
						.getText().replace("$", "").replace(",", "");
				logger.info("The Service and Taxes are: $" + svcsandtotal);
				Double svcsandtotal1 = Double.parseDouble(svcsandtotal);
				Double versvcsandtax_ord1 = Double.parseDouble(repo
						.getProperty("versvcsandtax_ord"));
				if (svcsandtotal1.equals(versvcsandtax_ord1)) {
					logger.info("Version Edited Successfully And The Total svsc and taxes are correct:");
				} else {
					logger.info("Version Edited Unsuccessfull And  The Total svsc and taxes are incorrect:");
				}
			} catch (Exception ex) {
				logger.info("Version Grid could not edited");
				System.out.println(ex);
			}

		} catch (Exception ex) {
			logger.info("Version could not be opened");
			System.out.println(ex);
		}

	}

	/* Check add version functionality */
	public void versionAdd() {
		try {
			driver.findElement(verQtyAdd).click();
			driver.findElement(verQtyAdd).sendKeys(
					repo.getProperty("verqtyadd_ord"));
			waitFor(5);
			driver.findElement(verSaveDisketteAdd).click();
			alert_accept();
			waitFor(8);
			logger.info("New Version Has Been Successfully Added");

		} catch (Exception ex) {
			logger.info("The New Version Could Not Be Added:");
		}

	}

	/* Check delete version functionality */
	public void versionDelete() {
		try {
			driver.findElement(versionTab).click();
			logger.info("Version Tab clicked to open version grid:");
			waitFor(10);
			driver.findElement(verDel).click();
			waitFor(5);
			alert_accept();
			waitFor(10);
			logger.info("Version Has Been Deleted");
		} catch (Exception ex) {
			logger.info("Version Could Not Deleted----" + ex);
		}
	}

	/* Export to estimate functionality */
	public void exportEstimate() {

		try {
			// WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(detailstab).click();
			waitFor(8);
			try {
				driver.findElement(estimateExportBtn).click();
				logger.info("Estimate Export button is clicked");
				waitFor(10);
				// wait.until(ExpectedConditions.presenceOfElementLocated(estimateExportPanel));
				estimate_export = driver.findElement(estimateExportTxt)
						.getText().toString();
				waitFor(5);
				logger.info(estimate_export);
				driver.findElement(estimateExportOKBtn).click();
				waitFor(8);
				// wait.until(ExpectedConditions.presenceOfElementLocated(accountWarning1));
				accountWarningMsg = driver.findElement(accountWarning1)
						.getText();
				waitFor(5);
				// logger.info("The Name of the Pop up is---" +
				// accountWarningMsg);
				try {
					if (accountWarningMsg.matches("Account Warning Message:")) {
						driver.findElement(acctwarningOkBtn).click();
					}
				} catch (Exception ex) {
					logger.info("Account Warning Message Popup Cannot be closed----"
							+ ex);
				}
				waitFor(8);
				ExportedEstimateNum = driver.findElement(estimateExportId)
						.getText().replace("#", "");
				logger.info("The new exported estimate# "
						+ ExportedEstimateNum.toString());
				driver.findElement(orderlabel).click();
				waitFor(8);
				text_name = driver.findElement(orderSearch).getText()
						.toString();
				logger.info("User is on the " + text_name);
			} catch (Exception ex) {
				logger.info("Estimate Could Not Be Exported----" + ex);
			}

		} catch (Exception ex) {
			logger.info("Details Tab Could Not Be opened---" + ex);
		}

	}

	/*
	 * Single Drop-Change the order header due date will change the drops due
	 * date
	 */
	public void singleDrop1() throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			order_label = driver.findElement(orderlabel).getText();
			logger.info("The label name is---" + order_label.toString());
			driver.findElement(orderlabel).click();
			order_search = driver.findElement(orderSearch).getText();
			logger.info("The User is on the: " + order_search.toString()
					+ " page");
			driver.findElement(newOrderBtn).click();
			logger.info("The User has clicked on the New Order Button:");
			order_Id = driver.findElement(orderId).getText();
			logger.info("The New Order ID is..." + order_Id.toString());
			waitFor(8);
			driver.findElement(customerName).sendKeys(
					repo.getProperty("cust_name_dropsord1"));
			logger.info("Customer Name Entered");
			waitFor(8);
			driver.findElement(customerName).sendKeys(Keys.ENTER);
			waitFor(10);
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
			// *****This will add a contact in the contact drop down..****
			driver.findElement(contact).sendKeys(Keys.CONTROL + "a");
			driver.findElement(contact).sendKeys(
					repo.getProperty("contact_name_dropsord1"));
			logger.info("Contact Name Entered");
			driver.findElement(contact).sendKeys(Keys.TAB);
			// *****This will add a sales rep in the sales rep drop down...****
			driver.findElement(salesrep).sendKeys(
					repo.getProperty("sales_contact_dropsord1"));
			logger.info("Sales Rep Entered");
			waitFor(5);
			driver.findElement(salesrep).sendKeys(Keys.TAB);
			// ******This will add a csr in the csr drop down...******
			driver.findElement(csr).sendKeys(repo.getProperty("csr_dropsord1"));
			logger.info("CSR Entered");
			waitFor(5);
			driver.findElement(csr).sendKeys(Keys.TAB);
			// ******This will add project name in the project text field******
			driver.findElement(projfield).sendKeys(
					repo.getProperty("projecttxt_dropsord1"));
			logger.info("Project Name Entered");
			waitFor(3);
			due_date = repo.getProperty("duedate_ord");
			driver.findElement(dueDate).click();
			driver.findElement(dueDate).sendKeys(
					repo.getProperty("duedate_ord"));
			logger.info("The due date entered: " + due_date);
			waitFor(3);
			String menuItem = driver.findElement(detailstab).getText();
			if (menuItem.matches("Details")) {
				logger.info("Currently under " + menuItem + " tab");
				// ********This will add a expected qty of 1000 and clicks on
				// save
				// and submit to close the Order page********
				driver.findElement(expectedQty).sendKeys(
						repo.getProperty("expqty_dropsord1"));
				logger.info("Expected Qty Entered");
			}
			// waitFor(5);
			driver.findElement(saveBtn).click();
			waitFor(10);
			driver.findElement(dropsTab).click();
			logger.info("User has clicked on the drops tab to open drops grid:");
			waitFor(10);
			due_date = repo.getProperty("duedateheader_ord");
			driver.findElement(dueDate).click();
			waitFor(3);
			driver.findElement(dueDate).sendKeys(Keys.CONTROL, "a");
			waitFor(3);
			driver.findElement(dueDate).sendKeys(
					repo.getProperty("duedateheader_ord"));
			logger.info("The changed due date entered is: " + due_date);
			waitFor(3);
			driver.findElement(saveBtn).click();
			waitFor(10);
			// driver.findElement(dropTabDueDate).click();
			// waitFor(3);
			droptabdue_date = driver.findElement(dropTabDueDate).getAttribute(
					"value");
			logger.info("The single drop date is: " + droptabdue_date);
			if (due_date.equals(droptabdue_date)) {
				logger.info("Single drop due date changed with the change in order header due date:");
			} else {
				logger.info("Single drop due date did not changed with the change in order header due date:");
			}
		} catch (Exception ex) {
			logger.info("Single Drop due date could not be changed---" + ex);
		}
		// waitFor(5);
	}

	/*
	 * Single Drop-Change the version tab due date will change the drops due
	 * date
	 */
	public void singleDrop_VerTab() {
		try {
			waitFor(3);
			driver.findElement(dueDate).click();
			waitFor(3);
			driver.findElement(dueDate).sendKeys(Keys.CONTROL, "a");
			waitFor(3);
			driver.findElement(dueDate).sendKeys(Keys.DELETE);
			waitFor(3);
			/*
			 * driver.findElement(saveBtn).click(); waitFor(8);
			 */
			driver.findElement(versionTab).click();
			waitFor(8);
			driver.findElement(verEditGrid1).click();
			waitFor(5);
			// This will click on the date picker
			driver.findElement(
					By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_edit0_3_deDueDateEdit_B-1Img']"))
					.click();
			WebElement dateWidget = driver
					.findElement(By
							.xpath("//*[@id='ctl00_mainContentPlaceHolder_cpVersionList_gvVersionList_edit0_3_deDueDateEdit_DDD_C_mt']"));
			List<WebElement> columns = dateWidget
					.findElements(By.tagName("td"));
			for (WebElement cell : columns) {
				// Select 29th Date
				if (cell.getText().equals("29")) {
					cell.click();
					break;
				}
			}
			driver.findElement(verSaveDisketteAdd1).click();
			logger.info("Save diskette on the version tab is clicked:");
			waitFor(8);
			driver.findElement(saveBtn).click();
			waitFor(10);
			VerTabDueDate_txt = driver.findElement(VerTabDueDate).getText();
			logger.info("The due date in the version tab is: "
					+ VerTabDueDate_txt);
			driver.findElement(GeneralTab).click();
			waitFor(10);
			driver.findElement(dropsTab).click();
			waitFor(8);
			droptabdue_date = driver.findElement(dropTabDueDate).getAttribute(
					"value");
			if (VerTabDueDate_txt.equals(droptabdue_date)) {
				logger.info("Drops Tab Due Date and Version Tab Due Date Are Same: "+droptabdue_date +" && "+VerTabDueDate_txt);
			} else {
				logger.info("Drops Tab Due Date and Version Tab Due Date Are Not Same: "+droptabdue_date+" && "+VerTabDueDate_txt);
			}
		} catch (Exception ex) {
			logger.info("Due date on the version tab could not be edited: "
					+ ex);

		}
	}

	/*
	 * Multiple Drop-Change the order header due date will not change the drops
	 * due date
	 */
	public void MultipleDrops() {

		try {
			for (int i = 1; i <= 3; i++) {
				driver.findElement(
						By.xpath("//*[@id='ctl00_mainContentPlaceHolder_dropGridView_cell"
								+ i + "_0_dropDate_I']")).click();
				waitFor(3);
				driver.findElement(
						By.xpath("//*[@id='ctl00_mainContentPlaceHolder_dropGridView_cell"
								+ i + "_0_dropDate_I']")).sendKeys("3/30/2018");
				waitFor(3);
				driver.findElement(
						By.xpath("//*[@id='ctl00_mainContentPlaceHolder_dropGridView_cell"
								+ i + "_0_dropDate_I']")).sendKeys(Keys.TAB);
				waitFor(5);
			}
			logger.info("Added due dates on the drops tab grid***");

			due_date = repo.getProperty("duedateheader_ord1");
			driver.findElement(dueDate).click();
			waitFor(10);
			// driver.findElement(dueDate).sendKeys(Keys.CONTROL, "a");
			driver.findElement(dueDate).sendKeys(
					repo.getProperty("duedateheader_ord1"));
			logger.info("The changed due date in the order header due date entered is: "
					+ due_date);
			waitFor(10);
			driver.findElement(saveBtn).click();
			waitFor(10);

			/*
			 * Will check all the drops due date against the order header due
			 * date
			 */
			for (int j = 0; j <= 3; j++) {
				driver.findElement(
						By.xpath("//*[@id='ctl00_mainContentPlaceHolder_dropGridView_cell"
								+ j + "_0_dropDate_I']")).click();
				String dropsduedate = driver
						.findElement(
								By.xpath("//*[@id='ctl00_mainContentPlaceHolder_dropGridView_cell"
										+ j + "_0_dropDate_I']")).getAttribute(
								"value");
				if (dropsduedate != due_date) {
					logger.info("The drops due date did not changed with change in order header due date->Correct:");
				} else {
					logger.info("The drops due date changed with change in order header due date->Incorrect:");
				}
			}

		} catch (Exception ex) {
			logger.info("Multiple Drops Could Not Be Verified:" + ex);
		}
	}

	/*
	 * Multiple Drops-Delete
	 */
	public void DropDelete() {
		try {
			waitFor(3);
			driver.findElement(
					By.xpath("//*[@id='ctl00_mainContentPlaceHolder_dropGridView_DXDataRow3']/td[7]/img"))
					.click();
			waitFor(8);
			driver.findElement(saveBtn).click();
			logger.info("Drop got deleted");
		} catch (Exception ex) {
			logger.info("Issue with drops deletion");
		}
	}

}
