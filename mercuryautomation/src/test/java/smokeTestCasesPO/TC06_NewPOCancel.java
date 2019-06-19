package smokeTestCasesPO;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.PurchaseOrder;
import pkgTestBase.Config_PO;
import pkgTestBase.TestBase;


public class TC06_NewPOCancel extends TestBase {
	
	PurchaseOrder PO;
	//static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TC06_NewPOCancel.class.getName());	
	
	@Test
	public void CancelPO() throws Exception
	{	
	PO = new PurchaseOrder(driver);
	Config_PO config = new Config_PO();
	logger.info("****Start Executing TC06_CancelNewPO****");
	PO.NewPO_Cancel(config.getVendorName(), config.getvendorcontact(),config.getSelectOrderBy(),config.getSelectLicensee(),config.getProjectName());
	logger.info("****Successfully Executed TC06_CancelNewPO****");
	}
	
	
	
	
	
	

}
