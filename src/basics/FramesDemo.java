package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// now driver focus is in main page
		// locate enter your name text field in the main page and type some data
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Thread.sleep(2000);

		// switch the driver focus from main page to frame which
		// contains search course text field
		/*
		 * switching the driver focus from main page to frame using frame(String id) of
		 * TargetLocator interface, this interface is an inner interface
		 * webdriver interface and WebDriver contains switchTo() which returns
		 * TargetLocator interface reference
		 */
//		TargetLocator tl = driver.switchTo();
//		tl.frame("courses-iframe");
//		driver.switchTo().frame("courses-iframe");
		
		
		// locating frame element in main page to switch to that frame
		WebElement frameToSwitch = driver.findElement(By.xpath("//iframe[@src='https://learn.letskodeit.com/courses']"));
		//switch to frame
		driver.switchTo().frame(frameToSwitch);
		
		// now driver focus is in frame
		// locate search course text field and type some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(2000);
		
		// now switch the driver focus from frame to main page using defaultContent() of
		// TartgetLocator interface
		driver.switchTo().defaultContent();
		
		// now driver focus is in main page
		// locate hide/show text field and type some data
		driver.findElement(By.id("displayed-text")).sendKeys("selenium");
		Thread.sleep(2000);
		
		
		driver.close();
	}

}
