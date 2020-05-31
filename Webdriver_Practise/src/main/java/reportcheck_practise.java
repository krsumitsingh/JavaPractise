

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sumit.singh
 *
 */
public class reportcheck_practise {
	
	private static final Logger logger=Logger.getLogger(reportcheck_practise.class.getName());	

	/**
	 * @param args
	 */
	static String text = "";
	static String text1= "";
	public static WebDriver driver;
	static String reportId= "";
	static String url = "";
	static LocalTime startTime;
	static LocalTime endTime;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		loadlog4j();
		OpenBrowser();
		login_page();
		open_rpts();
		endtime();
	}

	public static void loadlog4j(){
		
		String log4jConfigPath = System.getProperty("user.dir")+"/src/main/java/Reports_log4j.properties";
		//String log4jConfigPath = System.getProperty("user.dir")+"/log4j.properties";
		PropertyConfigurator.configure(log4jConfigPath);
		
	}
	
	public static void OpenBrowser() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\VSQA\\Midnight\\Virtual Systems -Mercury Automation\\Mercury Automation\\Webdriver_Practise\\src\\main\\java\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options1 = new ChromeOptions();
		options1.addArguments("--disable-extensions");
		driver = new ChromeDriver(options1);
		driver.manage().window().maximize();
		url = "https://qa.vsmidnight.com/Logon.aspx";
		driver.get(url);
	}

	public static void login_page()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("PnlLoginPage_loginControl_UserName")).sendKeys("vsuser");
		driver.findElement(By.id("PnlLoginPage_loginControl_Password")).sendKeys("Govirtual~1");
		driver.findElement(By.id("PnlLoginPage_loginControl_LoginButton")).click();
		
		//System.out.println("Logging in....");	
		logger.info("Logging In..."+url);
		driver.findElement(By.xpath(".//img[@id='ctl00_reportsView']")).click();		
		//System.out.println("Midnight Report page opened successfully");
		logger.info("Midnight Report page opened successfully");
		startTime = LocalTime.now();
		logger.info("Start Time Is--" + startTime);
	}
	
	
	public static void open_rpts() throws InterruptedException
	{
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    //System.out.println(driver.getCurrentUrl());
	   // logger.info(driver.getCurrentUrl());
	    WebDriverWait wait = new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.presenceOfElementLocated(
			       By.xpath("html/body/form/table/tbody/tr[1]/td[1]")));
	    List<WebElement> allparent_Rpt = driver.findElements(By.xpath("//div[@id='TreeView1']/table/tbody/tr/td/a"));
	    
	    //System.out.println("Currently Testing on::::" + driver.getCurrentUrl());
		logger.info("Currently Testing on::::" + driver.getCurrentUrl());
	    
		//System.out.println("Parent Reports Count:-----"+allparent_Rpt.size());
		logger.info("Parent Reports Count:-----"+allparent_Rpt.size());
		
			//Clicking on parent reports
		   for(int i=0;i<allparent_Rpt.size(); i++)  
		    {
			   Thread.sleep(3000);
			   allparent_Rpt.get(i).click();
			   
			   //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='TreeView1']/table/tbody/tr/td/a")));
			   List<WebElement> allchild_Rpt = driver.findElements(By.xpath("//div[starts-with(@id,'TreeView1')]/div["+(i+1)+"]/table"));
			 
			   text = driver.findElement(By.xpath("//div[@id='TreeView1']/table["+(i+1)+"]//span")).getText();
			   //System.out.println((i+1)+")"+text+" has "+allchild_Rpt.size()+" child items.");
			   logger.info((i+1)+")"+text+" has "+allchild_Rpt.size()+" child items.");
			   
			   //Clicking on child Reports
			   for(int j=0;j<allchild_Rpt.size(); j++){
				   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[starts-with(@id,'TreeView1')]/div["+(i+1)+"]/table")));
				   String abc = driver.findElements(By.xpath("//div[starts-with(@id,'TreeView1')]/div["+(i+1)+"]/table")).get(j).getText();
				   //System.out.println("Child report : "+(j+1)+")"+"Now checking : "+abc+"...");   
				   logger.info("Child report : "+(j+1)+")"+"Now checking : "+abc+"...");
		    		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[starts-with(@id,'TreeView1')]/div["+(i+1)+"]/table//a/img")));
		    		if (allchild_Rpt.get(j).isDisplayed() && allchild_Rpt.get(j).isEnabled()) 
					{
		    			allchild_Rpt.get(j).click();
					}	
		    		
		    		try{
			    		if(driver.findElement(By.cssSelector("div.divLeftBig")).getText().equals("Error has Occurred."))
			    		{
			    			driver.navigate().back();
			    			allparent_Rpt.get(i).click();
			    			continue;
			    		}} catch(Exception e)
			    		{
			    			//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ReportViewerMobile_MainPanel")));
			    			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("StiWebViewer1ReportPanel")));
							allchild_Rpt.clear();
							allchild_Rpt= driver.findElements(By.xpath("//div[starts-with(@id,'TreeView1')]/div["+(i+1)+"]/table//a/img"));
							//System.out.println("Finished checking : "+abc+"...");
							logger.info("Finished checking : "+abc+"...");
							
			    		} 
				
			   }
				allparent_Rpt = driver.findElements(By.xpath("//div[@id='TreeView1']/table/tbody/tr/td/a"));
				//System.out.println("******************+++++++*******************");
				logger.info("******************+++++++*******************");
		    }
	}
	public static void endtime(){
		endTime = LocalTime.now();
		logger.info("End Time Is--" + endTime);
	}
	
}




