package webtablesandcalendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class WebtableDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		WebDriverWait wait = new WebDriverWait(driver, 30);

		// locate table body
//		WebElement tbody = driver.findElement(By.cssSelector("#product>tbody"));
		WebElement tbody = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#product>tbody")));

		// locate all the rows inside the tbody using tr tag
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));

		// iterate over the rows
		// in given site actual table data started from second row onwards
		for (int i = 1; i < rows.size(); i++) {
			// locate the columns or cells in every row using td tag
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// iterate over the cells
			for (int j = 0; j < cells.size(); j++) {
				// retrieve cell text and print on the console
				System.out.print(cells.get(j).getText()+"\t");
			}
			System.out.println();
		}
		
		closeBrowser();

	}

}
