package smokeTestCasesOrders;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;


public class TC07_order_with_swfservices extends TestBase{
	public static final Logger logger = Logger.getLogger(TC07_order_with_swfservices.class.getName());
	OrdersPage ord;
	
	@Test
	public void addswf() throws Exception{
		logger.info("****Start Executing TC07_order_with_swfservices****");
		ord = new OrdersPage(driver);
		ord.swf();	
		logger.info("****Successfully Executed TC07_order_with_swfservices****");
	}

}
