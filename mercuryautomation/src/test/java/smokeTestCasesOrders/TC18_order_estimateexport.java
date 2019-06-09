package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC18_order_estimateexport extends TestBase {
	
	OrdersPage ord;

	@Test
	public void estimateExport() throws Exception{
		logger.info("****Start Executing TC18_order_estimate export****");
		ord = new OrdersPage(driver);
		ord.exportEstimate();
		logger.info("****Successfully Executed TC18_order_estimate export****");
	}

}
