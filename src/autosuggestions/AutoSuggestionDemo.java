package autosuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class AutoSuggestionDemo extends BrowserHelper {
	public static void main(String[] args) {
		String desiredSuggestion = "testng annotations";
		String searchKeyword = "testng";
		openBrowser("chrome", "http://www.google.com");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.urlContains("google"))) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q"))).sendKeys(searchKeyword);
//			WebElement suggestionBox = driver.findElement(By.className("erkvQe"));
			List<WebElement> listOfSuggestions = wait.until(
					ExpectedConditions.presenceOfNestedElementsLocatedBy(By.className("erkvQe"), By.tagName("li")));
//			List<WebElement> listOfSuggestions = suggestionBox.findElements(By.tagName("li"));
			for (WebElement suggestion : listOfSuggestions) {
//				System.out.println(suggestion.getText());
				if (suggestion.getText().equalsIgnoreCase(desiredSuggestion)) {
					suggestion.click();
					break;
				}
			}
		}
		sleep(2000);
		closeBrowser();
	}

}
