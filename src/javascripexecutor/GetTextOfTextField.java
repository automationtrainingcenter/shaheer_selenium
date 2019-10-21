package javascripexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BrowserHelper;

public class GetTextOfTextField extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("surya");
		/*
		 * selenium provides executeScript() in JavaScriptExecutor interface to run
		 * javascript code type cast WebDriver object reference to JavascriptExecutor
		 * interface reference
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String emailValue = js.executeScript("return document.getElementById('email').value").toString();
		System.out.println(emailValue);
		closeBrowser();
	}

}
