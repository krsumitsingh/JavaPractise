package smokeTestCasesEstimates;

import org.testng.annotations.Test;

import pageObjLibrary.EstimatesPage;
import pkgTestBase.TestBase;


public class TC05_estimate_taxcalculation extends TestBase {
	
	EstimatesPage es;
	
	@Test
	public void estimatewithservice() throws Exception{
		es = new EstimatesPage(driver);
		logger.info("****Start Executing TC05_estimate_taxcalculation****");
		es.tax_calculation();	
		logger.info("****Successfully Executed TC05_estimate_taxcalculation****");
	}
	
}

