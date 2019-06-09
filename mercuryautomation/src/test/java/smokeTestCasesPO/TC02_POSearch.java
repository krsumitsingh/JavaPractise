package smokeTestCasesPO;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pageObjLibrary.PurchaseOrder;
import pkgTestBase.TestBase;

public class TC02_POSearch extends TestBase
{
	PurchaseOrder PO;
	public static final Logger logger = Logger.getLogger(TC02_POSearch.class.getName());	
	
	@Test
	public void POSearchScreen() throws Exception
	{
	PO = new PurchaseOrder(driver);
	logger.info("****Start Executing TC02_PO Search Screen****");
	PO.POSearchScreen();
	logger.info("PO Search Screen Opened");	
	logger.info("****Successfully Executed TC02_PO Search Screen****");
	}
}


