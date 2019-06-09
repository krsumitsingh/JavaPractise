package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.EstimatesPage;

public class TC14_estimate_multipleqty extends TestBase {
	
	public static final Logger logger = Logger.getLogger(TC14_estimate_multipleqty.class.getName());
	EstimatesPage es;
	
	@Test
	public void MQ() throws Exception{
		logger.info("****Start Executing TC14_estimate_multipleqty****");
		es = new EstimatesPage(driver);
		es.multipleQty();
		logger.info("****Successfully Executed TC14_estimate_multipleqty****");
}

}
