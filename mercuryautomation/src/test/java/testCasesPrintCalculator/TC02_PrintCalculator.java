package testCasesPrintCalculator;

import org.testng.annotations.Test;

import pkgTestBase.TestBase;
import pageObjLibrary.printCalculator;


public class TC02_PrintCalculator extends TestBase {

	printCalculator pc;

	@Test
	public void createNewEstimate() throws Exception{
		logger.info("****Start Executing TC02_printcalculator ****");
		pc = new printCalculator(driver);
		pc.services();
	}

	@Test(dependsOnMethods = { "createNewEstimate" })
	public void printCalculatorAdd() throws Exception{
		pc.printCal();
	}

	/*@Test(dependsOnMethods = { "printCalculatorAdd" })
	public void printCalculatorLaunch() throws Exception{
		pc.printCalRelaunch();	
	}*/

	@Test(dependsOnMethods = { "printCalculatorAdd" })
	public void cutcost() throws Exception{
		pc.GetValue_Cut_Cost();
		logger.info("****Successfully Executed TC02_printcalculator ****");
	}

}
