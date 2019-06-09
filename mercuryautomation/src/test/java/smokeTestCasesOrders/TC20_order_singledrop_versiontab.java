package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC20_order_singledrop_versiontab extends TestBase {
	
	
	OrdersPage ord;

	@Test
	public void singledrop_vertab() throws Exception{
		logger.info("****Start Executing TC20_order_singledrop_versiontab****");
		ord = new OrdersPage(driver);
		ord.singleDrop_VerTab();
		logger.info("****Successfully Executed TC20_order_singledrop_versiontab****");
	}

}
