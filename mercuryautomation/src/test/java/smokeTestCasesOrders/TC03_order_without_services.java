package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;


public class TC03_order_without_services extends TestBase {
	
	OrdersPage order;
	
	@Test
	public void orderwithoutcservices() throws Exception{
		order = new OrdersPage(driver);
		logger.info("****Start Executing TC03_order_without_services****");
		order.order_without_services();	
		logger.info("****Successfully Executed TC03_order_without_services****");
	}

}
