package smokeTestCasesOrders;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;

public class TC09_order_contracttemplate extends TestBase {
	
	public static final Logger logger = Logger.getLogger(TC09_order_contracttemplate.class.getName());
	OrdersPage ord;
	
	@Test
	public void addcontractTemplate() throws Exception{
		logger.info("****Start Executing TC09_order_contracttemplate****");
		ord = new OrdersPage(driver);
		ord.contractTemplate();
		logger.info("****Successfully Executed TC09_order_contracttemplate****");
	}

}
