package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.EstimatesPage;

public class TC11_estimate_copy extends TestBase {
	public static final Logger logger = Logger.getLogger(TC11_estimate_copy.class.getName());
	EstimatesPage es;
	
	@Test
	public void estimateCopy() throws Exception{
		logger.info("****Start Executing TC11_estimate_copy****");
		es = new EstimatesPage(driver);
		es.copyEstimate();
		logger.info("****Successfully Executed TC11_estimate_copy****");
	}
}
