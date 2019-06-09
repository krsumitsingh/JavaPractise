package smokeTestCasesOrders;

import org.testng.annotations.Test;
import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC17_order_versiondelete extends TestBase {

	OrdersPage ord;

	@Test
	public void verAdd() throws Exception{
		logger.info("****Start Executing TC17_order_version Delete ****");
		ord = new OrdersPage(driver);
		ord.versionDelete();
		logger.info("****Successfully Executed TC17_order_version Delete ****");
	}
	
	
	
}
