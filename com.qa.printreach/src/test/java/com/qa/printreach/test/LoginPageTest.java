package com.qa.printreach.test;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.printreach.base.TestBase;
import com.qa.printreach.pages.HomePage;
import com.qa.printreach.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	String LoginPageTitle = "";
	boolean flag;
	public static final Logger logger = Logger.getLogger(LoginPageTest.class.getName());
	
	public LoginPageTest() throws Exception {
		super();		
	}

	@BeforeMethod
	public void setUp() throws Exception{
		TestBase.initialization();
		loginPage = new LoginPage();		
	}
	
	
	@Test(priority=1)
	public void validateLoginPageTitleTest(){
		LoginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(LoginPageTitle, "Midnight");		
	}
	
	@Test(priority=2)
	public void validateLoginPageImageTest(){
		flag = loginPage.validateLoginPageImage();
		assertTrue(flag, "Login Image does not exist");		
	}
	
	@Test(priority=3)
	@Parameters({"username","password"})
	public void validateLoginPageTest(String UN, String PWD) throws Exception{
		homePage = loginPage.validateLogin(UN, PWD);			
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	
}
