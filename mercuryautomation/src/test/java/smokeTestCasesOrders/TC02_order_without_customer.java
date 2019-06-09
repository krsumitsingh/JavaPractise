package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;


public class TC02_order_without_customer extends TestBase {
	
	
	OrdersPage order;
	
	@Test
	public void orderwithoutcustomer() throws Exception{
		order = new OrdersPage(driver);
		logger.info("****Start Executing TC02_order_without_customer****");
		order.save_without_customer();		
		logger.info("****Successfully Executed TC02_order_without_customer****");
	}
}
