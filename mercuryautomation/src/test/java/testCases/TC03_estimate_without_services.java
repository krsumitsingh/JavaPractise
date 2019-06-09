package testCases;

import org.testng.annotations.Test;

import pageObjLibrary.EstimatesPage;
import pkgTestBase.TestBase;


public class TC03_estimate_without_services extends TestBase {
	
	EstimatesPage es;
	
	@Test
	public void estimatewithoutcservices() throws Exception{
		es = new EstimatesPage(driver);
		logger.info("****Start Executing TC03_estimate_without_services****");
		es.estimate_without_services();	
		logger.info("****Successfully Executed TC03_estimate_without_services****");
	}

}
