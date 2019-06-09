package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pageObjLibrary.OrdersPage;
import pkgTestBase.TestBase;


public class TC05_order_taxcalculation extends TestBase {
	
	OrdersPage ord;
	
	@Test
	public void orderwithservice() throws Exception{
		ord = new OrdersPage(driver);
		logger.info("****Start Executing TC05_order_taxcalculation****");
		ord.tax_calculation();	
		logger.info("****Successfully Executed TC05_order_taxcalculation****");
	}
	
}

