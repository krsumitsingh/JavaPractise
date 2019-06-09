package testCases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pkgTestBase.TestBase;
import pageObjLibrary.EstimatesPage;

public class TC10_estimate_exportorder extends TestBase{
	public static final Logger logger = Logger.getLogger(TC10_estimate_exportorder.class.getName());
	EstimatesPage es;
	
	@Test
	public void OrderExport() throws Exception{
		logger.info("****Start Executing TC10_estimate_exportorder****");
		es = new EstimatesPage(driver);
		es.exportToOrder();
		logger.info("****Successfully Executed TC10_estimate_exportorder****");
	}
}
