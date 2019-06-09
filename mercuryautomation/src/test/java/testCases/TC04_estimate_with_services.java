package testCases;

import org.testng.annotations.Test;

import pageObjLibrary.EstimatesPage;
import pkgTestBase.TestBase;


public class TC04_estimate_with_services extends TestBase {
	
	EstimatesPage es;
	
	@Test
	public void estimatewithservice() throws Exception{
		es = new EstimatesPage(driver);
		logger.info("****Start Executing TC04_estimate_with_services****");
		es.estimate_with_services();	
		logger.info("****Successfully Executed TC04_estimate_with_services****");
		
	}
}
