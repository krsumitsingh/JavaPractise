package smokeTestCasesOrders;

import org.testng.annotations.Test;
import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC15_order_versionedit extends TestBase {

	OrdersPage ord;

	@Test
	public void verTabEdit() throws Exception{
		logger.info("****Start Executing TC15_order_version Edit ****");
		ord = new OrdersPage(driver);
		ord.versionEdit();
		logger.info("****Successfully Executed TC15_order_version Edit ****");
	}

}
