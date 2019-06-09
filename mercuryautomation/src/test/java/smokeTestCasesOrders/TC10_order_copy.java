package smokeTestCasesOrders;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.OrdersPage;

public class TC10_order_copy extends TestBase {
	public static final Logger logger = Logger.getLogger(TC10_order_copy.class.getName());
	OrdersPage ord;
	
	@Test
	public void orderCopy() throws Exception{
		logger.info("****Start Executing TC10_order_copy****");
		ord = new OrdersPage(driver);
		ord.copyOrder();
		logger.info("****Successfully Executed TC10_order_copy****");
	}
}
