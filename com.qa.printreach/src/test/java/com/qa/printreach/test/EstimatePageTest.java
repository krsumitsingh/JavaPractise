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
import com.qa.printreach.utilities.CommonMethods;

public class EstimatePageTest extends TestBase{
	
	LoginPage loginPage;
	EstimatesPage estimatePage;
	HomePage homePage;
	String expectedTxt = "Estimate Search",menuItemExpTxt = "Details";
	boolean flag;
	
	public EstimatePageTest() throws Exception{
		super();	
	}
	
	@BeforeMethod
	@Parameters({"username","password"})
	public void setup(String UN, String PWD) throws Throwable{
		TestBase.initialization();
		loginPage = new LoginPage();
		estimatePage = new EstimatesPage();
		homePage = loginPage.validateLogin(UN, PWD);	
		estimatePage = homePage.validateEstimateSearchPage();
	}
	
	
	@Test(priority=1, description="Estimate Search Text")
	public void validateEstimateSearchTxtTest(){
		flag = CommonMethods.verifyTextElement(EstimatesPage.estimateLabel, expectedTxt);
		assertTrue(flag, "Estimate Search Text not correct");	
	}
	
	@Test(priority=2, description="Create an estimate with customer")
	public void validateEstimateWithoutCustomerTest() throws Exception{
		estimatePage.validateEstimateWithoutCustomer(estimatePage.newEstimateBtn, estimatePage.saveCloseBtn);			
	}
	
	@Test(priority=3, description="Create an estimate without serivces")
	public void validateEstimateWithoutServicesTest() throws Exception{
		estimatePage.validateEstimateWithoutServices();	
	}
	
	@Test(priority=4, description="Create an estimate with services")
	public void validateEstimateWithServiceTest() throws Exception{	
		estimatePage.validateEstimateWithService(estimatePage.detailsTab, menuItemExpTxt);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}	
	
	
	

}
