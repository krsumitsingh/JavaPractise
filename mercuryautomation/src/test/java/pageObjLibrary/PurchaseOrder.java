package pageObjLibrary;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import pkgTestBase.Config_PO;
import pkgTestBase.TestBase;

public class PurchaseOrder extends TestBase {

	WebDriver driver;

	public static final Logger logger = Logger.getLogger(EstimatesPage.class
			.getName());

	String PO_Label_Search = "";
	String PO_Label_Search1 = "Purchase Order Search";
	String POTabLabel = "";
	String PONumber;
	String POLabel = "";
	String VendorName = "";
	String VendorContact = "";
	String OrderBy = "";
	String Licensee = "";
	String ProjectTxt = "";
	String OrderPage = "";
	String ItemSelected = "";
	String Qty = "";
	String MarkupPer = "";
	String UP = "";
	String OpenOrdersTxt = "";
    String OrderNumber = "";
    String ExtPrice = "";
    String ExtPrice1 = "";
    String ExtPrice_PO = "";
    String ExtPricemarkUp = "";
    String ExtPricemarkUp1 = "";
    String ExtPricemarkUp_PO = "";
	
	
	
	By POTab = By
			.xpath("//*[@class='dxmMenuItemWithImage mainMenuCSSClass3']//*[text()='Purchasing']");
	By POSearchLabel = By
			.xpath("//*[@class='widget_header']//*[text()='Purchase Order Search']");
	By POFilterField = By
			.xpath("//input[contains(@id,'DXFREditorcol0_I')]");
	By PORecord = By
			.xpath(".//*[@id='ctl00_mainContentPlaceHolder_PurchaseOrderGridView_tccell0_0']/a");
	By SaveBtn = By
			.xpath(".//*[contains(@id,'SaveButton_CD')]/span");
	By SaveClose = By
			.xpath("//*[contains(@id,'submitButton')]/span");
	By CopyBtn = By
			.xpath(".//*[contains(@id,'copyButton')]/span");
	By CopyMsgLabel = By
			.xpath(".//*[contains(@id,'CopiedMsgLabel')]");
	By OkBtn = By
			.xpath(".//*[contains(@id,'btPOCopied')]");
	By POlabel = By
			.xpath("//label[contains(@id,'POLabel')]");
	By PODeleteBtn = By
			.xpath(".//*[contains(@id,'deleteButton_CD')]");
	By NewPOBtn = By
			.xpath(".//*[contains(@id,'newAddButton_CD')]");
	By CancelBtn = By
			.xpath(".//*[@id='ctl00_mainContentPlaceHolder_cancelButton_CD']/span");
	By VendorDD = By
			.xpath("//input[contains(@id,'VendorComboBox_I')]");
	By VendorContactDD = By
			.xpath("//input[contains(@id,'contactDropDownList_I')]");
	By VendorOrderBy = By
			.xpath("//input[contains(@id,'OrderByDropDownList_I')]");
	By LicenseeDD = By
			.xpath("//input[contains(@id,'licenseeCustomerDropDownList_I')]");
	By ProjectName = By
			.xpath("//input[contains(@id,'projectTextBox_I')]");
	By CancelConfirmMsg = By
			.xpath(".//*[@id='ctl00_divShowConfirmMsg']");
	By CancelYesBtn = By
			.xpath(".//*[@id='ctl00_yesButton_CD']/span");
	By ItemOrdered = By
			.xpath(".//*[contains(@id,'POSubMenu_DXI0_T')]");
	By ItemDD = By
			.xpath("//input[contains(@id,'ItemIdComboBox_I')]");
	By QtyField = By
			.xpath("//input[contains(@id,'QuantityAddTextBox_I')]");
	By Markup = By
			.xpath("//input[contains(@id,'markupPercentageAddTextBox_I')]");
	By UnitPrice = By
			.xpath("//input[contains(@id,'ItemPriceAddTextBox_I')]");	
	By OrderNoLink = By
			.xpath(".//*[contains(@id,'itemOrderNumberLinkButton')]");
	By OrderNoLinkPopUp = By
			.xpath(".//*[contains(@id,'ctl00_iframeCommonPopup')]");
	By OrderNumGridEdit = By
			.xpath(".//*[contains(@id,'itemOrderNumberEditLinkButton')]");
	By SaveDiskette = By
			.xpath(".//*[contains(@id,'addImageButton')]");
	By OpenOrders = By
			.xpath(".//*[contains(@id,'ASPxLabel22')]");
	By ExtPriceTotal = By
			.xpath(".//*[contains(@id,'GridTotalLabel')]"); 
	By ExtPriceTotalAndMarkup = By
			.xpath(".//*[contains(@id,'lblExtPriceMarkup')]");
	
	
	
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public PurchaseOrder (WebDriver driver) {
		this.driver = driver;
	}
	
	Config_PO config = new Config_PO();
	
	SoftAssert SA = new SoftAssert();

	/* Clicks on the PO tab to open PO search screen */
	public void POTab() {
		POTabLabel = driver.findElement(POTab).getText().toString();
		logger.info("The label name is---- " + POTabLabel
				+ " and user has clicked on it");
		driver.findElement(POTab).click();
	}

	/* User is on the search page */
	public void POlabel() {
		PO_Label_Search = driver.findElement(POSearchLabel).getText()
				.toString();
		if (PO_Label_Search.equals(PO_Label_Search1)) {
			logger.info("User is on the---" + PO_Label_Search);
		} else {
			logger.info(PO_Label_Search + "is not opened");
		}
	}

	/* Method to print thePO# the record */
	public void PORecordFetch() {
		PONumber = driver.findElement(PORecord).getText().toString();
		logger.info("The PO# is " + PONumber);
	}

	/* This method is for save the PO# */
	public void save() {
		driver.findElement(SaveBtn).click();
		logger.info("User clicked on Save button ");
	}
	
	/* This method is for save and close */
	public void saveclose() {
		driver.findElement(SaveClose).click();
		logger.info("User clicked on Save and Close button ");
	}

	/* This method is for Copy PO */
	public void CopyPO() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(CopyBtn));
		driver.findElement(CopyBtn).click();
		logger.info("PO# " + PONumber + " copied");
		wait.until(ExpectedConditions.presenceOfElementLocated(CopyMsgLabel));
		driver.findElement(OkBtn).click();
		POLabel = driver.findElement(POlabel).getText().toString();
		logger.info("The Copied PO# is " + POLabel);
		waitFor(5);
	}
	
	/* This method is for cancel PO */
	public void CancelPO() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(CancelBtn));
		POLabel = driver.findElement(POlabel).getText().toString();
		logger.info(POLabel + " is cancelled");
		driver.findElement(CancelBtn).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(CancelConfirmMsg));		
		driver.findElement(CancelYesBtn).click();
		waitFor(5);
	}

	/* This method is for delete PO */
	public void delete() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(PODeleteBtn));
		POLabel = driver.findElement(POlabel).getText().toString();
		logger.info(POLabel + " deleted");
		driver.findElement(PODeleteBtn).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		alert_accept();
	}

	/* This method is for New PO button click*/
	public void NewPO() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.presenceOfElementLocated(NewPOBtn));
			driver.findElement(NewPOBtn).click();
			waitFor(5);
			POLabel = driver.findElement(POlabel).getText().toString();
			logger.info(POLabel + " is opened");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}
	
	/* This method will add vendor*/
	public void enterVendor(String vendorname) throws Exception{
		driver.findElement(VendorDD).sendKeys(Keys.CONTROL + "a");
		driver.findElement(VendorDD).sendKeys(vendorname);
		VendorName = config.getVendorName().toString();
		logger.info("Vendor-->" +VendorName);
		waitFor(5);
		driver.findElement(VendorDD).sendKeys(Keys.TAB);
		waitFor(5);

	}
	
	/* This method will add contact*/
	public void enterVendorContact(String vendorcontact) throws InterruptedException{
		driver.findElement(VendorContactDD).sendKeys(Keys.CONTROL + "a");
		driver.findElement(VendorContactDD).sendKeys(vendorcontact);
		VendorContact = config.getvendorcontact().toString();
		logger.info("Vendor Contact-->" +VendorContact);
		waitFor(5);
		driver.findElement(VendorContactDD).sendKeys(Keys.TAB);	
		waitFor(5);
	}
	
	/* This method will add ordered by*/
	public void SelectOrder(String order_by) throws InterruptedException{
		driver.findElement(VendorOrderBy).sendKeys(Keys.CONTROL + "a");
		driver.findElement(VendorOrderBy).sendKeys(order_by);
		OrderBy = config.getSelectOrderBy().toString();
		logger.info("Ordered By-->" +OrderBy);
		waitFor(5);
		driver.findElement(VendorOrderBy).sendKeys(Keys.TAB);
		waitFor(5);
	}
	
	/* This method will add company*/
	public void SelectLicensee(String company) throws InterruptedException{
		driver.findElement(LicenseeDD).sendKeys(Keys.CONTROL + "a");
		driver.findElement(LicenseeDD).sendKeys(company);
		Licensee = config.getSelectLicensee().toString();
		logger.info("Licensee-->" +Licensee);
		waitFor(5);
		driver.findElement(LicenseeDD).sendKeys(Keys.TAB);	
		waitFor(5);
	}
	
	/* This method will add project name*/
	public void ProjectName(String ProjName) throws Exception{
		driver.findElement(ProjectName).sendKeys(Keys.CONTROL + "a");
		driver.findElement(ProjectName).sendKeys(ProjName);
		ProjectTxt = config.getProjectName().toString();
		logger.info("Project Name-->" +ProjectTxt);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*driver.findElement(ProjectName).sendKeys(Keys.TAB);
		waitFor(5);		*/	
	}

	/* This method will add Items from Item DD*/
	public void ItemDropDown(String Item ) throws Exception{
		 if(driver.findElement(ItemOrdered).isEnabled()){
			 driver.findElement(ItemDD).sendKeys(Keys.CONTROL+"a");
			 waitFor(3);
			 driver.findElement(ItemDD).sendKeys(Item);
			 ItemSelected = config.getItemDropDown().toString();
				logger.info("Item -->" +ItemSelected);
				 waitFor(5);
			 driver.findElement(ItemDD).sendKeys(Keys.TAB);
			 waitFor(4);
		 } 
	 else{
		 logger.info("Item Order tab is not enabled");
	 }
		 }
	
	/* This method will add qty to quantity field*/
	public void Quantity(String Qty) throws Exception{
		driver.findElement(QtyField).sendKeys(Qty);
		 Qty = config.getQuantity().toString();
			logger.info("Quantity -->" +Qty);
		 driver.findElement(QtyField).sendKeys(Keys.TAB);
		 waitFor(4);
		 }
		
	/* This method will add MarkUp*/
	public void MarkupValue(String markup) throws Exception{
		driver.findElement(Markup).sendKeys(markup);
		 MarkupPer = config.getMarkUpTxt().toString();
			logger.info("Markup% -->" +MarkupPer);
		 driver.findElement(Markup).sendKeys(Keys.TAB);
		 waitFor(4);
		 }
	
	/* This method will add Unit Price*/
	public void UnitPrice(String unitprice) throws Exception{
		driver.findElement(UnitPrice).sendKeys(unitprice);
		 UP = config.getUnitPriceTxt().toString();
			logger.info("Unit Price-->" +UP);
		 driver.findElement(UnitPrice).sendKeys(Keys.TAB);
		 waitFor(4);
		 }
	
	/* This method will add Order# from Order link*/
	public void orderNoLink(){
		driver.findElement(OrderNoLink).click();
		 try{
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(OrderNoLinkPopUp));
			 wait.until(ExpectedConditions.presenceOfElementLocated(OpenOrders));
			 waitFor(2);
			 OpenOrdersTxt = driver.findElement(OpenOrders).getText().toString();
			 logger.info(OpenOrdersTxt+"--opened");
			 OrderNumber = driver
					 .findElement(By.xpath(".//*[@id='itemOpenOrdersGridView_cell0_0_OrderNumberButton_CD']")).getText().toString();
			 driver.findElement(By.xpath(".//*[@id='itemOpenOrdersGridView_cell0_0_OrderNumberButton_CD']")).click();
			 waitFor(5);
			 driver.switchTo().defaultContent(); 			
			 logger.info("The order number added in the grid "+OrderNumber);
		 }catch(Exception Ex){
			 logger.info("Order Page Popup not available");
		 }
	}
	
	/* This method will read ext.price from ext.price total field*/
	public void extendedPriceTotal(){
		ExtPrice = config.getExtPrice().toString();
		ExtPrice1 = driver.findElement(ExtPriceTotal).getText().replace("$", "");
		ExtPrice_PO = ExtPrice1.toString();	
		SA.assertTrue(ExtPrice.equals(ExtPrice_PO));
		logger.info("Ext. Price Total is correct: "+ExtPrice_PO);
	    //Assert.assertEquals(ExtPrice, ExtPrice_PO, "Extended.Price Total is correct");		
	}
	
	/* This method will read ext.price + markup*/
	public void extendedPricemarkupTotal(){
		ExtPricemarkUp = config.getExtPriceAndMarkup().toString();		
		ExtPricemarkUp1 = driver.findElement(ExtPriceTotalAndMarkup).getText().replace("$", "");
		ExtPricemarkUp_PO = ExtPricemarkUp1.toString();	
		SA.assertTrue(ExtPricemarkUp.equals(ExtPricemarkUp_PO));
		logger.info("Ext. Price Total + Markup is correct: "+ExtPricemarkUp_PO);
		//Assert.assertEquals(ExtPricemarkUp, ExtPricemarkUp_PO, "Extended.Price + Markup Total is correct");		
	}
	
	
	
	
	
	
	
	/* This method will Save the record in the grid*/
	public void SaveDiskette() throws Exception{
		driver.findElement(SaveDiskette).click();
		 logger.info("**Items added and saved to the grid**");
		 waitFor(5);			
	}
	
	
	
	
	
	/*-------------------------------------------------------+++++++++++++++++++++++++++++============+++++++++++++++++++++-*/
	
	public void POSearchScreen() throws Exception {
		POTab();
		waitFor(3);
		POlabel();
	}

	public void OpenPO() throws Exception {
		PORecordFetch();
		driver.findElement(PORecord).click();
		logger.info("Purchase Order# " + PONumber + " is opened");
	}

	public void DeletePO() {
		delete();
	}

	public void NewPO_Cancel(String vendorname, String vendorcontact, String orderby, String company, String ProjName ) throws Exception {
		NewPO();
		enterVendor(vendorname);
		enterVendorContact(vendorcontact);
		SelectOrder(orderby);
		SelectLicensee(company);
		ProjectName(ProjName);	
		CancelPO();
		
	}
	
	public void CreateNewPO(String Item, String Qty, String Markup, String UnitPrice) throws Exception {
		NewPO();
		enterVendor(config.getVendorName());
		enterVendorContact(config.getvendorcontact());
		SelectOrder(config.getSelectOrderBy());
		SelectLicensee(config.getSelectLicensee());
		ProjectName(config.getProjectName());	
		ItemDropDown(Item);
		Quantity(Qty);
		MarkupValue(Markup);
		UnitPrice(UnitPrice);
		orderNoLink();
		SaveDiskette();
		extendedPriceTotal();
		extendedPricemarkupTotal();
		saveclose();
	}
	
	public void AddItemOrderedNewRow() throws Exception{
		ItemDropDown(config.getItemDropDown());
		Quantity(config.getQuantity());
		MarkupValue(config.getMarkUpTxt());
		UnitPrice(config.getUnitPriceTxt());
		orderNoLink();
		SaveDiskette();		
		
	}
	
	

}
