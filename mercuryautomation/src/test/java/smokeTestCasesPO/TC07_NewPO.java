package smokeTestCasesPO;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import pageObjLibrary.PurchaseOrder;
import pkgTestBase.Config_PO;
import pkgTestBase.TestBase;


public class TC07_NewPO extends TestBase {
	
	PurchaseOrder PO;
	//static WebDriver driver;
	public static final Logger logger = Logger.getLogger(TC07_NewPO.class.getName());	
	
	@Test
	public void NewPO() throws Exception
	{	
	PO = new PurchaseOrder(driver);
	Config_PO config = new Config_PO();
	logger.info("****Start Executing TC07_NewPO****");
	PO.CreateNewPO(config.getItemDropDown(), config.getQuantity(), config.getMarkUpTxt(), config.getUnitPriceTxt());
	logger.info("****Successfully Executed TC07_NewPO****");
	}
}