package smokeTestCasesPO;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.PurchaseOrder;
import pkgTestBase.Config_PO;
import pkgTestBase.TestBase;


public class TC08_ItemsOrdered extends TestBase {
	
	PurchaseOrder PO;
	//static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TC08_ItemsOrdered.class.getName());	
	
	@Test
	public void NewPO() throws Exception
	{	
	PO = new PurchaseOrder(driver);
	Config_PO config = new Config_PO();
	logger.info("****Start Executing TC08_ItemsOrdered****");
	PO.OpenPO();
	PO.AddItemOrderedNewRow();
	PO.save();
	logger.info("****Successfully Executed TC08_ItemsOrdered****");
	}
}
