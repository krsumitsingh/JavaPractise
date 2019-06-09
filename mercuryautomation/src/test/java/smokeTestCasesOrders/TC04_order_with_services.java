package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;


public class TC04_order_with_services extends TestBase {
	
	OrdersPage ord;
	
	@Test
	public void orderwithservice() throws Exception{
		ord = new OrdersPage(driver);
		logger.info("****Start Executing TC04_order_with_services****");
		ord.order_with_services();	
		logger.info("****Successfully Executed TC04_order_with_services****");
		
	}
}
