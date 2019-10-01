package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/SSTS/shaheer/selenium_concepts/frames/framesDemo.html");
		driver.manage().window().maximize();

		// now focus is in main window
		// locate open windows button and click on it, it will open multiple windows
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(5000);

		// now it opened multiple windows
		// get all the window ids which are opened by driver instance using
		// getWindowHandles() of
		// WebDriver interface. this method returns a Set<String> values
		Set<String> windowHandles = driver.getWindowHandles();
		// convert that set to list
		List<String> windowIDs = new ArrayList<>(windowHandles);

//		for (int i = 0; i < windowIDs.size(); i++) {
//			driver.switchTo().window(windowIDs.get(i));
//			System.out.println("at index "+i+" window title is "+driver.getTitle());
//		}
		
		// automate google page
		// now driver focus is in main window to switch google window we have use index 3
		driver.switchTo().window(windowIDs.get(3));
		// now focus is in google page
		// locate google search field and type some data and click enter
		driver.findElement(By.name("q")).sendKeys("selenium"+Keys.ENTER);
		Thread.sleep(4000);
		
		// automate facebook page
		// now focus is google page i.e. 3rd child window switch that focus to facebook page i.e. 1st child window
		driver.switchTo().window(windowIDs.get(1));
		// now focus is in facebook page
		// locate email or phone filed and type some data then submit the form
		WebElement emailEle = driver.findElement(By.id("email"));
		emailEle.sendKeys("sunshine");
		emailEle.submit();
		Thread.sleep(4000);
		
		// automate youtube page
		// now driver focus is in facebook i.e. 1st child window, switch that focus to youtube page i.e. 2nd child window
		driver.switchTo().window(windowIDs.get(2));
		// now focus is in youtube page
		// locate search field and type some data then click enter
		driver.findElement(By.id("search")).sendKeys("automation using selenium"+Keys.ENTER);
		Thread.sleep(4000);
		
		// automate main window
		// now driver focus is in youtube page i.e 2nd child window, swithc that focus to main window i.e index 0
		driver.switchTo().window(windowIDs.get(0));
		// now focus is in main window
		// locate open tabs button and click on it
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);
		

		driver.quit();
	}

	

}
