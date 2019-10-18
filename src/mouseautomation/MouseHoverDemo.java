package mouseautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class MouseHoverDemo extends BrowserHelper{
	/*
	 * To automate mouse events Selenium provides Actions class which contains
	 * several methods. Whatever the method / action we are calling / performing
	 * those methods must append or call build() and perform()
	 */
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.firstcry.com/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		if(wait.until(ExpectedConditions.titleContains("Products at Firstcry.com"))) {
			WebElement babyClothesLink = driver.findElement(By.xpath("//span[@id='menu1']/preceding-sibling::a"));
			Actions actions = new Actions(driver);
			// moveToElement(WebElement arg) automate mouse hover event
			actions.moveToElement(babyClothesLink).build().perform();
			sleep(1000);
			WebElement babyGirlLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text() = 'Baby Girl ']")));
			actions.moveToElement(babyGirlLink).build().perform();
			sleep(1000);
			WebElement partyWearLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='babygirl_partywear']")));
			actions.moveToElement(partyWearLink).click().build().perform();
		}
		sleep(3000);
		closeBrowser();
	}

}
