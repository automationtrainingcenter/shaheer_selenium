package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class DragAndDropDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/droppable/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.titleIs("Droppable | jQuery UI"))) {
			// switch to frame
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
			// driver focus is inside the frame which contains drag and drop elements
			// locate drag element
			WebElement dragEle = driver.findElement(By.id("draggable"));
			// locate drop element
			WebElement dropEle = driver.findElement(By.id("droppable"));
			// create Actions class object
			Actions actions = new Actions(driver);
//			actions.clickAndHold(dragEle).moveToElement(dropEle).release().build().perform();
			actions.dragAndDrop(dragEle, dropEle).build().perform();
			sleep(3000);
		}
		closeBrowser();
	}

}
