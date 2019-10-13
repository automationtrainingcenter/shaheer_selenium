package waittypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class WaitTypesDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.facebook.com");

		/*
		 * WebDriver interface contains manage() which returns Options interface
		 * reference. In Options interface we have timeouts() which returns TimeOuts
		 * interface reference. This TimeOut interface contains different wait type
		 * methods
		 */
		// pageLoadTimeout()
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// implicitlyWait()
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		driver.findElement(By.name("hahah")).sendKeys("hfgsjhkgd");

		// setScriptTimeout()
//		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if (wait.until(ExpectedConditions.titleContains("Facebook"))) {
			driver.findElement(By.name("email")).sendKeys("adfadfa");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname"))).sendKeys("sunshine");
		}
		closeBrowser();

	}

}
