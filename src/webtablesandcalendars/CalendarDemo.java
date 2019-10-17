package webtablesandcalendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class CalendarDemo extends BrowserHelper {

	public static void selectDate(String desiredDate, WebElement tbody) {
		// locate the rows
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		boolean status = false;
		for (int i = 0; i < rows.size(); i++) {
			// locate columns in every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cells.size(); j++) {
				if (cells.get(j).getText().contains(desiredDate)) {
					cells.get(j).findElement(By.tagName("button")).click();
					status = true;
					break; // cells loop
				}
			}
			if (status) {
				break; // rows loop
			}
		}
	}

	public static void main(String[] args) {
		openBrowser("chrome", "https://www.expedia.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// locate departing date and click on it
		wait.until(ExpectedConditions.elementToBeClickable(By.id("package-departing-hp-package"))).click();
		WebElement deptTablebody = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody[@class='datepicker-cal-dates'])[1]")));
		selectDate("19", deptTablebody);
		sleep(2000);
		// locate return date and click on it
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("package-returning-hp-package"))).click();
		WebElement retTableBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody[@class='datepicker-cal-dates'])[2]")));
		selectDate("3", retTableBody);
		sleep(3000);
		closeBrowser();
	}

}
