import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TravelPHP_PhoneSorting {
	public static void main(String[] args) throws IOException, Exception {
		
		String HeaderTabsName="";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Sumit\\SeleniumProjects\\NEWCHROMEDRIVER\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		// set time limit to find the element
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Go to URL
		driver.get("http://live.guru99.com/index.php/mobile.html");
		// Take ScreenShot
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\sumit.singh\\Desktop\\pageScreenshot.png"), true);
        Thread.sleep(10);
        
        List<WebElement> mobile = driver.findElements(By.xpath(".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li"));
        System.out.println("The total count of header tabs is--"+mobile.size());
        //List<WebElement> allHeaderTabs = driver.findElements(By.xpath("//nav//div/ul[@class='nav navbar-nav go-right']//li["+(j)+"]/a"));
        
        for(int j=1;j<=mobile.size();j++){
        	
        	 //driver.findElements(By.xpath("//nav//div/ul[@class='nav navbar-nav go-right']//li["+(j)+"]/a")).get(j).click();
        	mobile.get(j).click();
        	Thread.sleep(10);
        	/*HeaderTabsName = driver.findElement(By.xpath("//nav//div/ul[@class='nav navbar-nav go-right']//li["+(j)+"]/a")).getText().toString();
        	System.out.println("User has clicked on the--"+HeaderTabsName);*/
        }
		// Close Driver
		//driver.quit();
	
	}

}
