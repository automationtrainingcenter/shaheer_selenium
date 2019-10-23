package screenshots;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class TestScreenShotHelper extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "http://gmail.com");
		sleep(2000);
		ScreenshotHelper.captureScreenshot(driver, "screenshots", "gmail");
		closeBrowser();
	}
}
