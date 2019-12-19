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
import org.testng.Reporter;

import pkgTestBase.TestBase;

public class PurchaseOrder_BackupCopy extends TestBase {

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
	
	
	
	By POTab = By
			.xpath("//*[@class='dxmMenuItemWithImage mainMenuCSSClass3']//*[text()='Purchasing']");
	By POSearchLabel = By
			.xpath("//*[@class='widget_header']//*[text()='Purchase Order Search']");
	By POFilterField = By
			.xpath("//input[contains(@id,'DXFREditorcol0_I')]");
	By PORecord = By
			.xpath(".//*[@id='ctl00_mainContentPlaceHolder_PurchaseOrderGridView_tccell0_0']/a");
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
	By SaveDiskette = By
			.xpath(".//*[contains(@id,'addImageButton')]");
	By OpenOrders = By
			.xpath(".//*[contains(@id,'ASPxLabel22')]");
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public PurchaseOrder_BackupCopy(WebDriver driver) {
		this.driver = driver;
	}

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
			waitFor(3);
			POLabel = driver.findElement(POlabel).getText().toString();
			logger.info(POLabel + " is opened");
		} catch (Exception ex) {
			logger.error(ex);
		}
	}

	/* This method will add vendor*/
	public void enterVendor() throws Exception {
		driver.findElement(VendorDD).sendKeys(Keys.CONTROL + "a");
		driver.findElement(VendorDD).sendKeys(repo.getProperty("vendor_name"));
		VendorName = repo.getProperty("vendor_name").toString();
		logger.info("Vendor-->" +VendorName+" added");
		waitFor(5);
		driver.findElement(VendorDD).sendKeys(Keys.TAB);
	}

	/* This method will add contact*/
	public void enterVendor_Contact() throws InterruptedException {
		driver.findElement(VendorContactDD).sendKeys(Keys.CONTROL + "a");
		driver.findElement(VendorContactDD).sendKeys(repo.getProperty("vendor_contact"));
		VendorContact = repo.getProperty("vendor_contact").toString();
		logger.info("Vendor Contact-->" +VendorContact+" added");
		waitFor(5);
		driver.findElement(VendorContactDD).sendKeys(Keys.TAB);
	}
	
	/* This method will add ordered by*/
	public void SelectOrder() throws Exception {
		driver.findElement(VendorOrderBy).sendKeys(Keys.CONTROL + "a");
		driver.findElement(VendorOrderBy).sendKeys(repo.getProperty("order_by"));
		OrderBy = repo.getProperty("order_by").toString();
		logger.info("Ordered By-->" +OrderBy+" added");
		waitFor(5);
		driver.findElement(VendorOrderBy).sendKeys(Keys.TAB);
	}
	
	/* This method will add company*/
	public void SelectLicensee() throws Exception {
		driver.findElement(LicenseeDD).sendKeys(Keys.CONTROL + "a");
		driver.findElement(LicenseeDD).sendKeys(repo.getProperty("company"));
		Licensee = repo.getProperty("company").toString();
		logger.info("Licensee-->" +Licensee+" added");
		waitFor(5);
		driver.findElement(LicenseeDD).sendKeys(Keys.TAB);
	}
	
	/* This method will add project name*/
	public void ProjectName() {
		driver.findElement(ProjectName).sendKeys(Keys.CONTROL + "a");
		driver.findElement(ProjectName).sendKeys(repo.getProperty("projectname"));
		ProjectTxt = repo.getProperty("projectname").toString();
		logger.info("Project Name-->" +ProjectTxt+" added");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.findElement(ProjectName).sendKeys(Keys.TAB);
	}
	
	/* This method will enter Items Ordered Grid Value*/
	public void ItemsOrdered() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 15);
	 if(driver.findElement(ItemOrdered).isEnabled()){
		 driver.findElement(ItemDD).sendKeys(Keys.CONTROL+"a");
		 waitFor(3);
		 driver.findElement(ItemDD).sendKeys(repo.getProperty("ItemDropDown"));
		 ItemSelected = repo.getProperty("ItemDropDown").toString();
			logger.info("Item -->" +ItemSelected+" added");
		 driver.findElement(ItemDD).sendKeys(Keys.TAB);
		 waitFor(2);
		 driver.findElement(QtyField).sendKeys(repo.getProperty("Quantity"));
		 Qty = repo.getProperty("Quantity").toString();
			logger.info("Quantity -->" +Qty+" added");
		 driver.findElement(QtyField).sendKeys(Keys.TAB);
		 waitFor(2);
		 driver.findElement(Markup).sendKeys(repo.getProperty("MarkUpTxt"));
		 MarkupPer = repo.getProperty("MarkUpTxt").toString();
			logger.info("Markup% -->" +MarkupPer+" added");
		 driver.findElement(Markup).sendKeys(Keys.TAB);
		 waitFor(2);
		 driver.findElement(UnitPrice).sendKeys(repo.getProperty("UnitPriceTxt"));
		 UP = repo.getProperty("UnitPriceTxt").toString();
			logger.info("Unit Price-->" +UP+" added");
		 driver.findElement(UnitPrice).sendKeys(Keys.TAB);
		 waitFor(2);
		 driver.findElement(OrderNoLink).click();
		 try{
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(OrderNoLinkPopUp));
			 wait.until(ExpectedConditions.presenceOfElementLocated(OpenOrders));
			 waitFor(2);
			 OpenOrdersTxt = driver.findElement(OpenOrders).getText().toString();
			 logger.info(OpenOrdersTxt+"--opened");
			 driver.findElement(By.xpath(".//*[@id='itemOpenOrdersGridView_cell0_0_OrderNumberButton_CD']")).click();
			 waitFor(5);
			 driver.switchTo().defaultContent(); 
		 }catch(Exception Ex){
			 logger.info("Order Page Popup not available");
		 }
		 driver.findElement(SaveDiskette).click();
		 logger.info("**Items added to the grid**");
		 waitFor(5);		 
	 }else{
		 logger.info("Item Order tab is not enabled");
	 }		
	}
	
	
	
	/*-----------------------------------------------------------------------------------------------*/
	
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

	public void NewPO_Cancel() throws Exception {
		NewPO();
		enterVendor();
		enterVendor_Contact();
		SelectOrder();
		SelectLicensee();
		ProjectName();		
	}
	
	public void CreateNewPO() throws Exception {
		NewPO();
		enterVendor();
		enterVendor_Contact();
		SelectOrder();
		SelectLicensee();
		ProjectName();	
		ItemsOrdered();
		saveclose();
	}
	
	
	
	

}
