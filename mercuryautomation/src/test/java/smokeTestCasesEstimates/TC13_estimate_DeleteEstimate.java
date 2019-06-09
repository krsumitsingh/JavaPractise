package smokeTestCasesEstimates;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.EstimatesPage;

public class TC13_estimate_DeleteEstimate extends TestBase {
	public static final Logger logger = Logger.getLogger(TC13_estimate_DeleteEstimate.class.getName());
	EstimatesPage es;
	
	@Test
	public void estimateDeletion() throws Exception{
		logger.info("****Start Executing TC13_Estimate Deletion****");
		es = new EstimatesPage(driver);
		es.deleteEstimate();
		logger.info("****Successfully Executed TC13_Estimate Deletion****");
}
	

}
