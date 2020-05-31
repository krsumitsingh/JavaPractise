import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * 
 */

/**
 * @author sumit.singh
 *
 */
public class SampleDataDrivenTestNg extends GetLoginTestdata {
	
	GetLoginTestdata login = new GetLoginTestdata();
	public WebDriver driver;
	public String url = "";
	String sheetName = "LoginDetails";
	
		
	@BeforeMethod
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\chromedriver.exe");
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("--disable-extensions");
		driver = new ChromeDriver(options1);
		driver.manage().window().maximize();
		url = "https://qa.vsmidnight.com/Logon.aspx";
		driver.get(url);	
	}
	
	
	@DataProvider
	public Object[][] getPRTestData(){
		Object data[][] = GetLoginTestdata.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1,dataProvider="getPRTestData")
	public void loginTest(String username, String password) throws Exception{
		System.out.println("Login page appeared");	
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".//*[@id='PnlLoginPage_loginControl_UserName']")).sendKeys(username);
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".//*[@id='PnlLoginPage_loginControl_Password']")).sendKeys(password);
		Thread.sleep(2000);	
		driver.findElement(By.xpath(".//*[@id='PnlLoginPage_loginControl_LoginButton_CD']/span")).click();
		System.out.println("Logging In...."+driver.getTitle() );	
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='ctl00_userLoginStatus']")).click();
		System.out.println("Logging Out...."+driver.getTitle() );	
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
