package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		// locate enter your name text filed
		WebElement enterYourNameTextField = driver.findElement(By.id("name"));
		
		// type some data in above text field
		enterYourNameTextField.sendKeys(Keys.chord(Keys.SHIFT, "sunshine"));
		Thread.sleep(1000);
		
		// locate alert button and click on it
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(1000);
		
		// the above button will open an alert so switch driver focus to the alert
//		TargetLocator tl = driver.switchTo();
//		Alert alert = tl.alert();
		Alert alert = driver.switchTo().alert();
		
		//get the alert text and print on console
		System.out.println("alert text = "+alert.getText());
		
		// click on Ok button of the alert using accept() of Alert interface
		alert.accept();
		Thread.sleep(1000);
		
		// type some data in enter your name text filed
		enterYourNameTextField.sendKeys("selenium");
		Thread.sleep(1000);
		
		// locate confirm button and click on it
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		
		// the above button click will open another alert 
		// switch the driver focus from current web page to the alert
		Alert confirmAlert = driver.switchTo().alert();
		
		// get the text messages of confirm alert and print on the console
		System.out.println("confirm alert message is "+confirmAlert.getText());
		
		// click on cancel button of the alert using dismiss()
		confirmAlert.dismiss();
		Thread.sleep(1000);
		
		driver.close();
		
		
	}
}
