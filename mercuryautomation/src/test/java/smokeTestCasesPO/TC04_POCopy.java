package smokeTestCasesPO;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pageObjLibrary.PurchaseOrder;
import pkgTestBase.TestBase;


public class TC04_POCopy extends TestBase {
	
	PurchaseOrder PO;
	//static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TC04_POCopy.class.getName());	
	
	@Test
	public void CopyPO() throws Exception
	{
	
	PO = new PurchaseOrder(driver);
	logger.info("****Start Executing TC04_CopyPO****");
	PO.OpenPO();
	PO.CopyPO();
	logger.info("****Successfully Executed TC04_CopyPO****");
	}
	
	
	
	
	
	

}
