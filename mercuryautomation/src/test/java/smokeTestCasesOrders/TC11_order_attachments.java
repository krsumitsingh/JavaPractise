package smokeTestCasesOrders;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pkgTestBase.TestBase;
import pageObjLibrary.OrdersPage;

public class TC11_order_attachments extends TestBase {
	
	public static final Logger logger = Logger.getLogger(TC11_order_attachments.class.getName());
	OrdersPage ord;
	
	@Test
	public void attachments() throws Exception{
		logger.info("****Start Executing TC11_order_attachments****");
		ord = new OrdersPage(driver);
		ord.addattachments();
		logger.info("****Successfully Executed TC11_order_attachments****");
}
}