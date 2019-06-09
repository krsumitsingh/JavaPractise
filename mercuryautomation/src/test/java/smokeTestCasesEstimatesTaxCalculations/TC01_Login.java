package smokeTestCasesEstimatesTaxCalculations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjLibrary.SignIn;
import pkgTestBase.TestBase;

public class TC01_Login extends TestBase
{
	SignIn signIn;
	public static final Logger logger = Logger.getLogger(TC01_Login.class.getName());
	

	
	@BeforeClass
	public void setup() throws IOException	
	{
		init();
	}

	
	@Test
	public void login_page()
	{
	signIn = new SignIn(driver);
	logger.info("****Start Executing TC01_Login****");
	signIn.clickonSignIn();	
	logger.info("Successful logged into QA");	
	logger.info("****Successfully Executed TC01_Login****");
	}
	
	
}


