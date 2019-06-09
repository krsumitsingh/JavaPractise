package smokeTestCasesOrders;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC08_order_with_awfservices extends TestBase{
	
	public static final Logger logger = Logger.getLogger(TC08_order_with_awfservices.class.getName());
	OrdersPage ord;
	
	@Test
	public void addawf() throws Exception{
		logger.info("****Start Executing TC08_order_with_awfservices****");
		ord = new OrdersPage(driver);
		ord.awf();
		logger.info("****Successfully Executed TC08_order_with_awfservices****");
	}

}
