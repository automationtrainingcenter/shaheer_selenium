package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckBox {
	/*
	 * to automate any radio button or check box we can 
	 * click() of WebElement interface
	 * we can select single radio button at a time i.e. if we are clicking on a 
	 * radio button it will deselect previously selected radio button
	 * 
	 * we can select multiple check boxes
	 */
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		//locate bmw radio button and select it
		driver.findElement(By.id("bmwradio")).click();
		Thread.sleep(1000);
		
		
		// locate benz radio button and select it
		driver.findElement(By.id("benzradio")).click();
		Thread.sleep(1000);
		
		
		// locate honda radio button and select it
		driver.findElement(By.id("hondaradio")).click();
		Thread.sleep(1000);
		
		
		// locate bmw check box and click on it
		driver.findElement(By.id("bmwcheck")).click();
		Thread.sleep(1000);
		
		// locate benz check box and click on it
		driver.findElement(By.id("benzcheck")).click();
		Thread.sleep(1000);
		
		// locate honda check box and click on it
		driver.findElement(By.id("hondacheck")).click();
		Thread.sleep(2000);
		
		driver.close();
	}

}
