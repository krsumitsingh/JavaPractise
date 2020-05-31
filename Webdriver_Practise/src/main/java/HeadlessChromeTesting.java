import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTesting {

	public static void main(String[] args) {
		//set the driver server exe path
				System.setProperty("webdriver.chrome.driver", "C:/Users/sumit.singh/Desktop/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				// set chrome as Headless
				options.addArguments("--headless");
				//Instantiate Chrome Driver
				WebDriver driver = new ChromeDriver(options);
				driver.get("https://www.google.com");
				// get the title of the page
				System.out.println("Page title is - " + driver.getTitle());
				// get the title of the url
				System.out.println("Current Url : "+ driver.getCurrentUrl());
				// find the element
				Dimension size = driver.findElement(By.name("q")).getSize();
				System.out.println("The dimension is: "+size);
				// close the browser
				driver.close();
				System.out.println("Test Completed");
	}

}
