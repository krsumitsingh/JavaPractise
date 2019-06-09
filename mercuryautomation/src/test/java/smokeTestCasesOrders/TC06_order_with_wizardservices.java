package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;


public class TC06_order_with_wizardservices extends TestBase{
OrdersPage ord;
	
	@Test
	public void addWizardService() throws Exception{
		logger.info("****Start Executing TC06_order_with_wizardservices****");
		ord = new OrdersPage(driver);
		ord.add_wizard();	
		logger.info("****Successfully Executed TC06_order_with_wizardservices****");
	}

}
