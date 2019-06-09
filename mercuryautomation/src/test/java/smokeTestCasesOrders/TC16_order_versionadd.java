package smokeTestCasesOrders;

import org.testng.annotations.Test;
import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC16_order_versionadd extends TestBase {

	OrdersPage ord;

	@Test
	public void verAdd() throws Exception{
		logger.info("****Start Executing TC16_order_version Add ****");
		ord = new OrdersPage(driver);
		ord.versionAdd();
		logger.info("****Successfully Executed TC16_order_version Add ****");
	}

}
