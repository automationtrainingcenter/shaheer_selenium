package javascripexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;
import utilities.JavascriptHelper;

public class ScrollByDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		if(wait.until(ExpectedConditions.urlContains("amazon"))) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// scroll page down by 1200 px
			js.executeScript("document.documentElement.scrollBy(0, arguments[0])", 1200);
			sleep(3000);
			// scroll page up by 600 px
			js.executeScript("document.documentElement.scrollBy(0, arguments[0])", -600);
//			JavascriptHelper.executeJavaScript(driver, "document.documentElement.scrollBy(0, arguments[0])", -600);
			sleep(3000);
			closeBrowser();
		}
	}

}
