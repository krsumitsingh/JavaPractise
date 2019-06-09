package smokeTestCasesEstimatesTaxCalculations;
import org.testng.annotations.Test;

import pageObjLibrary.EstimateTaxesCalculations;
import pkgTestBase.TestBase;

public class estimate_misctaxescalculations extends TestBase {



	EstimateTaxesCalculations etc;

	@Test
	public void estimate_taxes() throws Exception{	
		logger.info("****Logging****");
		etc = new EstimateTaxesCalculations(driver);
		etc.addWizardService();
	}

	@Test (dependsOnMethods = { "estimate_taxes" })
	//@Test(enabled = false)
	public void estimate_taxes_wizard() throws Exception{	
		logger.info("****Start excecuting #Test Case02 - Wizard Service taxable and Customer taxable****");
		etc.TC02_taxable_wizard_customer();
		logger.info("****Finished excecuting #Test Case02 - Wizard Service taxable and Customer taxable****");

	}

	@Test (dependsOnMethods = { "estimate_taxes_wizard" })
	//@Test(enabled = false)
	public void estimate_NoAction() throws Exception{
		logger.info("****Start excecuting #Test Case03 - No Action Service non-taxable and Customer taxable****");
		etc.TC03_noAction_Tax_Customer();
		logger.info("****Finished excecuting #Test Case03 - No Action Service non-taxable and Customer taxable****");	
	}

	@Test (dependsOnMethods = { "estimate_NoAction" })
	//@Test(enabled = false)
	public void estimate_TC05() throws Exception{
		logger.info("****Start excecuting #Test Case05 - No Action Service non-taxable and Customer non-taxable****");
		etc.TC05_noAction_Customer_nontaxable();
		logger.info("****Finished excecuting #Test Case05 -No Action Service non-taxable and Customer non-taxable****");	
	}

	@Test (dependsOnMethods = { "estimate_TC05" })
	//@Test(enabled = false)
	public void estimate_TC06() throws Exception{
		logger.info("****Start excecuting #Test Case06 - Making customer taxable again****");
		etc.TC06_taxJusrisdictionTaxable();
		logger.info("****Finished excecuting #Test Case06 - Making customer taxable again****");	
	}


	@Test (dependsOnMethods = { "estimate_TC06" })
	//@Test(enabled = false)
	public void estimate_TC04() throws Exception{
		logger.info("****Start excecuting #Test Case04- nontaxable customer and no action service****");
		etc.TC04();
		logger.info("****Finished excecuting #Test Case04- nontaxable customer and no action service****");	
	}


	@Test (dependsOnMethods = { "estimate_TC04" })	
	//@Test(enabled = false)
	public void estimate_TC07() throws Exception{
		logger.info("****Start excecuting #Test Case07- service(nolaunch)taxable and customer is not taxable****");
		etc.TC07();
		logger.info("****Finished excecuting #Test Case07- service(nolaunch)taxable and customer is not taxable****");	
	}


	@Test (dependsOnMethods = { "estimate_TC07" })	
	//@Test(enabled = false)
	public void estimate_TC08() throws Exception{
		logger.info("****Start excecuting #Test Case08- Making non-taxable customer as taxable and non-taxable service taxable****");
		etc.TC08();
		logger.info("****Finished excecuting #Test Case08- Making non-taxable customer as taxable and non-taxable service taxable****");	
	}

	@Test (dependsOnMethods = { "estimate_TC08" })	
	//@Test
	public void estimate_TC09() throws Exception{
		logger.info("****Start excecuting #Test Case09-Customer taxable with nontaxable wizard service****");
		etc.TC09();
		logger.info("****Finished excecuting #Test Case09-Customer taxable with nontaxable wizard service****");	
	}

	@Test (dependsOnMethods = { "estimate_TC09" })	
	public void estimate_TC10() throws Exception{
		logger.info("****Start excecuting #Test Case10-customer non-taxable with taxable wizard service****");
		etc.TC10();
		logger.info("****Finished excecuting #Test Case10-customer non-taxable with taxable wizard service****");	
	}


}




