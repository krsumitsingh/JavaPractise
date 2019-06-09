package testCases;

import org.testng.annotations.Test;

import pageObjLibrary.EstimatesPage;
import pkgTestBase.TestBase;


public class TC06_estimate_with_wizardservices extends TestBase{
EstimatesPage es;
	
	@Test
	public void addWizardService() throws Exception{
		logger.info("****Start Executing TC06_estimate_with_wizardservices****");
		es = new EstimatesPage(driver);
		es.add_wizard();	
		logger.info("****Successfully Executed TC06_estimate_with_wizardservices****");
	}

}
