package smokeTestCasesEstimates;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.EstimatesPage;
import pkgTestBase.TestBase;

public class TC08_estimate_with_awfservices extends TestBase{
	
	public static final Logger logger = Logger.getLogger(TC08_estimate_with_awfservices.class.getName());
	EstimatesPage es;
	
	@Test
	public void addawf() throws Exception{
		logger.info("****Start Executing TC08_estimate_with_awfservices****");
		es = new EstimatesPage(driver);
		es.awf();
		logger.info("****Successfully Executed TC08_estimate_with_awfservices****");
	}

}
