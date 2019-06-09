package smokeTestCasesEstimates;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.EstimatesPage;
import pkgTestBase.TestBase;

public class TC09_estimate_contracttemplate extends TestBase {
	
	public static final Logger logger = Logger.getLogger(TC09_estimate_contracttemplate.class.getName());
	EstimatesPage es;
	
	@Test
	public void addcontractTemplate() throws Exception{
		logger.info("****Start Executing TC09_estimate_contracttemplate****");
		es = new EstimatesPage(driver);
		es.contractTemplate();
		logger.info("****Successfully Executed TC09_estimate_contracttemplate****");
	}

}
