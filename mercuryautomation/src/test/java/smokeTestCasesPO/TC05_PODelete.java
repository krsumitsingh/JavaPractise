package smokeTestCasesPO;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pageObjLibrary.PurchaseOrder;
import pkgTestBase.TestBase;


public class TC05_PODelete extends TestBase {
	
	PurchaseOrder PO;
	//static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TC05_PODelete.class.getName());	
	
	@Test
	public void PODeletion() throws Exception
	{
	
	PO = new PurchaseOrder(driver);
	logger.info("****Start Executing TC05_DeletePO****");
	//PO.OpenPO();
	PO.DeletePO();
	logger.info("****Successfully Executed TC05_DeletePO****");
	}
	
	
	
	
	
	

}
