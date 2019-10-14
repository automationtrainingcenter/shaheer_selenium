package waittypes;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import utilities.BrowserHelper;

public class FluentWaitDemo extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "http://www.facebook.com");

//		Function<WebDriver, WebElement> obj = new Function<WebDriver, WebElement>() {
//
//			@Override
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.id("email")); 
//			}
//			
//		};
//		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class)
				.withTimeout(Duration.ofSeconds(60)).pollingEvery(Duration.ofMillis(500));
		
		
		if (wait.until((WebDriver t) -> t.getTitle().contains("Facebook"))) {

			wait.until((WebDriver t) -> t.findElement(By.id("email"))).sendKeys("sunshine");

			wait.until((WebDriver t) -> t.findElement(By.name("reg_email__"))).sendKeys("atc@gmail.com");

			if (wait.until((WebDriver t) -> t.findElement(By.name("reg_email_confirmation__")).isDisplayed())) {
				driver.findElement(By.name("reg_email_confirmation__")).sendKeys("atc@gmail.com");
			}
		}

		closeBrowser();

	}

}
