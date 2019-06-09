package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.EstimatesPage;
import pkgTestBase.TestBase;


public class TC07_estimate_with_swfservices extends TestBase{
	public static final Logger logger = Logger.getLogger(TC07_estimate_with_swfservices.class.getName());
	EstimatesPage es;
	
	@Test
	public void addswf() throws Exception{
		logger.info("****Start Executing TC07_estimate_with_swfservices****");
		es = new EstimatesPage(driver);
		es.swf();	
		logger.info("****Successfully Executed TC07_estimate_with_swfservices****");
	}

}
