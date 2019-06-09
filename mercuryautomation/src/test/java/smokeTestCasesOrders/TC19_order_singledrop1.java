package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;



public class TC19_order_singledrop1 extends TestBase{
	
	OrdersPage ord;

	@Test
	public void singledrop1() throws Exception{
		logger.info("****Start Executing TC19_order_singledrop1****");
		ord = new OrdersPage(driver);
		ord.singleDrop1();
		logger.info("****Successfully Executed TC19_order_singledrop1****");
	}
	
	

}
