package pkgTestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class TestBase 
{
	
	public static final Logger logger = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	LocalTime startTime;
	LocalTime endTime;
	ExtentReports extent;
	protected ExtentTest test;
	boolean taxjuris = false;
	
	/*Autoit Fileupload.exe path*/
	public static String projectPath =
			System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\FileUpload.exe";
	
	public static Properties repo= new Properties();
	
	/*
	 * This method will activate and load prop files+browser
	 */
	public void init() throws IOException 
	{	
		loadPropertiesFile();
		selectBrowser(repo.getProperty("browser"));
		driver.get(repo.getProperty("url"));	
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		waitForPageToLoad();
	}
	
/*	public void startReport(){	
		extent = new ExtentReports(System.getProperty("user.dir")+ "/src/test/java/reports/Regression_Results.html",true);
		extent.addSystemInfo("User Name", "Sumit Singh");
		extent.addSystemInfo("Environment", "QA");
		extent.loadConfig(new File(System.getProperty("user.dir")+ "/src/test/java/config/extent-config.xml"));
	}
	
	public void reportPass(){
		test = extent.startTest("Pass Result");
		test.log(LogStatus.PASS, "This Test Case Is Passed");
	}
	
	public void reportFail(){
		test = extent.startTest("Failed Result");
		test.log(LogStatus.FAIL, "This Test Case Is Failed");
	}
	
	public void endReport(){
		extent.flush();
		extent.close();
	}*/
	
	
	
	/*
	 * This will load the config property file
	 */	
	public void loadPropertiesFile() throws IOException 
	{
		String log4jConfigPath = System.getProperty("user.dir")+"/src/test/java/log4j/log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
		
		File f = new File(System.getProperty("user.dir") +"\\src\\test\\java\\config\\config.properties");
		FileInputStream FIS = new FileInputStream(f);
		repo.load(FIS);
		logger.info("***Config Property File Loaded:***");
		
		File f1 = new File(System.getProperty("user.dir") +"\\src\\test\\java\\config\\estimate.properties");
		FileInputStream FIS1 = new FileInputStream(f1);
		repo.load(FIS1);
		logger.info("***Estimate Property File Loaded:***");
		
		File f2 = new File(System.getProperty("user.dir") +"\\src\\test\\java\\config\\contracttemplate.properties");
		FileInputStream FIS2 = new FileInputStream(f2);
		repo.load(FIS2);
		logger.info("***Contract Template Property File Loaded:***");		
		
		File f3 = new File(System.getProperty("user.dir") +"\\src\\test\\java\\config\\mq.properties");
		FileInputStream FIS3 = new FileInputStream(f3);
		repo.load(FIS3);
		logger.info("***MQ Property File Loaded:***");		
		
		File f4 = new File(System.getProperty("user.dir") +"\\src\\test\\java\\config\\printcalculator.properties");
		FileInputStream FIS4 = new FileInputStream(f4);
		repo.load(FIS4);
		logger.info("***Print Calculator Property File Loaded:***");
		
		File f5 = new File(System.getProperty("user.dir") +"\\src\\test\\java\\config\\estimatetaxesusecases.properties");
		FileInputStream FIS5 = new FileInputStream(f5);
		repo.load(FIS5);
		logger.info("***Estimate Taxes Calculations Property File Loaded:***");	
		
		File f6 = new File(System.getProperty("user.dir") +"\\src\\test\\java\\config\\order.properties");
		FileInputStream FIS6 = new FileInputStream(f6);
		repo.load(FIS6);
		logger.info("***Orders Property File Loaded:***");	
		
		File f7 = new File(System.getProperty("user.dir") +"\\src\\test\\java\\config\\purchaseorder.properties");
		FileInputStream FIS7 = new FileInputStream(f7);
		repo.load(FIS7);
		logger.info("***Purchase Orders Property File Loaded:***");	
	}
	
	/*
	 * This method will match the browser type defined in the config file 
	 */	
	public void selectBrowser(String browser)
	{
		if(System.getProperty("os.name").contains("Window"))
		{
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", ("user.dir")+"/browserDrivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\browserDrivers\\chromedriver.exe");
				ChromeOptions options1 = new ChromeOptions();
				options1.addArguments("--disable-extensions");
				driver = new ChromeDriver(options1);
				driver.manage().window().maximize();					
			}
		}
		else if(repo.getProperty("os_name").contains("Mac"))
		{
			System.out.println(System.getProperty("os.name"));
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir")+"/browserDrivers/geckodriver");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/browserDrivers/chromedriver");
				driver = new ChromeDriver();
			}
		}
		
	}
	
	public void waitFor(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
}
	
	public void waitForPageToLoad(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	//for accepting alert
	public void alert_accept(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		//System.out.println("Message in Alert Popup..." + alert.getText());
		logger.info("Message in Alert Popup..." + alert.getText());
		alert.accept();
		logger.info("OK button pressed on the Message alert");
	}
	
	//For cancelling alert
	public void alert_dismiss(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		//System.out.println("Message in Alert Popup..." + alert.getText());
		logger.info("Message in Alert Popup..." + alert.getText());
		alert.dismiss();
		logger.info("Cancel button pressed on the Message alert");
	}
	
	
	
}
	
	
	




	
	
	

