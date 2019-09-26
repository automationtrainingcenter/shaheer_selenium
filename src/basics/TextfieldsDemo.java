package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextfieldsDemo {
	/*
	 * to automate any text field or text area we have to 
	 * use sendKeys(CharSequence arg) of the WebElement interface
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate first name text filed and type some data
		driver.findElement(By.name("firstname")).sendKeys("sunshine");
		
		
		//locate surname text filed and type some data
		driver.findElement(By.name("lastname")).sendKeys("python");
		
		// locate email address filed and type any valid email address
		driver.findElement(By.name("reg_email__")).sendKeys("surya@gmail.com");
		Thread.sleep(2000);
		
		// locate reenter email address text field and type email address
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("surya@gmail.com");
		
		//locate password text field and type some data
		driver.findElement(By.name("reg_passwd__")).sendKeys("hahathisispassword");
		
		Thread.sleep(4000);
		driver.close();
		
	}

}
