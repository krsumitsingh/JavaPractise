package smokeTestCasesPO;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pageObjLibrary.PurchaseOrder;
import pkgTestBase.TestBase;


public class TC03_POOpen extends TestBase {
	
	PurchaseOrder PO;
	//static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TC03_POOpen.class.getName());	
	
	@Test
	public void OpenPO() throws Exception
	{
	
	PO = new PurchaseOrder(driver);
	logger.info("****Start Executing TC03_POFilter****");
	PO.OpenPO();
	//logger.info("PO# Record opened");	
	PO.saveclose();
	logger.info("****Successfully Executed TC03_POFilter****");
	}
	
	
	
	
	
	

}
