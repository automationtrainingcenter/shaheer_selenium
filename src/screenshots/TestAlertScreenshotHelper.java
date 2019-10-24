package screenshots;

import org.openqa.selenium.By;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class TestAlertScreenshotHelper extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		driver.findElement(By.id("alertbtn")).click();
		ScreenshotHelper.alertScreenCapture("screenshots", "alert");
		driver.switchTo().alert().accept();
		closeBrowser();
	}

}
