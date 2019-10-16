package webtablesandcalendars;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class NSEIndiaDemoOne extends BrowserHelper {

	public static void main(String[] args) {
		String companyCode = "WIPRO";
		openBrowser("chrome",
				"https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.titleContains("National Stock"))) {
			WebElement tbody = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#preOpenNiftyTab>tbody")));
			List<WebElement> rows = tbody.findElements(By.tagName("tr"));
			for (int i = 2; i < rows.size(); i++) {
				List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
				if (cells.get(0).getText().equals(companyCode)) {
					System.out.println("share price of " + companyCode + " = " + cells.get(3).getText());
					cells.get(0).findElement(By.tagName("a")).click();
					break;
				}
			}
//			if (wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
//				Set<String> windowHandles = driver.getWindowHandles();
//				List<String> windowIds = new ArrayList<String>(windowHandles);
//				driver.switchTo().window(windowIds.get(1));
//				wait.until(ExpectedConditions
//						.elementToBeClickable(By.cssSelector("img[src *= 'pre_close_button']"))).click();
//				driver.switchTo().window(windowIds.get(0));
//			}
		}
		closeBrowser();
	}

}
