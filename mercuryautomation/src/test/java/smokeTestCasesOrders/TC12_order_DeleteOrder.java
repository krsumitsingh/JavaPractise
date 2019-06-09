package smokeTestCasesOrders;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.OrdersPage;

public class TC12_order_DeleteOrder extends TestBase {
	public static final Logger logger = Logger.getLogger(TC12_order_DeleteOrder.class.getName());
	OrdersPage ord;
	
	@Test
	public void estimateDeletion() throws Exception{
		logger.info("****Start Executing TC12_Order Deletion****");
		ord = new OrdersPage(driver);
		ord.deleteOrder();
		logger.info("****Successfully Executed TC12_Order Deletion****");
}
	

}
