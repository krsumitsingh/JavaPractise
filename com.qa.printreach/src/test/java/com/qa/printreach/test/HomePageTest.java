package com.qa.printreach.test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.printreach.base.TestBase;
import com.qa.printreach.pages.EstimatesPage;
import com.qa.printreach.pages.HomePage;
import com.qa.printreach.pages.LoginPage;


public class HomePageTest extends TestBase {

	HomePage homePage;
	EstimatesPage estimatePage;
	LoginPage loginPage;
	
	
	public HomePageTest() throws Exception {
		super();		
	}
    
	@BeforeMethod
	@Parameters({"username","password"})
	public void setup(String UN, String PWD) throws Throwable{
		TestBase.initialization();
		loginPage = new LoginPage();
		estimatePage = new EstimatesPage();
		homePage = loginPage.validateLogin(UN, PWD);		
	}
	
	@Test(priority=1)
	public void validateDashboardImageTest(){
		boolean flag = homePage.validateDashboardImage();
		assertTrue(flag, "Image not diaplayed");		
	}
	
	@Test(priority=2)
	public void validateEstimateSearchPageTest() throws Throwable{
		estimatePage = homePage.validateEstimateSearchPage();
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	
	
}
