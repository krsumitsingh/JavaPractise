package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC22_order_deletedrop extends TestBase{
	OrdersPage ord;

	@Test
	public void deletedrop() throws Exception{
		logger.info("****Start Executing TC22_order_deletedrop****");
		ord = new OrdersPage(driver);
		ord.DropDelete();
		logger.info("****Successfully Executed TC22_order_deletedrop****");
	}
	
}
