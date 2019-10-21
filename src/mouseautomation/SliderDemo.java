package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class SliderDemo extends BrowserHelper {
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.axisbank.com/retail/calculators/fd-calculator");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.urlToBe("https://www.axisbank.com/retail/calculators/fd-calculator"))) {
			sleep(5000);
			WebElement sliderHead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='irs-single']")));
			Actions actions = new Actions(driver);
			actions.clickAndHold(sliderHead).moveByOffset(50, 0).release().build().perform();
			sleep(2000);

		}
		closeBrowser();
	}

}
