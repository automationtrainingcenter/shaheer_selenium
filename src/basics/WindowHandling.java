package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// now driver focus is in main page
		// locate open window button and click on it, so that it will open a new window
		
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(2000);
		
		// find out window ids opened driver instance using getWindowHandles()
		Set<String> windowHandles = driver.getWindowHandles();
		// convert above set type to list type so that we can easily switch in
		// between windows or tabs using index numbers
		/*
		 * in index number 0 we will have Parent window or main window
		 * index number 1 we will have first child window
		 * index number 2 we will have second child window
		 * ... etc
		 */
		List<String> windowIds = new ArrayList<>(windowHandles);
		/*
		 * switching the driver focus from one window to window using window(String windowID) 
		 * of TargetLocator interface, this interface is an inner interface
		 * webdriver interface and WebDriver contains switchTo() which returns
		 * TargetLocator interface reference
		 */
		// switch the driver focus to child window using index 1
		driver.switchTo().window(windowIds.get(1));
		
		// now driver focus is in child window
		// locate search course text field and type some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(2000);
		
		// switch driver focus from child window to parent window using index 0
		driver.switchTo().window(windowIds.get(0));
		
		// now driver focus is in main window or parent window
		// locate enter your name text filed and type some data
		driver.findElement(By.id("name")).sendKeys("selenium");
		Thread.sleep(2000);
		
		driver.quit();
		
	}
	

}
