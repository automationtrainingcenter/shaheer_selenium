package javascripexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.BrowserHelper;
import utilities.JavascriptHelper;

public class GetTextOfTextField extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.facebook.com");
		WebElement emailFiled = driver.findElement(By.id("email"));
		emailFiled.sendKeys("surya");
		
		WebElement passwordEle = driver.findElement(By.name("pass"));
		passwordEle.sendKeys("selenium");
		WebElement firstNameEle = driver.findElement(By.name("firstname"));
		firstNameEle.sendKeys(Keys.chord(Keys.SHIFT+"sunshine"));
		sleep(3000);
//		emailFiled.sendKeys("selenium");
		/*
		 * selenium provides executeScript() in JavaScriptExecutor interface to run
		 * javascript code type cast WebDriver object reference to JavascriptExecutor
		 * interface reference
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value = arguments[1]",  emailFiled,"sunshine");
//		String emailValue = js.executeScript("return arguments[0].value", emailFiled).toString();
		
		String emailValue = JavascriptHelper.getEditBoxText(driver, emailFiled);
		System.out.println("email value is "+emailValue);
		String passwordValue = JavascriptHelper.getEditBoxText(driver, passwordEle);
		System.out.println("password value is "+passwordValue );
		String firstNameValue = JavascriptHelper.getEditBoxText(driver, firstNameEle);
		System.out.println("first name value is "+firstNameValue);
		closeBrowser();
	}


}
