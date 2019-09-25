package com.qa.shopfloor.test;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.shopfloor.base.SPTestBase;
import com.qa.shopfloor.pages.SPHomePage;
import com.qa.shopfloor.pages.SPLoginPage;
import com.qa.shopfloor.utilities.Utilities;

public class SPLoginPageTest extends SPTestBase{

	public static final Logger logger = Logger.getLogger(SPLoginPageTest.class.getName());
	SPLoginPage sploginpage;
	SPHomePage sphomepage;
	boolean flag;
	String sheetName = "LoginCredentials";
	
	
	public SPLoginPageTest() throws Exception {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception{
		SPTestBase.initialization();
		sploginpage = new SPLoginPage();		
	}
	
	
	@Test(priority=2)
	public void verifyLoginPageImageTest(){
		flag = sploginpage.verifyLoginPageImage();
		assertTrue(flag, "Image is not present");		
	}
	
	
	@DataProvider
	public Object[][] SPLoginData(){
		Object data[][] = Utilities.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="SPLoginData")
	public void LoginTest(String URL, String USERNAME, String PASSWORD) throws Exception{
		sphomepage = sploginpage.validateLogin(URL, USERNAME, PASSWORD);			
	}
	
	

}
