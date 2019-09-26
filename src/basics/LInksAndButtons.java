package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LInksAndButtons {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate signup button which is implemented using button tag and click on it
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(2000);
		
		// locate forgotten account link and click on it
		driver.findElement(By.linkText("Forgotten account?")).click();
		Thread.sleep(2000);

		// locate search button which is implemented using input tag and click on it
		driver.findElement(By.name("did_submit")).click();
		Thread.sleep(2000);
		
		
		driver.close();
		
	}

}
