package autosuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class AmazonDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		sleep(1000);
		WebElement suggestionBox = driver.findElement(By.id("suggestions"));
		List<WebElement> listOfSuggestions = suggestionBox.findElements(By.tagName("div"));
		for (WebElement suggestion : listOfSuggestions) {
//			System.out.println(suggestion.getText());
			if(suggestion.getText().equalsIgnoreCase("iphone 8 cases and covers")) {
				suggestion.click();
				break;
			}
		}
		closeBrowser();
	}

}
