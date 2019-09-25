package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementCommands {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate first name field
		WebElement firstNameEle = driver.findElement(By.name("firstname"));
		
		// send some data to the first name ele
		// sendKeys(CharSequence arg) is used to type some data in a text field and text
//		area. This method will send data character by character.
		firstNameEle.sendKeys("sunshine");
		Thread.sleep(2000);
		 
//		driver.findElement(By.name("firstname")).sendKeys("sunshine");
		
		// click() is used to click on an element
		driver.findElement(By.cssSelector("input[value='1']")).click();
		Thread.sleep(2000);
		
		// clear() is used to clear existing data in the text field or text area.
		firstNameEle.clear();
		Thread.sleep(2000);
		
		driver.close();
	}

}
