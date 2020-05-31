package com.qa.printreach;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class PrintReachLogin {
	
	private static final Logger logger = Logger
			.getLogger(PrintReachLogin.class.getName());
	public static WebDriver driver;
	String username = "vsuser";
	
	@Test(priority=1)
	public void OpenBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\chromedriver.exe");
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("--disable-extensions");
		driver = new ChromeDriver(options1);
		driver.manage().window().maximize();
		logger.info("Browser Opened");
		driver.get("http://qa.vsmidnight.com");
		
	}
	
	@Test(priority=2)
	@Parameters({"username","password"})
	public void login(String uid, String Pwd){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("PnlLoginPage_loginControl_UserName"))
				.sendKeys(uid);
		driver.findElement(By.id("PnlLoginPage_loginControl_Password"))
				.sendKeys(Pwd);
		driver.findElement(By.id("PnlLoginPage_loginControl_LoginButton"))
				.click();
		logger.info("Logging In...");
		
	}
	

}
