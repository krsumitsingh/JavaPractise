package testCases;

import org.testng.annotations.Test;

import pageObjLibrary.EstimatesPage;
import pkgTestBase.TestBase;


public class TC02_estimate_without_customer extends TestBase {
	
	
	EstimatesPage es;
	
	@Test
	public void estimatewithoutcustomer() throws Exception{
		es = new EstimatesPage(driver);
		logger.info("****Start Executing TC02_estimate_without_customer****");
		es.save_without_customer();		
		logger.info("****Successfully Executed TC02_estimate_without_customer****");
	}
}
