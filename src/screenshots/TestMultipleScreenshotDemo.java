package screenshots;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class TestMultipleScreenshotDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.hdfcbank.com/");
		ScreenshotHelper.captureMultipleScreenshots(driver, "screenshots", "hdfc");
		closeBrowser();
	}

}
