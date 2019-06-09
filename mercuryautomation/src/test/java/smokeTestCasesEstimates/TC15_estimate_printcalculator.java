package smokeTestCasesEstimates;

import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.EstimatesPage;

public class TC15_estimate_printcalculator extends TestBase {
	
	EstimatesPage es;
	
	@Test
	public void printCalculator() throws Exception{
		logger.info("****Start Executing TC15_estimate_printcalculator ****");
		es = new EstimatesPage(driver);
		es.printCal();
		logger.info("****Successfully Executed TC15_estimate_printcalculator ****");
}

}
