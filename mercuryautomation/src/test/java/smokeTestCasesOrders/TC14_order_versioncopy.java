package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC14_order_versioncopy extends TestBase {
	
OrdersPage ord;
	
	@Test
	public void verTabCopy() throws Exception{
		logger.info("****Start Executing TC14_order_version copy ****");
		ord = new OrdersPage(driver);
		ord.versionCopy();
		logger.info("****Successfully Executed TC14_order_version copy ****");
}

}
