package screenshots;

import org.openqa.selenium.JavascriptExecutor;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class MultiScreenshotDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://firstcry.com");
		sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// retrieve the scroll height of the page
		long scrollHeight = (long) js.executeScript("return document.documentElement.scrollHeight");
		// retrieve the client height i.e view height of the page
		long viewHeight = (long) js.executeScript("return document.documentElement.clientHeight");
//		System.out.println(scrollHeight+"\n"+viewHeight);
		while(scrollHeight >= 0) {
			ScreenshotHelper.captureScreenshot(driver, "screenshots", "firstcry");
			js.executeScript("document.documentElement.scrollBy(0, arguments[0])", viewHeight);
			scrollHeight -= viewHeight;
			sleep(1000);
		}
		
		closeBrowser();
	}

}
