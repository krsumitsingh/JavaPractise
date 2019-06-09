package smokeTestCasesOrders;

import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.OrdersPage;

public class TC13_order_printcalculator extends TestBase {
	
	OrdersPage ord;
	
	@Test
	public void printCalculator() throws Exception{
		logger.info("****Start Executing TC13_order_printcalculator ****");
		ord = new OrdersPage(driver);
		ord.printCal();
		logger.info("****Successfully Executed TC13_order_printcalculator ****");
}

}
