package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.EstimatesPage;
public class TC12_estimate_attachments extends TestBase {
	
	public static final Logger logger = Logger.getLogger(TC12_estimate_attachments.class.getName());
	EstimatesPage es;
	
	@Test
	public void attachments() throws Exception{
		logger.info("****Start Executing TC12_estimate_attachments****");
		es = new EstimatesPage(driver);
		es.addattachments();
		logger.info("****Successfully Executed TC12_estimate_attachments****");
}
}