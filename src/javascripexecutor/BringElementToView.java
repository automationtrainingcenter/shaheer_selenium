package javascripexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;
import utilities.JavascriptHelper;

public class BringElementToView extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(wait.until(ExpectedConditions.titleContains("Shopping"))) {
			// locate back to top link
			WebElement navBackTotopLink = driver.findElement(By.id("navBackToTop"));
			// convert webdriver reference to JavaScriptExecutor reference
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView()", navBackTotopLink);
			JavascriptHelper.scrollElementToView(driver, navBackTotopLink);
			sleep(2000);
//			js.executeScript("document.documentElement.scrollBy(0, -200)");
			JavascriptHelper.scrollPage(driver, 0, -200);
			sleep(2000);
			closeBrowser();
		}
	}

}
