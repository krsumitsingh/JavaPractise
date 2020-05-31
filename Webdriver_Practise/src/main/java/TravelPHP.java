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


public class TravelPHP {
	public static void main(String[] args) throws IOException, Exception {
		
		String HeaderTabsName="";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Sumit\\SeleniumProjects\\NEWCHROMEDRIVER\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		// set time limit to find the element
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// Go to URL
		driver.get("http://www.phptravels.net/");
		// Take ScreenShot
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("C:\\Users\\sumit.singh\\Desktop\\pageScreenshot.png"), true);
        Thread.sleep(10);
        
        List<WebElement> allHeaderTabs = driver.findElements(By.xpath("//nav//div/ul[@class='nav navbar-nav go-right']//li"));
        System.out.println("The total count of header tabs is--"+allHeaderTabs.size());
        //List<WebElement> allHeaderTabs = driver.findElements(By.xpath("//nav//div/ul[@class='nav navbar-nav go-right']//li["+(j)+"]/a"));
        
        for(int j=1;j<allHeaderTabs.size();j++){
        	
        	if(allHeaderTabs.get(j).isDisplayed() && allHeaderTabs.get(j).isEnabled() ){
        		allHeaderTabs.get(j).click();
        	}
        	
        	
        	
        	 //driver.findElements(By.xpath("//nav//div/ul[@class='nav navbar-nav go-right']//li["+(j)+"]/a")).get(j).click();
        	//allHeaderTabs.get(j).click();
        	Thread.sleep(10);
        	HeaderTabsName = driver.findElement(By.xpath("//nav//div/ul[@class='nav navbar-nav go-right']//li["+(j)+"]/a")).getText().toString();
        	System.out.println("User has clicked on the--"+HeaderTabsName);
        	allHeaderTabs = driver.findElements(By.xpath("//nav//div/ul[@class='nav navbar-nav go-right']//li"));
        	
        }
        
        
		// Close Driver
		//driver.quit();
	
	}

}
