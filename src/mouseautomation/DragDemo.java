package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class DragDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/draggable/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.urlContains("draggable"))) {
			// drag element is in a frame so wait for that frame and switch to it
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			// now driver focus is in frame
			// locate drag element
			WebElement dragElement = driver.findElement(By.id("draggable"));
			//create Actions class object to automate mouse events
			Actions actions = new Actions(driver);
//			actions.clickAndHold(dragElement).moveByOffset(100, 100).release().build().perform();
			actions.dragAndDropBy(dragElement, 100, 100).build().perform();
		}
		sleep(3000);
		closeBrowser();
	}

}
