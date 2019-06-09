package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC21_order_multipledrop extends TestBase{
	OrdersPage ord;

	@Test
	public void MultipleDropsSingleVersion() throws Exception{
		logger.info("****Start Executing TC21_order_multipledrop****");
		ord = new OrdersPage(driver);
		ord.MultipleDrops();
		logger.info("****Successfully Executed TC21_order_multipledrop****");
	}
	
	
	
}
